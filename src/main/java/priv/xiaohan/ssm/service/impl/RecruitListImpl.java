package priv.xiaohan.ssm.service.impl;

import org.springframework.stereotype.Service;
import priv.xiaohan.ssm.dao.JobFairListDao;
import priv.xiaohan.ssm.model.RecruitList;
import priv.xiaohan.ssm.service.RecruitListService;

import javax.annotation.Resource;

/**
 * Created by HotSauce on 2017/8/23.
 */
@Service("recruitListService")

public class RecruitListImpl implements RecruitListService{

    @Resource
    JobFairListDao jobFairListDao;
    @Override
    public RecruitList getRecruitList() {
         RecruitList recruitList = jobFairListDao.getRecruitList();
        return recruitList;
    }
}
