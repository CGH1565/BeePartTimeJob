package priv.xiaohan.ssm.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HotSauce on 2017/12/5.
 */
public class BeeSummerJobDetailedList implements Serializable{
    public List<BeeSummerJobDetailed> summerJobDetailedBeans;
    public int pages;

    public List<BeeSummerJobDetailed> getSummerJobDetailedBeans() {
        return summerJobDetailedBeans;
    }

    public void setSummerJobDetailedBeans(List<BeeSummerJobDetailed> summerJobDetailedBeans) {
        this.summerJobDetailedBeans = summerJobDetailedBeans;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
