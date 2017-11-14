package priv.xiaohan.ssm.model;

import java.io.Serializable;

/**
 * Created by HotSauce on 2017/9/15.
 */
public class UserMessage implements Serializable{
    private String name;
    private String companyName;
    private String jobName;
    private String phone;
    private char sex;
    private int age;
    private String education;
    private String major;
    private String updateDate;

    public UserMessage() {
    }

    public UserMessage(String name, String companyName, String jobName, String phone, char sex, int age, String education, String major, String updateDate) {
        this.name = name;
        this.companyName = companyName;
        this.jobName = jobName;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.major = major;
        this.updateDate = updateDate;
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
}
