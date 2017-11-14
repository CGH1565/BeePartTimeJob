package priv.xiaohan.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.xiaohan.ssm.exception.ServiceException;
import priv.xiaohan.ssm.jsonbase.BaseResp;
import priv.xiaohan.ssm.jsonbase.LoginReq;
import priv.xiaohan.ssm.model.LoginUser;
import priv.xiaohan.ssm.model.User;
import priv.xiaohan.ssm.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by HotSauce on 2017/7/18.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    public String token;

    @RequestMapping("/test")
    @ResponseBody
    public String registersql(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name =  userService.registerUser(id);
        return name;
    }

     @RequestMapping(value="/register",method = RequestMethod.POST)
    @ResponseBody
    public BaseResp register(@RequestBody User user){
        try {
            if(user == null){
                throw new ServiceException("数据没传");
            }
              userService.Register(user);
        }catch (ServiceException e){
            return BaseResp.createSysErrorResp(e);
        }
            return BaseResp.createSuccessResp();
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public LoginReq login(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        LoginUser loginUser = new LoginUser(userName,password);
        try{
             token = userService.verificationUser(loginUser);
        }catch (ServiceException e){
            return LoginReq.createSysErrorResp(e);
        }
            return LoginReq.createSuccessResp(token);
    }

    @RequestMapping(value = "/news",method = RequestMethod.GET)
    @ResponseBody
    public String news(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("id");
        String timeSamp = request.getParameter("timesamp");
        String sign = request.getParameter("sign");
        String news = userService.requestNews(userId,timeSamp,sign);
        return news;
    }
}
