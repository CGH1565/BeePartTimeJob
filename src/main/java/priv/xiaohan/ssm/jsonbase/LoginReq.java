package priv.xiaohan.ssm.jsonbase;

import java.io.Serializable;

/**
 * Created by HotSauce on 2017/8/2.
 */
public class LoginReq implements Serializable{
    private static final int SUCCESS_CODE = 200;
    private static final int FAIL_CODE = 500;

    private String token;
    private int code;
    private String message;

    private static LoginReq loginReq;
    public LoginReq() {
    }

    public LoginReq(String token, int code, String message) {
        this.token = token;
        this.code = code;
        this.message = message;
    }

    public LoginReq(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginReq{" +
                "token='" + token + '\'' +
                ", code=" + code +
                ", message=" + message +
                '}';
    }

    public static LoginReq createSuccessResp(String token){

        loginReq = new LoginReq(token,SUCCESS_CODE,null);
        return loginReq;
    }


    public static LoginReq createSysErrorResp(Exception e){
        String error = e.getMessage();
        if(org.springframework.util.StringUtils.isEmpty(error)){
            error = "服务器开小差......";
        }
        loginReq = new LoginReq(FAIL_CODE,error);
        return loginReq;
    }
}
