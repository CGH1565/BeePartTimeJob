package priv.xiaohan.ssm.jsonbase;

import java.io.Serializable;

/**
 * Created by HotSauce on 2017/8/17.
 */
public class FairListBaseResponse implements Serializable {
    private int resultCode;
    private String reason;
    private Object jobFairList;

    public FairListBaseResponse(int resultCode, String reason) {
        this.resultCode = resultCode;
        this.reason = reason;
    }

    public FairListBaseResponse(int resultCode, String reason, Object jobFairList) {
        this.resultCode = resultCode;
        this.reason = reason;
        this.jobFairList = jobFairList;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getReason() {
        return reason;
    }

    public Object getJobFairList() {
        return jobFairList;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setJobFairList(Object jobFairList) {
        this.jobFairList = jobFairList;
    }

    public static FairListBaseResponse createSuccessResp() {
        return new FairListBaseResponse(200, "请求成功");
    }

    public static FairListBaseResponse createSuccessResp(Object jobFairList) {
        return new FairListBaseResponse(200, "请求成功", jobFairList);
    }

    public static FairListBaseResponse createSysErrorResp() {
        return new FairListBaseResponse(500, "请求失败");
    }

    public static FairListBaseResponse createSysErrorResp(String message){
        return new FairListBaseResponse(500,message);
    }

    public static FairListBaseResponse createFSysErrorResp() {
        return new FairListBaseResponse(500, "请求失败", null);
    }
}
