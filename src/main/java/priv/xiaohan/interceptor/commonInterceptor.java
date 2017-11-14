package priv.xiaohan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by HotSauce on 2017/8/4.
 */
public class commonInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        Date date2 = dateFormat.parse(date1);
        long date3 = date2.getTime()/1000;
         String url = httpServletRequest.getQueryString();
         System.out.println(url);
         if((url.indexOf("timeSamp")==(-1)&&url.indexOf("sign")==(-1))){
             return false;
         }else if((date3-Integer.parseInt(httpServletRequest.getParameter("timesamp")))>10000){
             return false;
         }
         return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
