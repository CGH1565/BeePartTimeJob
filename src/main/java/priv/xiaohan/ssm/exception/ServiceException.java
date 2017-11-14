package priv.xiaohan.ssm.exception;

/**
 * Created by HotSauce on 2017/7/19.
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String message){
        super(message);
    }
}
