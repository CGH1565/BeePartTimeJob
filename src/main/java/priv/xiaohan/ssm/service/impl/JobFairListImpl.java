package priv.xiaohan.ssm.service.impl;

import org.springframework.stereotype.Service;
import priv.xiaohan.ssm.dao.JobFairListDao;
import priv.xiaohan.ssm.model.JobFairList;
import priv.xiaohan.ssm.service.JobFairListService;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by HotSauce on 2017/8/17.
 */
@Service("jobFairListService")
public class JobFairListImpl implements JobFairListService,Serializable{

    @Resource
    private JobFairListDao jobFairListDao;
    @Override
    public JobFairList getJobFairList() {
        return jobFairListDao.selectJobFairList();
    }
}
