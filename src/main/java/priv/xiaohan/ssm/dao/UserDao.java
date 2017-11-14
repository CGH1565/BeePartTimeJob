package priv.xiaohan.ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.xiaohan.ssm.model.BaseUser;
import priv.xiaohan.ssm.model.LoginUser;
import priv.xiaohan.ssm.model.User;

import java.util.Map;

/**
 * Created by HotSauce on 2017/7/18.
 */
public interface UserDao {

    String selectByPrimaryKey(Integer MID);

    //注册
    void insertUser(User user);

    //检查用户名是否存在
    User loadByUserName(String username);

    //检查用户名是否存在
    User selectUserName(String username);

    //插入User与Token
    void insertUserToken(@Param(value = "username")String username,@Param(value = "token")String token);

}
