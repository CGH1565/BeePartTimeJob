package priv.xiaohan.ssm.service.impl;

import org.springframework.stereotype.Service;
import priv.xiaohan.ssm.dao.AdministratorsDao;
import priv.xiaohan.ssm.model.Administrators;
import priv.xiaohan.ssm.service.AdministratorsService;

import javax.annotation.Resource;

/**
 * Created by HotSauce on 2017/8/29.
 */
@Service("AdministratorsService")
public class AdministratorsImpl implements AdministratorsService{
    @Resource
    AdministratorsDao administratorsDao;
    @Override
    public Boolean selectAdministrators(Administrators administrators) {
        Administrators admin = administratorsDao.selectAdministrators(administrators.getUserName());
        if(admin != null){
            if((administrators.getUserName().equals(admin.getUserName())) && (administrators.getPassWord().equals(admin.getPassWord()))){
                return true;
            }
        }
        return false;
    }


}
