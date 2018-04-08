package priv.xiaohan.ssm.dao;

import org.apache.ibatis.annotations.Param;
import priv.xiaohan.ssm.model.*;

import java.util.List;

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

    /*根据phone查询兼职报名人员*/
    UserMessageList selectJobFairUser(String phone);

    /*兼职报名*/
    void putSignUpJobFair(@Param("userMessage") UserMessage userMessage);

    /*根据UserId查询报名人员*/
    String selectSignUpJobFairByUserId(int UserId);

    /*插入amount*/
    void insertAmount(@Param("amount") String amount,@Param("jobNames") String jobNames,@Param("userId") int userId);

    /*暑期工报名*/
    void putSignUpSummerJob(@Param("userMessage") UserMessage userMessage);

    /*暑期工发布*/
    void publishSummerJob(@Param("beeSummerJobDetailed") BeeSummerJobDetailed beeSummerJobDetailed,@Param("tag") String tag);

    /*兼职发布*/
    void publishJobFair(@Param("beeSummerJobDetailed") BeeSummerJobDetailed beeSummerJobDetailed,@Param("tag") String tag);

    /*分页获取暑期工报名信息*/
    UserMessageList getSignUpSummerJobs(@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    /*获取暑期工报名List*/
    UserMessageList getSignUpSummerJob();

    BeeSummerJobDetailedList AuditingJobFairs(@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    BeeSummerJobDetailedList AuditingJobFair();

    BeeSummerJobDetailedList AuditingSummerJob();

    BeeSummerJobDetailedList AuditingSummerJobs(@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    String selectSignUpJobFairByJIDS(int userId);

    UserMessageList selectSummerJobUser(String phone);

    String selectSignUpSummerJobByJIDS(int userId);

    String selectSignUpSummerJobByUserId(int userId);

    void insertAmount1(String jids, String jobNameS, int userId);

    int getSid(int id);

    int getJid(int id);

    void putOpenId(@Param("openId") Object openId,@Param("targetId") int targetId);

    BeeJobTime getAuditingBeeJobTimeByOpenId(String openId);

    BeeJobTime getAuditingBeeJobTimesByOpenId(@Param("openId") String openId, @Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    BeeJobTime getBeeJobTimesByOpenId(@Param("openId") String openId, @Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    BeeJobTime getBeeJobTimeByOpenId(String openId);

    int selectIsGet(int i);

    UserMessageList getSignUpJobFairsByJid();

    UserMessageList getSignUpJobFairByJid(@Param("jid") String jid,@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    int selectargetId(String openId);

    BeeJobTimeDetailed getAuditingBeeJobTimeDetailed(int jid);

    int selectOpenId(Object openId);

    Object selectOpenIds(Object openId);

    List<Integer> getJidByOpenId(String openId);

    void getJobTimeUserByJid(List<Integer> jid);

    String getJidsByOpenId(String openId);

    BeeJobTime getJobTimeByOpenId(@Param("jidS") List<String> jidS);

    BeeJobTime getBeeJobTimesByOpenIds(int startIndex, int endAmount);

    String getJidsByJid(int i);

    String[] getJids();
}
