package priv.xiaohan.ssm.service.impl;

import jdk.nashorn.internal.parser.Token;
import org.springframework.stereotype.Service;
import priv.xiaohan.ssm.dao.UserDao;
import priv.xiaohan.ssm.exception.ServiceException;
import priv.xiaohan.ssm.model.BaseUser;
import priv.xiaohan.ssm.model.LoginUser;
import priv.xiaohan.ssm.model.User;
import priv.xiaohan.ssm.service.IUserService;
import priv.xiaohan.ssm.utils.ShowSign;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by HotSauce on 2017/7/18.
 */
@Service("userService")
public class UserService implements IUserService,Serializable {

    @Resource
    private UserDao userdao;

    private void throwError(String msg) {
        throw new ServiceException(msg);
    }

    @Override
    public String registerUser(int id) {
        return userdao.selectByPrimaryKey(id);
    }

    @Override
    public void Register(User user) {
        User loadUser = userdao.loadByUserName(user.getUserName());
        if (loadUser != null) {
            throwError("用户名已存在");
        } else {
            //插入用户表
            userdao.insertUser(user);
        }
    }

    @Override
    public String verificationUser(LoginUser user) {
        User loadUser = userdao.loadByUserName(user.getUserName());
        if (loadUser == null) {
            throwError("用户不存在");
        } else if (!(user.getPassword().equals(loadUser.getPassword()))) {
            throwError("用户密码错误");
        }
        String token = UUID.randomUUID().toString();
        token = token.toUpperCase();

        userdao.insertUserToken(user.getUserName(), token);

            /*Map<String, Object> userToken = new HashMap<>();
            userToken.put("username", user.getUserName());
            userToken.put("token", token);
            Map<String,Map<String,Object>> param = new HashMap<>();
            param.put("keys",userToken);
            userdao.insertUserToken(param);*/

        return token;
    }

    @Override
    public String requestNews(String userId, String timeSamp, String sign) throws Exception {
        //时间戳生成
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        Date date2 = dateFormat.parse(date1);
        long date3 = date2.getTime()/1000;

        //生成sign
        String token = "F04D6CCF-B934-412C-B5D5-4C9BA54AEFE9";
        String params ="id="+userId+"&timeSamp="+date3+"&token="+token;
        String minSign = ShowSign.getSign(params);
        if(minSign.equals(sign)){
            return "hahahahah";
        }
        return "无法访问";
    }
}
