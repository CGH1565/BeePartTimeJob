package priv.xiaohan.ssm.model;

import java.io.Serializable;

/**
 * Created by HotSauce on 2017/9/15.
 */
public class UserMessage implements Serializable{
    private int userId;
    private String name;
    private String companyName;
    private String jobName;
    private String phone;
    private char sex;
    private int age;
    private String education;
    private String major;
    private String updateDate;
    private int jId;
    private int sId;

    public UserMessage() {
    }

    public UserMessage(int userId, String name, String companyName, String jobName, String phone, char sex, int age, String education, String major, String updateDate, int jId, int sId) {
        this.userId = userId;
        this.name = name;
        this.companyName = companyName;
        this.jobName = jobName;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.major = major;
        this.updateDate = updateDate;
        this.jId = jId;
        this.sId = sId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getjId() {
        return jId;
    }

    public void setjId(int jId) {
        this.jId = jId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }
}
