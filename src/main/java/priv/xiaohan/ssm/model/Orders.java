package priv.xiaohan.ssm.model;

import java.io.Serializable;

/**
 * Created by HotSauce on 2017/8/22.
 */
public class Orders implements Serializable{
    private int mid;
    private int fid;
    private String  companyName;
    private String jobList;
    private String linkMan;
    private String phone;
    private String memo;
    private String state;
    private String updateDate;
    private String title;

    public Orders() {
    }

    public Orders(int mid, int fid, String companyName, String jobList, String linkMan, String phone, String memo, String state, String updateDate, String title) {
        this.mid = mid;
        this.fid = fid;
        this.companyName = companyName;
        this.jobList = jobList;
        this.linkMan = linkMan;
        this.phone = phone;
        this.memo = memo;
        this.state = state;
        this.updateDate = updateDate;
        this.title = title;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobList() {
        return jobList;
    }

    public void setJobList(String jobList) {
        this.jobList = jobList;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
