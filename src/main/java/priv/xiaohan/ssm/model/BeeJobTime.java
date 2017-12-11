package priv.xiaohan.ssm.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HotSauce on 2017/9/15.
 */
public class BeeJobTime implements Serializable{
    public List<BeeJobTimeBean> jobTimeBeans;

    public int pages;
    public static class BeeJobTimeBean {
        private int jId;
        private String companyName;
        private String jobName;
        private String mans;
        private String salary;
        private String salaryType;
        private String workPlaceName;
        private String address;
        private String jobDesc;
        private String workTime;
        private String linkMan;
        private String mobilePhone;
        private String updateDate;

        public int getjId() {
            return jId;
        }

        public void setjId(int jId) {
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

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getSalaryType() {
            return salaryType;
        }

        public void setSalaryType(String salaryType) {
            this.salaryType = salaryType;
        }

        public String getWorkPlaceName() {
            return workPlaceName;
        }

        public void setWorkPlaceName(String workPlaceName) {
            this.workPlaceName = workPlaceName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<BeeJobTimeBean> getJobTimeBeans() {
        return jobTimeBeans;
    }

    public void setJobTimeBeans(List<BeeJobTimeBean> jobTimeBeans) {
        this.jobTimeBeans = jobTimeBeans;
    }
}
