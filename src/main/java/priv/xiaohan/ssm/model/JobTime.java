package priv.xiaohan.ssm.model;

import java.io.Serializable;

/**
 * Created by HotSauce on 2017/9/12.
 */
public class JobTime implements Serializable{
    private int jId;
    private String companyName;
    private String jobName;
    private String mans;
    private String salaryType;
    private String salary;
    private String address;
    private String workPlaceName;
    private String jobDesc;
    private String workTime;
    private String linkMan;
    private String mobilePhone;
    private String updateDate;

    public JobTime() {
    }

    public JobTime(int jId, String companyName, String jobName, String mans, String salaryType, String salary, String address, String workPlaceName, String jobDesc, String workTime, String linkMan, String mobilePhone, String updateDate) {
        this.jId = jId;
        this.companyName = companyName;
        this.jobName = jobName;
        this.mans = mans;
        this.salaryType = salaryType;
        this.salary = salary;
        this.address = address;
        this.workPlaceName = workPlaceName;
        this.jobDesc = jobDesc;
        this.workTime = workTime;
        this.linkMan = linkMan;
        this.mobilePhone = mobilePhone;
        this.updateDate = updateDate;
    }

    public int getJid() {
        return jId;
    }

    public void setJid(int jId) {
        this.jId = jId;
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

    public String getMans() {
        return mans;
    }

    public void setMans(String mans) {
        this.mans = mans;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkPlaceName() {
        return workPlaceName;
    }

    public void setWorkPlaceName(String workPlaceName) {
        this.workPlaceName = workPlaceName;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
