package priv.xiaohan.ssm.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HotSauce on 2017/8/23.
 */
public class RecruitList implements Serializable {
    private List<RecruitBean> recruitBeanList;

    public List<RecruitBean> getRecruitBeanList() {
        return recruitBeanList;
    }

    public void setRecruitBeanList(List<RecruitBean> recruitBeanList) {
        this.recruitBeanList = recruitBeanList;
    }

    public static class RecruitBean {
        private String jobName;
        private String treatMent;
        private String updateDate;
        private String workPlace;
        private String companyName;
        private String age;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getJobName() {
            return jobName;
        }

        public void setJobName(String jobName) {
            this.jobName = jobName;
        }


        public String getTreatMent() {
            return treatMent;
        }

        public void setTreatMent(String treatMent) {
            this.treatMent = treatMent;
        }


        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }


        public String getWorkPlace() {
            return workPlace;
        }

        public void setWorkPlace(String workPlace) {
            this.workPlace = workPlace;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public RecruitBean() {
        }

        public RecruitBean(String jobName, String treatMent, String updateDate, String workPlace, String companyName, String age) {
            this.jobName = jobName;
            this.treatMent = treatMent;
            this.updateDate = updateDate;
            this.workPlace = workPlace;
            this.companyName = companyName;
            this.age = age;
        }
    }
}
