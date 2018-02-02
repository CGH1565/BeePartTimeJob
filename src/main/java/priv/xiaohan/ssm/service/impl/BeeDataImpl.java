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
    public UserMessageList selectJobFairUser(String phone) {
        return beeDataDao.selectJobFairUser(phone);
    }

    @Override
    public UserMessageList selectSummerJobUser(String phone) {
        return beeDataDao.selectSummerJobUser(phone);
    }

    @Override
    public void putSignUpJobFair(UserMessage userMessaged) {
        beeDataDao.putSignUpJobFair(userMessaged);
    }

    @Override
    public void putSignUpSummerJob(UserMessage userMessage) {
        beeDataDao.putSignUpSummerJob(userMessage);
    }

    @Override
    public void publishSummerJob(BeeSummerJobDetailed beeSummerJobDetailed,String tag) {
        beeDataDao.publishSummerJob(beeSummerJobDetailed,tag);
    }

    @Override
    public void publishJobFair(BeeSummerJobDetailed beeSummerJobDetailed,String tag) {
        beeDataDao.publishJobFair(beeSummerJobDetailed,tag);
    }

    @Override
    public String selectSignUpJobFairByUserId(int userId) {
        return beeDataDao.selectSignUpJobFairByUserId(userId);
    }

    @Override
    public void insertAmount(String amount,String jobNames,int userId) {
        beeDataDao.insertAmount(amount,jobNames,userId);
    }

    @Override
    public String selectSignUpJobFairByJIDS(int userId) {
        return beeDataDao.selectSignUpJobFairByJIDS(userId);
    }

    @Override
    public String selectSignUpSummerJobByUserId(int userId) {
        return beeDataDao.selectSignUpSummerJobByUserId(userId);
    }

    @Override
    public String selectSignUpSummerJobByJIDS(int userId) {
        return beeDataDao.selectSignUpSummerJobByJIDS(userId);
    }

    @Override
    public void insertAmount1(String jids, String jobNameS, int userId) {
        beeDataDao.insertAmount1(jids,jobNameS,userId);
    }

    @Override
    public int getId(int id) {
        int id1 = 0;
        if(id == 0){
          id1 =  beeDataDao.getJid(id);
        }else {
           id1 = beeDataDao.getSid(id);
        }
        return id1;
    }
}
