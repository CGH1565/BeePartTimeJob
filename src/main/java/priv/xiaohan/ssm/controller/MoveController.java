package priv.xiaohan.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.xiaohan.ssm.exception.ServiceException;
import priv.xiaohan.ssm.jsonbase.FairListBaseResponse;
import priv.xiaohan.ssm.model.*;
import priv.xiaohan.ssm.service.BeeDataService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by HotSauce on 2017/9/15.
 */
@Controller
@RequestMapping("/data")
public class MoveController {

    @Resource
    public BeeDataService beeDataService;

    public BeeJobTime beeJobTime;

    public BeeJobTimes beeJobTimes;

    public BeeSummerJob beeSummerJob;

    public BeeJobTimeDetailed beeJobTimeDetailed;

    public BeeSummerJobDetailed beeSummerJobDetailed;

    /*获取兼职数据*/
    @RequestMapping(value = "/getBeeJobTime",method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getBeeJobTime(HttpServletRequest request){
        try{
            beeJobTime = beeDataService.getBeeJobTime();
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeJobTime);
    }

    /*分页获取兼职数据*/
    @RequestMapping(value="/getBeeJobTimes",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse getBeeJobTimes(int page){
        try{
            int pageIndex = page;
            int pageSize = 4;
            int rowCount = 0;
            int pages = 0;
            beeJobTime = beeDataService.getBeeJobTime();
            rowCount = beeJobTime.getJobTimeBeans().size();
            if(rowCount%pageSize != 0){
                pages = rowCount/pageSize+1;
            }else{
                pages = rowCount/pageSize;
            }
            beeJobTimes = beeDataService.getBeeJobTimes(pageIndex,pageSize);
            beeJobTimes.setPages(pages);
            beeJobTimes.toString();
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeJobTimes);
    }
    /*获取暑期工数据*/
    @RequestMapping(value = "/getBeeSummerJob",method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getBeeSummerJob(HttpServletRequest request){
        try{
            beeSummerJob = beeDataService.getBeeSummerJob();
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeSummerJob);
    }

    /*根据JID获取兼职详细信息*/
    @RequestMapping(value = "/getBeeJobTimeDetailed",method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getBeeJobTimeDetailed(HttpServletRequest request){
        try{
            int jid = Integer.parseInt(request.getParameter("jId"));
            beeJobTimeDetailed = beeDataService.getBeeJobTimeDetailed(jid);
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeJobTimeDetailed);
    }

    /*根据SID获取暑假工详细信息*/
    @RequestMapping(value = "/getBeeSummerJobDetailed",method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getBeeSummerJobDetailed(HttpServletRequest request){
        try{
            int sid = Integer.parseInt(request.getParameter("sId"));
            beeSummerJobDetailed = beeDataService.getBeeSummerJobDetailed(sid);
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeSummerJobDetailed);
    }

    /*兼职报名*/
    @RequestMapping(value = "/signUpJobFair",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse putSignUpJobFair(@RequestBody UserMessage userMessage){
        try{
            beeDataService.putSignUpJobFair(userMessage);
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp();
    }

    /*暑期工报名*/
    @RequestMapping(value = "/signUpSummerJob",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse putSignUpSummerJob(@RequestBody UserMessage userMessage){
        try{
            beeDataService.putSignUpSummerJob(userMessage);
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp();
    }

    /*暑期工发布*/
    @RequestMapping(value = "/publishSummerJob",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse publishSummerJob(@RequestBody BeeSummerJobDetailed beeSummerJobDetailed){
        try{
            if(beeSummerJobDetailed.getJobFairStyle().equals("暑期工")){
            beeDataService.publishSummerJob(beeSummerJobDetailed);}
            else {
                beeDataService.publishJobFair(beeSummerJobDetailed);
            }
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp();
    }
}
