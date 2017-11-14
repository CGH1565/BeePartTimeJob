package priv.xiaohan.ssm.service;

import priv.xiaohan.ssm.model.BaseUser;
import priv.xiaohan.ssm.model.LoginUser;
import priv.xiaohan.ssm.model.User;

/**
 * Created by HotSauce on 2017/7/18.
 */
public interface IUserService {
     String registerUser(int id);

    //用户注册
     void Register(User user);

    //用户登陆验证
     String verificationUser(LoginUser user);

    //获取新闻信息
    String requestNews(String userId,String timeSamp,String sign) throws Exception;
}
