package priv.xiaohan.ssm.dao;

import priv.xiaohan.ssm.model.JobFairList;
import priv.xiaohan.ssm.model.Orders;
import priv.xiaohan.ssm.model.RecruitList;

/**
 * Created by HotSauce on 2017/8/17.
 */
public interface JobFairListDao {
    //查询招聘会列表
    JobFairList selectJobFairList();
    //通过招聘会名查找招聘会ID
    int selectJobFairMid(String Title);
    //插入企业定展信息
    void putOrder(Orders order);
    //查询兼职信息列表
    RecruitList getRecruitList();
}