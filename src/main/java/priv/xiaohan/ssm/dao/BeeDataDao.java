package priv.xiaohan.ssm.dao;

import org.apache.ibatis.annotations.Param;
import priv.xiaohan.ssm.model.*;

/**
 * Created by HotSauce on 2017/9/15.
 */
public interface BeeDataDao {

    /*获取兼职数据*/
    BeeJobTime getBeeJobTime();

    /*分页获取兼职数据*/
    BeeJobTime getBeeJobTimes(@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    /*获取暑期工数据*/
    BeeSummerJob getBeeSummerJob();

    /*分页获取暑期工数据*/
    BeeSummerJob getBeeSummerJobs(@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    /*根据JID获取兼职详细信息*/
    BeeJobTimeDetailed getBeeJobTimeDetailed(int jid);

    /*根据SID获取兼职详细信息*/
    BeeSummerJobDetailed getSummerJobDetailed(int sid);

    /*分页获取兼职报名信息*/
    UserMessageList getSignUpJobFairs(@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    /*获取兼职报名List*/
    UserMessageList getSignUpJobFair();

    /*兼职报名*/
    void putSignUpJobFair(UserMessage userMessage);

    /*暑期工报名*/
    void putSignUpSummerJob(UserMessage userMessage);

    /*暑期工发布*/
    void publishSummerJob(BeeSummerJobDetailed beeSummerJobDetailed);

    /*兼职发布*/
    void publishJobFair(BeeSummerJobDetailed beeSummerJobDetailed);

    /*分页获取暑期工报名信息*/
    UserMessageList getSignUpSummerJobs(@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    /*获取暑期工报名List*/
    UserMessageList getSignUpSummerJob();

    BeeSummerJobDetailedList AuditingJobFairs(@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    BeeSummerJobDetailedList AuditingJobFair();

    BeeSummerJobDetailedList AuditingSummerJob();

    BeeSummerJobDetailedList AuditingSummerJobs(@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);
}
