package priv.xiaohan.ssm.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HotSauce on 2017/12/1.
 */
public class UserMessageList implements Serializable{
    public List<UserMessage> userMessageBeans;
    public int pages ;

    public List<UserMessage> getUserMessageBeans() {
        return userMessageBeans;
    }

    public void setUserMessageBeans(List<UserMessage> userMessageBeans) {
        this.userMessageBeans = userMessageBeans;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
