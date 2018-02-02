package priv.xiaohan.ssm.jsonbase;

import priv.xiaohan.ssm.model.BeeJobTime;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HotSauce on 2018/1/8.
 */
public class FairListResponse implements Serializable{
    public PageAll pageAll;
    public Object arr;

    public static class PageAll {
        private int currentPage;
        private int count;

        public PageAll(int currentPage, int count) {
            this.currentPage = currentPage;
            this.count = count;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public FairListResponse() {
    }

    public FairListResponse(PageAll pageAll, Object arr) {
        this.pageAll = pageAll;
        this.arr = arr;
    }

    public PageAll getPageAll() {
        return pageAll;
    }

    public void setPageAll(PageAll pageAll) {
        this.pageAll = pageAll;
    }

    public Object getArr() {
        return arr;
    }

    public void setArr(Object arr) {
        this.arr = arr;
    }
}
