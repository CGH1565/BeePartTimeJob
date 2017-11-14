package priv.xiaohan.ssm.dao;

import org.apache.ibatis.annotations.Param;
import priv.xiaohan.ssm.model.*;

import java.util.List;

/**
 * Created by HotSauce on 2017/8/29.
 */
public interface AdministratorsDao {
   //查询管理员是否存在
   Administrators selectAdministrators(String userName);

   //添加兼职信息
   void addJobTime(JobTime jobTimeBean);

   //更新兼职信息
   void upDateJobTime(JobTimes jobTime);

   //根据ID删除兼职管理的数据
   void deleteJobTime(int JID);

   //批量删除兼职管理的数据
   void deleteJobTimeList(@Param("ids")List<String> ids);

   //添加暑期工信息
   void addSummerJob(SummerJob summerJob);

   //更新暑期工兼职信息
   void upDateSummerJob(SummerJob summerJob);

   //根据ID删除暑期工管理的数据
   void deleteSummerJob(int JID);

   //批量删除暑期工管理的数据
   void deleteSummerJobList(@Param("ids")List<String> ids);

   //根据ID删除应聘管理的数据
   void deleteFairJobOffer(int JID);

   //根据ID删除应聘管理的数据
   void deleteSummerJobOffer(int JID);

   //批量删除应聘管理的数据
   void deleteOfferList(@Param("ids")List<String> ids);

   //管理员添加操作
   void addAdmin(AdministratorsS administratorss);

   //管理员修改操作
   void reviseAdmin(AdministratorsS administratorsS);
   //管理员删除操作
   void deleteAdmin(int JID);

   //根据ID删除审核暑期工管理的数据
   void auditingDeleteSummerJob(int JID);

   //批量删除暑期工审核管理的数据
   void auditingDeleteSummerJobList(@Param("ids")List<String> ids);

   //批量获取暑期工审核数据
   BeeSummerJob getAuditingSummerJobList(@Param("ids")List<String> ids);

   //批量获取兼职审核数据
   BeeJobTime getAuditingJobFairList(@Param("ids")List<String> ids);

   //批量插入暑期工审核数据
   void insertAuditingSummerJobList(@Param("beeSummerJobBeans")List<BeeSummerJob.BeeSummerJobBean> beeSummerJobBeans);

   //批量插入兼职审核数据
   void insertAuditingJobFairList(@Param("beeJobTimeBeans")List<BeeJobTime.BeeJobTimeBean> beeJobTimeBeans);

   //根据ID删除审核兼职管理的数据
   void auditingDeleteJobFair(int JID);

   //更新暑期工审核信息
   void auditingUpdateSummerJob(SummerJob summerJob);

   //更新兼职审核信息
   void auditingUpdateJobFair(JobTimes jobTime);

   //批量删除兼职审核管理的数据
   void auditingDeleteJobFairList(@Param("ids")List<String> ids);

}
