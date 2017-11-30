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
    public BeeJobTimes getBeeJobTimes(int pageIndex, int pageSize) {
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
    public BeeJobTimeDetailed getBeeJobTimeDetailed(int jid) {
        return beeDataDao.getBeeJobTimeDetailed(jid);
    }

    @Override
    public BeeSummerJobDetailed getBeeSummerJobDetailed(int sid) {
        return beeDataDao.getSummerJobDetailed(sid);
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
