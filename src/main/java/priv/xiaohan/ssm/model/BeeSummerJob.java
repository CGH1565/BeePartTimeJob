package priv.xiaohan.ssm.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HotSauce on 2017/9/15.
 */
public class BeeSummerJob implements Serializable {

    public  List<BeeSummerJobBean> SummerJobBeans;

    public static class BeeSummerJobBean {
        private String sId;
        private String companyName;
        private String jobName;
        private String manS;
        private String workPlaceName;
        private String jobDesc;
        private String linkMan;
        private String mobilePhone;
        private String address;
        private String salary;
        private String updateDate;
        private String workTime;

        public String getWorkTime() {
            return workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        public String getsId() {
            return sId;
        }

        public void setsId(String sId) {
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

        public String getManS() {
            return manS;
        }

        public void setManS(String manS) {
            this.manS = manS;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

    }

    public  List<BeeSummerJobBean> getSummerJobBeans() {
        return SummerJobBeans;
    }

    public void setSummerJobBeans(List<BeeSummerJobBean> summerJobBeans) {
        SummerJobBeans = summerJobBeans;
    }
}
