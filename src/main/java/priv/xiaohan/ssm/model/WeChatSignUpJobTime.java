package priv.xiaohan.ssm.model;

import java.io.Serializable;

/**
 * Created by HotSauce on 2018/2/26.
 */
public class WeChatSignUpJobTime implements Serializable{
    private String page;
    private String jid;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }
}
