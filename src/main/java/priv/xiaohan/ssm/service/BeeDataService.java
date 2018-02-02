package priv.xiaohan.ssm.service;

import priv.xiaohan.ssm.model.*;

/**
 * Created by HotSauce on 2017/9/15.
 */
public interface BeeDataService {
    /*获取兼职数据*/
    BeeJobTime getBeeJobTime();

    /*分页获取兼职数据*/
    BeeJobTime getBeeJobTimes(int pageIndex,int pageSize);

    /*获取暑期工数据*/
    BeeSummerJob getBeeSummerJob();

    /*分页获取暑期工数据*/
    BeeSummerJob getBeeSummerJobs(int pageIndex,int pageSize);

    /*根据JID获取兼职详细信息*/
    BeeJobTimeDetailed getBeeJobTimeDetailed(int jid);

    /*根据SID获取兼职详细信息*/
    BeeSummerJobDetailed getBeeSummerJobDetailed(int sId);

    /*分页获取兼职报名信息*/
    UserMessageList getSignUpJobFairs(int pageIndex,int pageSize);

    /*获取兼职报名List*/
    UserMessageList getSignUpJobFair();

    /*获取暑期工报名List*/
    UserMessageList getSignUpSummerJob();

    /*分页获取暑期工报名信息*/
    UserMessageList getSignUpSummerJobs(int pageIndex,int pageSize);

    /*获取兼职审核信息*/
    BeeSummerJobDetailedList AuditingJobFair();

    /*分页获取兼职审核信息*/
    BeeSummerJobDetailedList AuditingJobFairs(int pageIndex,int pageSize);

    /*获取暑期工审核信息*/
    BeeSummerJobDetailedList AuditingSummerJob();

    /*分页获取暑期工审核信息*/
    BeeSummerJobDetailedList AuditingSummerJobs(int pageIndex,int pageSize);

    /*根据phone查询兼职报名人员*/
    UserMessageList selectJobFairUser(String phone);

    /*根据phone查询暑期工报名人员*/
    UserMessageList selectSummerJobUser(String phone);
    /*兼职报名*/
    void putSignUpJobFair(UserMessage userMessage);

    /*暑期工报名*/
    void putSignUpSummerJob(UserMessage userMessage);

    /*暑期工发布*/
    void publishSummerJob(BeeSummerJobDetailed beeSummerJobDetailed,String tag);

    /*兼职发布*/
    void publishJobFair(BeeSummerJobDetailed beeSummerJobDetailed,String tag);

    /*获取JIDS*/
    String selectSignUpJobFairByUserId(int userId);

    /*插入JIDS*/
    void insertAmount(String amount,String jobNames,int userId);

    String selectSignUpJobFairByJIDS(int userId);

    String selectSignUpSummerJobByUserId(int userId);

    String selectSignUpSummerJobByJIDS(int userId);

    void insertAmount1(String jids, String jobNameS, int userId);

    /*获取兼职或暑期工数据ID*/
    int getId(int id);
}
