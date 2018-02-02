package priv.xiaohan.interceptor;

import org.omg.IOP.ServiceContext;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import priv.xiaohan.ssm.model.Administrators;
import sun.misc.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

import static java.awt.SystemColor.window;

/**
 * Created by HotSauce on 2017/9/1.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private List<String> excludedUrls;

    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludedUrls = excludeUrls;
    }

    /*
    * Handler执行之前调用这个方法*/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletRequest.setCharacterEncoding("UTF-8");
        StringBuffer url = httpServletRequest.getRequestURL();
        String url1 = url.toString();
        if(!url1.equals("")){
            Administrators administrators = (Administrators) httpServletRequest.getSession().getAttribute("userName");
            if(administrators == null){
               httpServletResponse.sendRedirect("/views/login.jsp");
                System.out.println("未登录，请重新登陆");
                return false;
            }
        }
        return true;
    }

    /*
    * Handler执行之后，ModelAndView返回之前调用这个方法*/
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /*
    * Handler执行完成之后调用这个方法*/
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
