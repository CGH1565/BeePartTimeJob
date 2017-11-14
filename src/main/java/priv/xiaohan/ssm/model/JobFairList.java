package priv.xiaohan.ssm.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HotSauce on 2017/8/17.
 */
public class JobFairList implements Serializable {

    public List<JobFairBean> listBean;

    public static class JobFairBean {

        public String fairDate;
        public String title;
        public String address;
        public String bus;

        public String getFairDate() {
            return fairDate;
        }

        public String getTitle() {
            return title;
        }

        public String getAddress() {
            return address;
        }

        public String getBus() {
            return bus;
        }

        public void setFairDate(String fairDate) {
            this.fairDate = fairDate;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setBus(String bus) {
            this.bus = bus;
        }

    }
}
