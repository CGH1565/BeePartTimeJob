package priv.xiaohan.ssm.service.impl;

import org.springframework.stereotype.Service;
import priv.xiaohan.ssm.dao.AdministratorsDao;
import priv.xiaohan.ssm.model.*;
import priv.xiaohan.ssm.service.JobTimeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by HotSauce on 2017/9/4.
 */
@Service("jobTimeService")
public class JobTimeImpl implements JobTimeService {
    @Resource
    AdministratorsDao administratorsDao;

    @Override
    public void addJobTime(JobTime jobTimeBean) {
        administratorsDao.addJobTime(jobTimeBean);
    }

    @Override
    public void upDateJobTime(JobTimes jobTime) {
        administratorsDao.upDateJobTime(jobTime);
    }


    @Override
    public void deleteJobTime(int id) {
        administratorsDao.deleteJobTime(id);
    }

    @Override
    public void deleteJobTimeList(List<String> jobtimeIDs) {
        administratorsDao.deleteJobTimeList(jobtimeIDs);
    }

    @Override
    public void addSummerJob(SummerJob summerJob) {
        administratorsDao.addSummerJob(summerJob);
    }

    @Override
    public void updateSummerJob(SummerJob summerJob) {
        administratorsDao.upDateSummerJob(summerJob);
    }

    @Override
    public void auditingUpdateSummerJob(SummerJob summerJob) {
        administratorsDao.auditingUpdateSummerJob(summerJob);
    }

    @Override
    public void auditingUpdateJobFair(JobTimes jobTime) {
        administratorsDao.auditingUpdateJobFair(jobTime);
    }

    @Override
    public void deleteSummerJob(int id) {
        administratorsDao.deleteSummerJob(id);
    }

    @Override
    public void auditingDeleteSummerJob(int id) {
        administratorsDao.auditingDeleteSummerJob(id);
    }

    @Override
    public void deleteSummerJobList(List<String> summerJobIDs) {
        administratorsDao.deleteSummerJobList(summerJobIDs);
    }

    @Override
    public void auditingDeleteSummerJobList(List<String> summerJobIDs) {
        administratorsDao.auditingDeleteSummerJobList(summerJobIDs);
    }

    @Override
    public void auditingDeleteJobFairList(List<String> jobtimeID) {
        administratorsDao.auditingDeleteJobFairList(jobtimeID);
    }

    @Override
    public void auditingDeleteJobFair(int id) {
        administratorsDao.auditingDeleteJobFair(id);
    }


    public BeeSummerJob getAuditingSummerJobList(List<String> summerJobIDs){
        return administratorsDao.getAuditingSummerJobList(summerJobIDs);

    }

    public void insertAuditingSummerJobList(BeeSummerJob beeSummerJob){
        List<BeeSummerJob.BeeSummerJobBean> summerJobBeans = beeSummerJob.getSummerJobBeans();
        administratorsDao.insertAuditingSummerJobList(summerJobBeans);
    }
    @Override
    public void auditingSummerJobList(List<String> summerJobIDs) {
        BeeSummerJob beeSummerJob = getAuditingSummerJobList(summerJobIDs);
        insertAuditingSummerJobList(beeSummerJob);
        auditingDeleteSummerJobList(summerJobIDs);

    }

    public BeeJobTime getAuditingJobFairList(List<String> jobtimeIDs){
        return administratorsDao.getAuditingJobFairList(jobtimeIDs);

    }

    public void insertAuditingJobFairList(BeeJobTime jobtimeIDs){
        List<BeeJobTime.BeeJobTimeBean> beeJobTimeBeans = jobtimeIDs.getJobTimeBeans();
        administratorsDao.insertAuditingJobFairList(beeJobTimeBeans);
    }

    @Override
    public void auditingJobFairList(List<String> jobtimeIDs) {
        BeeJobTime beeJobTime = getAuditingJobFairList(jobtimeIDs);
        insertAuditingJobFairList(beeJobTime);
        auditingDeleteJobFairList(jobtimeIDs);

    }

    @Override
    public void deleteFariJobOffer(int id) {
        administratorsDao.deleteFairJobOffer(id);
    }

    @Override
    public void deleteSummerJobOffer(int id) {
        administratorsDao.deleteSummerJobOffer(id);
    }

    @Override
    public void deleteJobFairOfferList(List<String> offerIDs) {
        administratorsDao.deleteJobFairOfferList(offerIDs);
    }

    @Override
    public void deleteSummerJobOfferList(List<String> offerIDs) {
        administratorsDao.deleteSummerJobOfferList(offerIDs);
    }

    @Override
    public void addAdmin(AdministratorsS administratorss) {
        administratorsDao.addAdmin(administratorss);
    }

    @Override
    public void reviseAdmin(AdministratorsS administratorsS) {
        administratorsDao.reviseAdmin(administratorsS);
    }

    @Override
    public void deleteAdmin(int id) {
        administratorsDao.deleteAdmin(id);
    }

    @Override
    public void auditingHideJobFairList(String styles, String aValue, String id) {
        administratorsDao.auditingHideJobFairList(styles,aValue,id);
    }
}
