package priv.xiaohan.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.xiaohan.ssm.dao.BeeDataDao;
import priv.xiaohan.ssm.exception.ServiceException;
import priv.xiaohan.ssm.jsonbase.FairListBaseResponse;
import priv.xiaohan.ssm.jsonbase.FairListResponse;
import priv.xiaohan.ssm.model.*;
import priv.xiaohan.ssm.service.BeeDataService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by HotSauce on 2017/9/15.
 */
@Controller
@RequestMapping("/data")
public class MoveController {

    @Resource
    public BeeDataService beeDataService;

    public BeeJobTime beeJobTime;

    public BeeSummerJob beeSummerJob;

    public BeeJobTimeDetailed beeJobTimeDetailed;

    public BeeSummerJobDetailed beeSummerJobDetailed;

    public BeeDataDao beeDataDao;

    public FairListResponse.PageAll pageAll;


    private UserMessageList userMessageList;
    private BeeSummerJobDetailedList beeSummerJobDetailedList;
    private FairListResponse fairListResponse;


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
    @RequestMapping(value = "/splitBeeJobTimes",method = RequestMethod.GET)
    @ResponseBody
    public FairListResponse splitBeeJobTimes(HttpServletRequest request) {
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            fairListResponse = new FairListResponse();
            int pageIndex = 0;
            int pageSize = 8;
            int rowCount = 0;
            int pages = 0;
            pageIndex = page;
            beeJobTime = beeDataService.getBeeJobTime();
            rowCount = beeJobTime.getJobTimeBeans().size();
            if (rowCount < pageSize) {
                pages = 1;
            } else if (rowCount % pageSize != 0) {
                pages = rowCount / pageSize + 1;
            } else {
                pages = rowCount / pageSize;
            }
            beeJobTime = beeDataService.getBeeJobTimes(pageIndex, pageSize);
            FairListResponse.PageAll pageAll = new FairListResponse.PageAll(page,pages);
            beeJobTime.setPages(pages);
            fairListResponse.setArr(beeJobTime);
            fairListResponse.setPageAll(pageAll);
            return fairListResponse;
        } catch (ServiceException e) {
        }
       return fairListResponse;
    }

    /*分页获取暑期工数据*/
    @RequestMapping(value = "/splitBeeSummerJob",method = RequestMethod.GET)
    @ResponseBody
    public FairListResponse splitBeeSummerJob(HttpServletRequest request) {
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            fairListResponse = new FairListResponse();
            int pageIndex = 0;
            int pageSize = 8;
            int rowCount = 0;
            int pages = 0;
            pageIndex = page;
            beeSummerJob = beeDataService.getBeeSummerJob();
            rowCount = beeSummerJob.getSummerJobBeans().size();
            if (rowCount < pageSize) {
                pages = 1;
            } else if (rowCount % pageSize != 0) {
                pages = rowCount / pageSize + 1;
            } else {
                pages = rowCount / pageSize;
            }
            beeSummerJob = beeDataService.getBeeSummerJobs(pageIndex, pageSize);
            FairListResponse.PageAll pageAll = new FairListResponse.PageAll(page,pages);
            beeSummerJob.setPages(pages);
            fairListResponse.setArr(beeSummerJob);
            fairListResponse.setPageAll(pageAll);
            return fairListResponse;
        } catch (ServiceException e) {
        }
        return fairListResponse;
    }

    /*分页获取兼职数据*/
    @RequestMapping(value="/getBeeJobTimes",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse getBeeJobTimes(int page){
        try{
            int pageIndex = 0;
            int pageSize = 15;
            int rowCount = 0;
            int pages = 0;
            pageIndex = page;
            beeJobTime = beeDataService.getBeeJobTime();
            rowCount = beeJobTime.getJobTimeBeans().size();
            if(rowCount<pageSize){
                pages = 1;
            }else if(rowCount%pageSize != 0){
                pages = rowCount/pageSize+1;
            }else{
                pages = rowCount/pageSize;
            }
            beeJobTime = beeDataService.getBeeJobTimes(pageIndex,pageSize);
            beeJobTime.setPages(pages);

        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeJobTime);
    }


    /*分页获取暑期工数据*/
    @RequestMapping(value="/getBeeSummerJobs",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse getBeeSummerJobs(int page){
        try{
            int pageIndex = 0;
            int pageSize = 15;
            int rowCount = 0;
            int pages = 0;
            pageIndex = page;
            beeSummerJob = beeDataService.getBeeSummerJob();
            rowCount = beeSummerJob.getSummerJobBeans().size();
            if(rowCount<pageSize){
                pages = 1;
            }else if(rowCount%pageSize != 0){
                pages = rowCount/pageSize+1;
            }else{
                pages = rowCount/pageSize;
            }
            beeSummerJob = beeDataService.getBeeSummerJobs(pageIndex,pageSize);
            beeSummerJob.setPages(pages);
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeSummerJob);
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

    /*分页获取兼职报名信息*/
    @RequestMapping(value="/getSignUpJobFairs",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse getSignUpJobFairs(int page) {
        try {
            int pageIndex = 0;
            int pageSize = 15;
            int rowCount = 0;
            int pages = 0;
            pageIndex = page;
            userMessageList = beeDataService.getSignUpJobFair();
            rowCount = userMessageList.getUserMessageBeans().size();
            if (rowCount < pageSize) {
                pages = 1;
            } else if (rowCount % pageSize != 0) {
                pages = rowCount / pageSize + 1;
            } else {
                pages = rowCount / pageSize;
            }
            userMessageList = beeDataService.getSignUpJobFairs(pageIndex, pageSize);
            userMessageList.setPages(pages);
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(userMessageList);
    }

    /*获取兼职报名List*/
    @RequestMapping(value = "/getSignUpJobFair",method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getSignUpJobFair(HttpServletRequest request){
        try{
            userMessageList = beeDataService.getSignUpJobFair();
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(userMessageList);
    }

    /*分页获取兼职报名信息*/
    @RequestMapping(value="/getSignUpSummerJobs",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse getSignUpSummerJobs(int page) {
        try {
            int pageIndex = 0;
            int pageSize = 15;
            int rowCount = 0;
            int pages = 0;
            pageIndex = page;
            userMessageList = beeDataService.getSignUpSummerJob();
            rowCount = userMessageList.getUserMessageBeans().size();
            if (rowCount < pageSize) {
                pages = 1;
            } else if (rowCount % pageSize != 0) {
                pages = rowCount / pageSize + 1;
            } else {
                pages = rowCount / pageSize;
            }
            userMessageList = beeDataService.getSignUpSummerJobs(pageIndex, pageSize);
            userMessageList.setPages(pages);
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(userMessageList);
    }

    /*获取暑期工报名List*/
    @RequestMapping(value = "/getSignUpSummerJob",method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getSignUpSummerJob(HttpServletRequest request){
        try{
            userMessageList = beeDataService.getSignUpSummerJob();
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(userMessageList);
    }

    /*兼职报名*/
    @RequestMapping(value = "/signUpJobFair",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse putSignUpJobFair(@RequestBody UserMessage userMessage){
        try{
            UserMessageList userMessageList = beeDataService.selectJobFairUser(userMessage.getPhone());
            if(userMessageList == null){
                beeDataService.putSignUpJobFair(userMessage);
                return FairListBaseResponse.createSuccessResp();
            }else {
                for (UserMessage userMessage1 : userMessageList.getUserMessageBeans()) {
                    if(userMessage1.getjId() == (userMessage.getjId())){
                        return FairListBaseResponse.createSysErrorResp("已投递该职位，请勿重复投递！");
                    }
                }
            }
            String JIDs = beeDataService.selectSignUpJobFairByUserId(userMessageList.getUserMessageBeans().get(0).getUserId());
            String JIDS = JIDs+"/"+userMessage.getjId();
            String JobNames = beeDataService.selectSignUpJobFairByJIDS(userMessageList.getUserMessageBeans().get(0).getUserId());
            String JobNameS = JobNames+"/"+userMessage.getJobName();
            beeDataService.insertAmount(JIDS,JobNameS,userMessageList.getUserMessageBeans().get(0).getUserId());
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
            UserMessageList userMessageList = beeDataService.selectSummerJobUser(userMessage.getPhone());
            if(userMessageList == null){
                beeDataService.putSignUpSummerJob(userMessage);
                return FairListBaseResponse.createSuccessResp();
            }else {
                for (UserMessage userMessage1 : userMessageList.getUserMessageBeans()) {
                    if(userMessage1.getjId() == (userMessage.getjId())){
                        return FairListBaseResponse.createSysErrorResp("已投递该职位，请勿重复投递！");
                    }
                }
            }
            String JIDs = beeDataService.selectSignUpSummerJobByUserId(userMessageList.getUserMessageBeans().get(0).getUserId());
            String JIDS = JIDs+"/"+userMessage.getjId();
            String JobNames = beeDataService.selectSignUpSummerJobByJIDS(userMessageList.getUserMessageBeans().get(0).getUserId());
            String JobNameS = JobNames+"/"+userMessage.getJobName();
            beeDataService.insertAmount1(JIDS,JobNameS,userMessageList.getUserMessageBeans().get(0).getUserId());
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp();
    }

    /*分页兼职审核信息*/
    @RequestMapping(value="/AuditingJobFairs",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse AuditingJobFairs(int page) {
        try {
            int pageIndex = 0;
            int pageSize = 15;
            int rowCount = 0;
            int pages = 0;
            pageIndex = page;
            beeSummerJobDetailedList = beeDataService.AuditingJobFair();
            rowCount = beeSummerJobDetailedList.getSummerJobDetailedBeans().size();
            if (rowCount < pageSize) {
                pages = 1;
            } else if (rowCount % pageSize != 0) {
                pages = rowCount / pageSize + 1;
            } else {
                pages = rowCount / pageSize;
            }
            beeSummerJobDetailedList = beeDataService.AuditingJobFairs(pageIndex, pageSize);
            beeSummerJobDetailedList.setPages(pages);
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeSummerJobDetailedList);
    }
    /*分页暑期工审核信息*/
    @RequestMapping(value="/AuditingSummerJobs",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse AuditingSummerJobs(int page) {
        try {
            int pageIndex = 0;
            int pageSize = 15;
            int rowCount = 0;
            int pages = 0;
            pageIndex = page;
            beeSummerJobDetailedList = beeDataService.AuditingSummerJob();
            rowCount = beeSummerJobDetailedList.getSummerJobDetailedBeans().size();
            if (rowCount < pageSize) {
                pages = 1;
            } else if (rowCount % pageSize != 0) {
                pages = rowCount / pageSize + 1;
            } else {
                pages = rowCount / pageSize;
            }
            beeSummerJobDetailedList = beeDataService.AuditingSummerJobs(pageIndex, pageSize);
            beeSummerJobDetailedList.setPages(pages);
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeSummerJobDetailedList);
    }
    /*暑期工、兼职发布*/
    @RequestMapping(value = "/publishSummerJob",method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse publishSummerJob(@RequestBody BeeSummerJobDetailed beeSummerJobDetailed, HttpServletRequest request){
        try{
            String tag;
            if(beeSummerJobDetailed.getCheck().size() == 0){
                tag = "false";
            }else{
                tag = beeSummerJobDetailed.getCheck().get(0);
            }
            if(tag.equals("true")){
                beeSummerJobDetailed.setaValue("显示联系");
            }else {
                beeSummerJobDetailed.setaValue("隐藏联系");
            }
            if(beeSummerJobDetailed.getJobFairStyle().equals("暑假工")){
            beeDataService.publishSummerJob(beeSummerJobDetailed,tag);}
            else {
                beeDataService.publishJobFair(beeSummerJobDetailed,tag);
            }
        }catch (ServiceException e){
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp();
    }
}
