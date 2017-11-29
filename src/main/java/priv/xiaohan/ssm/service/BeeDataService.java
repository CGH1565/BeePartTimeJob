package priv.xiaohan.ssm.service;

import priv.xiaohan.ssm.model.*;

/**
 * Created by HotSauce on 2017/9/15.
 */
public interface BeeDataService {
    /*获取兼职数据*/
    BeeJobTime getBeeJobTime();

    /*分页获取兼职数据*/
    BeeJobTimes getBeeJobTimes(int pageIndex,int pageSize);

    /*获取暑期工数据*/
    BeeSummerJob getBeeSummerJob();

    /*根据JID获取兼职详细信息*/
    BeeJobTimeDetailed getBeeJobTimeDetailed(int jid);

    /*根据SID获取兼职详细信息*/
    BeeSummerJobDetailed getBeeSummerJobDetailed(int sId);

    /*兼职报名*/
    void putSignUpJobFair(UserMessage userMessage);

    /*暑期工报名*/
    void putSignUpSummerJob(UserMessage userMessage);

    /*暑期工发布*/
    void publishSummerJob(BeeSummerJobDetailed beeSummerJobDetailed);

    /*兼职发布*/
    void publishJobFair(BeeSummerJobDetailed beeSummerJobDetailed);
}
