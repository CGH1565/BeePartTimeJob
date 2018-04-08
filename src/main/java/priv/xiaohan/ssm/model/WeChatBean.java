package priv.xiaohan.ssm.model;

import java.io.Serializable;

/**
 * Created by HotSauce on 2018/2/3.
 */
public class WeChatBean implements Serializable{
    private String code;
    private String encryptedData;
    private String iv;
    private int targetId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

}
