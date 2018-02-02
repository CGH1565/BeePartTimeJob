package priv.xiaohan.ssm.service;

import priv.xiaohan.ssm.model.*;

import java.util.List;

/**
 * Created by HotSauce on 2017/9/4.
 */
public interface JobTimeService {

    /*添加兼职数据*/
    void addJobTime(JobTime jobTimeBean);

    /*更新兼职信息*/
    void upDateJobTime(JobTimes jobTime);

    /*单条删除兼职数据*/
    void deleteJobTime(int id);

    /*批量删除兼职数据*/
    void deleteJobTimeList(List<String> jobtimeIDs);


    /*添加暑期工数据*/
    void addSummerJob(SummerJob summerJob);

    /*更新暑期工数据*/
    void updateSummerJob(SummerJob summerJob);

    /*更新审核暑期工数据*/
    void auditingUpdateSummerJob(SummerJob summerJob);

    /*更新审核兼职数据*/
    void auditingUpdateJobFair(JobTimes jobTime);

    /*单条删除暑期工数据*/
    void deleteSummerJob(int id);

    /*批量删除暑期工数据*/
    void deleteSummerJobList(List<String> summerJobIDs);

    /*单条删除兼职应聘管理数据*/
    void deleteFariJobOffer(int id);

    /*单挑删除暑期工应聘管理数据*/
    void deleteSummerJobOffer(int id);

    /*批量删除兼职应聘管理数据*/
    void deleteJobFairOfferList(List<String> offerIDs);

    /*批量删除暑期工应聘管理数据*/
    void deleteSummerJobOfferList(List<String> offerIDs);


    /*单条删除审核暑期工数据*/
    void auditingDeleteSummerJob(int id);

    /*批量插入审核暑期工数据*/
    void auditingSummerJobList(List<String> summerJobIDs);

    /*批量插入审核兼职数据*/
    void auditingJobFairList(List<String> jobtimeIDs);

    /*批量删除暑期工审核数据*/
    void auditingDeleteSummerJobList(List<String> summerJobIDs);

    /*批量删除兼职审核数据*/
    void auditingDeleteJobFairList(List<String> jobtimeIDs);

    /*删除兼职审核数据*/
    void auditingDeleteJobFair(int id);

    /*管理员添加操作*/
    void addAdmin(AdministratorsS administratorss);

    /*管理员修改操作*/
    void reviseAdmin(AdministratorsS administratorsS);

    /*管理员删除操作*/
    void deleteAdmin(int id);

    /*批量隐藏兼职审核信息*/
    void auditingHideJobFairList(String styles,String aValue,String id);
}
