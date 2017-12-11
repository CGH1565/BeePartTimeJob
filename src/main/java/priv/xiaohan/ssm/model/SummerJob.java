package priv.xiaohan.ssm.model;

import java.io.Serializable;

/**
 * Created by HotSauce on 2017/9/13.
 */
public class SummerJob implements Serializable{
    private int sId;
    private String companyName;
    private String jobName;
    private String mans;
    private String salary;
    private String address;
    private String workPlaceName;
    private String jobDesc;
    private String linkMan;
    private String mobilePhone;
    private String updateDate;

    public SummerJob() {
    }

    public SummerJob(int sId, String companyName, String jobName, String mans, String salary, String address, String workPlaceName, String jobDesc, String linkMan, String mobilePhone, String updateDate) {
        this.sId = sId;
        this.companyName = companyName;
        this.jobName = jobName;
        this.mans = mans;
        this.salary = salary;
        this.address = address;
        this.workPlaceName = workPlaceName;
        this.jobDesc = jobDesc;
        this.linkMan = linkMan;
        this.mobilePhone = mobilePhone;
        this.updateDate = updateDate;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
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
