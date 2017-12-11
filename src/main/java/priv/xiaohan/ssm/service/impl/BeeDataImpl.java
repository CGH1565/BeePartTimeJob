package priv.xiaohan.ssm.service.impl;

import org.springframework.stereotype.Service;
import priv.xiaohan.ssm.dao.BeeDataDao;
import priv.xiaohan.ssm.model.*;
import priv.xiaohan.ssm.service.BeeDataService;

import javax.annotation.Resource;

/**
 * Created by HotSauce on 2017/9/15.
 */
@Service("beeDataService")
public class BeeDataImpl implements BeeDataService{
    @Resource
    BeeDataDao beeDataDao;
    @Override
    public BeeJobTime getBeeJobTime() {
        return beeDataDao.getBeeJobTime();
    }

    @Override
    public BeeJobTime getBeeJobTimes(int pageIndex, int pageSize) {
        int startIndex = 0;
        if(pageSize == 1){
            startIndex = 0;
        }else{
           startIndex = (pageIndex-1) * pageSize;
        }
        int endAmount = pageSize;
        return beeDataDao.getBeeJobTimes(startIndex,endAmount);
    }

    @Override
    public BeeSummerJob getBeeSummerJob() {
        return beeDataDao.getBeeSummerJob();
    }

    @Override
    public BeeSummerJob getBeeSummerJobs(int pageIndex, int pageSize) {
        int startIndex = 0;
        if(pageSize == 1){
            startIndex = 0;
        }else{
            startIndex = (pageIndex-1) * pageSize;
        }
        int endAmount = pageSize;
        return beeDataDao.getBeeSummerJobs(startIndex,endAmount);
    }

    @Override
    public BeeJobTimeDetailed getBeeJobTimeDetailed(int jid) {
        return beeDataDao.getBeeJobTimeDetailed(jid);
    }

    @Override
    public BeeSummerJobDetailed getBeeSummerJobDetailed(int sid) {
        return beeDataDao.getSummerJobDetailed(sid);
    }

    @Override
    public UserMessageList getSignUpJobFairs(int pageIndex,int pageSize) {
        int startIndex = 0;
        if(pageSize == 1){
            startIndex = 0;
        }else{
            startIndex = (pageIndex-1) * pageSize;
        }
        int endAmount = pageSize;
        return beeDataDao.getSignUpJobFairs(startIndex,endAmount);
    }

    @Override
    public UserMessageList getSignUpJobFair() {
        return beeDataDao.getSignUpJobFair();
    }

    @Override
    public UserMessageList getSignUpSummerJob() {
        return beeDataDao.getSignUpSummerJob();
    }

    @Override
    public UserMessageList getSignUpSummerJobs(int pageIndex,int pageSize) {
        int startIndex = 0;
        if(pageSize == 1){
            startIndex = 0;
        }else{
            startIndex = (pageIndex-1) * pageSize;
        }
        int endAmount = pageSize;
        return beeDataDao.getSignUpSummerJobs(startIndex,endAmount);
    }

    @Override
    public BeeSummerJobDetailedList AuditingJobFair() {
        return beeDataDao.AuditingJobFair();
    }

    @Override
    public BeeSummerJobDetailedList AuditingJobFairs(int pageIndex, int pageSize) {
        int startIndex = 0;
        if(pageSize == 1){
            startIndex = 0;
        }else{
            startIndex = (pageIndex-1) * pageSize;
        }
        int endAmount = pageSize;
        return beeDataDao.AuditingJobFairs(startIndex,endAmount);
    }

    @Override
    public BeeSummerJobDetailedList AuditingSummerJob() {
        return beeDataDao.AuditingSummerJob();
    }

    @Override
    public BeeSummerJobDetailedList AuditingSummerJobs(int pageIndex, int pageSize) {
        int startIndex = 0;
        if(pageSize == 1){
            startIndex = 0;
        }else{
            startIndex = (pageIndex-1) * pageSize;
        }
        int endAmount = pageSize;
        return beeDataDao.AuditingSummerJobs(startIndex,endAmount);
    }

    @Override
    public void putSignUpJobFair(UserMessage userMessage) {
        beeDataDao.putSignUpJobFair(userMessage);
    }

    @Override
    public void putSignUpSummerJob(UserMessage userMessage) {
        beeDataDao.putSignUpSummerJob(userMessage);
    }

    @Override
    public void publishSummerJob(BeeSummerJobDetailed beeSummerJobDetailed) {
        beeDataDao.publishSummerJob(beeSummerJobDetailed);
    }

    @Override
    public void publishJobFair(BeeSummerJobDetailed beeSummerJobDetailed) {
        beeDataDao.publishJobFair(beeSummerJobDetailed);
    }
}
