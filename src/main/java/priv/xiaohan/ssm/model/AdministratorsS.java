package priv.xiaohan.ssm.model;

import java.io.Serializable;

/**
 * Created by HotSauce on 2017/9/14.
 */
public class AdministratorsS implements Serializable {
    private String id;
    private String userName;
    private String usedPassword;
    private String passWord;
    private String repeatPassword;

    public AdministratorsS() {
    }

    public AdministratorsS(String id, String userName, String usedPassword, String passWord, String repeatPassword) {
        this.id = id;
        this.userName = userName;
        this.usedPassword = usedPassword;
        this.passWord = passWord;
        this.repeatPassword = repeatPassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsedPassword() {
        return usedPassword;
    }

    public void setUsedPassword(String usedPassword) {
        this.usedPassword = usedPassword;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
