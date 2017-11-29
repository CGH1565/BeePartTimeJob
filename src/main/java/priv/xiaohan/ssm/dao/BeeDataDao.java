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
    BeeJobTimes getBeeJobTimes(@Param("startIndex") int startIndex, @Param("endAmount") int endAmount);

    /*获取暑期工数据*/
    BeeSummerJob getBeeSummerJob();

    /*根据JID获取兼职详细信息*/
    BeeJobTimeDetailed getBeeJobTimeDetailed(int jid);

    /*根据SID获取兼职详细信息*/
    BeeSummerJobDetailed getSummerJobDetailed(int sid);

    /*兼职报名*/
    void putSignUpJobFair(UserMessage userMessage);

    /*暑期工报名*/
    void putSignUpSummerJob(UserMessage userMessage);

    /*暑期工发布*/
    void publishSummerJob(BeeSummerJobDetailed beeSummerJobDetailed);

    /*兼职发布*/
    void publishJobFair(BeeSummerJobDetailed beeSummerJobDetailed);
}
