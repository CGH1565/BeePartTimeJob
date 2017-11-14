package priv.xiaohan.ssm.jsonbase;

import com.mysql.jdbc.StringUtils;

import java.io.Serializable;

/**
 * Created by HotSauce on 2017/7/19.
 */
public class BaseResp implements Serializable{

    private static final int SUCCESS_CODE =200 ;
    private static final int Fail_CODE = 500;

    private static BaseResp baseResp;

    private int code;
    private String restr;

    public static BaseResp createSuccessResp(){
        if(baseResp != null){
            return baseResp;
        }
        baseResp = new BaseResp(SUCCESS_CODE,"hahahah");
        return baseResp;
    }

    public int getCode() {
        return code;
    }

    public String getRestr() {
        return restr;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setRestr(String restr) {
        this.restr = restr;
    }

    public static BaseResp createSysErrorResp(Exception e){
        String error = e.getMessage();
        if(org.springframework.util.StringUtils.isEmpty(error)){
            error = "服务器开小差......";
        }
        baseResp = new BaseResp(Fail_CODE,error);
        return baseResp;
    }

    public BaseResp(int code, String restr) {
        this.code = code;
        this.restr = restr;
    }
}
