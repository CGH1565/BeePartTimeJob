package priv.xiaohan.ssm.service.impl;

import org.springframework.stereotype.Service;
import priv.xiaohan.ssm.dao.JobFairListDao;
import priv.xiaohan.ssm.jsonbase.FairListBaseResponse;

import priv.xiaohan.ssm.model.Orders;
import priv.xiaohan.ssm.service.OrderService;

import javax.annotation.Resource;

/**
 * Created by HotSauce on 2017/8/19.
 */

@Service("orderService")
public class OrderImpl implements OrderService {
    @Resource
    JobFairListDao jobFairListDao;

    @Override
    public void putOrder(Orders order) {
        int fid = jobFairListDao.selectJobFairMid(order.getTitle());
        order.setFid(fid);
        jobFairListDao.putOrder(order);
    }
}
