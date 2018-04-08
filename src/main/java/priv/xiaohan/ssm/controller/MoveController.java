package priv.xiaohan.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.Base64;
import org.codehaus.xfire.util.*;
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
import priv.xiaohan.ssm.utils.UrlUtil;
import priv.xiaohan.ssm.utils.WXAppletUserInfo;

import javax.annotation.Resource;
import javax.jms.Session;
import javax.json.JsonObject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by HotSauce on 2017/9/15.
 */
@Controller
@RequestMapping("/data")
public class MoveController {

    @Resource
    public BeeDataService beeDataService;

    public BeeJobTime beeJobTime;

    public BeeJobTime beeJobTime1;
    public BeeSummerJob beeSummerJob;

    public BeeJobTimeDetailed beeJobTimeDetailed;

    public BeeSummerJobDetailed beeSummerJobDetailed;

    public BeeDataDao beeDataDao;

    public FairListResponse.PageAll pageAll;


    private UserMessageList userMessageList;
    private UserMessageList userMessageList1;
    private BeeSummerJobDetailedList beeSummerJobDetailedList;
    private FairListResponse fairListResponse;


    /*获取兼职数据*/
    @RequestMapping(value = "/getBeeJobTime", method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getBeeJobTime(HttpServletRequest request) {
        try {
            beeJobTime = beeDataService.getBeeJobTime();
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeJobTime);
    }


    /*分页获取兼职数据*/
    @RequestMapping(value = "/splitBeeJobTimes", method = RequestMethod.GET)
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
            FairListResponse.PageAll pageAll = new FairListResponse.PageAll(page, pages);
            beeJobTime.setPages(pages);
            fairListResponse.setArr(beeJobTime);
            fairListResponse.setPageAll(pageAll);
            return fairListResponse;
        } catch (ServiceException e) {
        }
        return fairListResponse;
    }

    /*分页获取暑期工数据*/
    @RequestMapping(value = "/splitBeeSummerJob", method = RequestMethod.GET)
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
            FairListResponse.PageAll pageAll = new FairListResponse.PageAll(page, pages);
            beeSummerJob.setPages(pages);
            fairListResponse.setArr(beeSummerJob);
            fairListResponse.setPageAll(pageAll);
            return fairListResponse;
        } catch (ServiceException e) {
        }
        return fairListResponse;
    }

    /*分页获取兼职数据*/
    @RequestMapping(value = "/getBeeJobTimes", method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse getBeeJobTimes(int page) {
        try {
            int pageIndex = 0;
            int pageSize = 15;
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
            beeJobTime.setPages(pages);

        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeJobTime);
    }


    /*分页获取暑期工数据*/
    @RequestMapping(value = "/getBeeSummerJobs", method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse getBeeSummerJobs(int page) {
        try {
            int pageIndex = 0;
            int pageSize = 15;
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
            beeSummerJob.setPages(pages);
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeSummerJob);
    }

    /*获取暑期工数据*/
    @RequestMapping(value = "/getBeeSummerJob", method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getBeeSummerJob(HttpServletRequest request) {
        try {
            beeSummerJob = beeDataService.getBeeSummerJob();
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeSummerJob);
    }

    /*根据JID获取兼职详细信息*/
    @RequestMapping(value = "/getBeeJobTimeDetailed", method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getBeeJobTimeDetailed(HttpServletRequest request) {
        try {
            int jid = Integer.parseInt(request.getParameter("jId"));
            beeJobTimeDetailed = beeDataService.getBeeJobTimeDetailed(jid);
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeJobTimeDetailed);
    }
   /*根据JID获取未审核兼职详细信息*/
    @RequestMapping(value = "/getAuditingBeeJobTimeDetailed", method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getAuditingBeeJobTimeDetailed(HttpServletRequest request) {
        try {
            int jid = Integer.parseInt(request.getParameter("jId"));
            beeJobTimeDetailed = beeDataService.getAuditingBeeJobTimeDetailed(jid);
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeJobTimeDetailed);
    }

    /*根据SID获取暑假工详细信息*/
    @RequestMapping(value = "/getBeeSummerJobDetailed", method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getBeeSummerJobDetailed(HttpServletRequest request) {
        try {
            int sid = Integer.parseInt(request.getParameter("sId"));
            beeSummerJobDetailed = beeDataService.getBeeSummerJobDetailed(sid);
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(beeSummerJobDetailed);
    }

    /*分页获取兼职报名信息*/
    @RequestMapping(value = "/getSignUpJobFairs", method = RequestMethod.POST)
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
    @RequestMapping(value = "/getSignUpJobFair", method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getSignUpJobFair(HttpServletRequest request) {
        try {
            userMessageList = beeDataService.getSignUpJobFair();
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(userMessageList);
    }

    /*分页获取兼职报名信息*/
    @RequestMapping(value = "/getSignUpSummerJobs", method = RequestMethod.POST)
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
    @RequestMapping(value = "/getSignUpSummerJob", method = RequestMethod.GET)
    @ResponseBody
    public FairListBaseResponse getSignUpSummerJob(HttpServletRequest request) {
        try {
            userMessageList = beeDataService.getSignUpSummerJob();
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp(userMessageList);
    }

    /*兼职报名*/
    @RequestMapping(value = "/signUpJobFair", method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse putSignUpJobFair(@RequestBody UserMessage userMessage) {
        try {
            String openId = userMessage.getOpenId();
            int targetId = beeDataService.selectargetId(openId);
            if(targetId == 2){
                return FairListBaseResponse.createSysErrorResp("企业请勿投递!");
            }
            UserMessageList userMessageList = beeDataService.selectJobFairUser(userMessage.getPhone());
            if (userMessageList == null) {
                beeDataService.putSignUpJobFair(userMessage);
                return FairListBaseResponse.createSuccessResp();
            } else {
                for (UserMessage userMessage1 : userMessageList.getUserMessageBeans()) {
                    if (userMessage1.getjId() == (userMessage.getjId())) {
                        return FairListBaseResponse.createSysErrorResp("请勿重复投递！");
                    }
                }
            }
            String JIDs = beeDataService.selectSignUpJobFairByUserId(userMessageList.getUserMessageBeans().get(0).getUserId());
            String JIDS = JIDs + "/" + userMessage.getjId();
            String JobNames = beeDataService.selectSignUpJobFairByJIDS(userMessageList.getUserMessageBeans().get(0).getUserId());
            String JobNameS = JobNames + "/" + userMessage.getJobName();
            beeDataService.insertAmount(JIDS, JobNameS, userMessageList.getUserMessageBeans().get(0).getUserId());
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp();
    }

    /*暑期工报名*/
    @RequestMapping(value = "/signUpSummerJob", method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse putSignUpSummerJob(@RequestBody UserMessage userMessage) {
        try {
            UserMessageList userMessageList = beeDataService.selectSummerJobUser(userMessage.getPhone());
            if (userMessageList == null) {
                beeDataService.putSignUpSummerJob(userMessage);
                return FairListBaseResponse.createSuccessResp();
            } else {
                for (UserMessage userMessage1 : userMessageList.getUserMessageBeans()) {
                    if (userMessage1.getjId() == (userMessage.getjId())) {
                        return FairListBaseResponse.createSysErrorResp("已投递该职位，请勿重复投递！");
                    }
                }
            }
            String JIDs = beeDataService.selectSignUpSummerJobByUserId(userMessageList.getUserMessageBeans().get(0).getUserId());
            String JIDS = JIDs + "/" + userMessage.getjId();
            String JobNames = beeDataService.selectSignUpSummerJobByJIDS(userMessageList.getUserMessageBeans().get(0).getUserId());
            String JobNameS = JobNames + "/" + userMessage.getJobName();
            beeDataService.insertAmount1(JIDS, JobNameS, userMessageList.getUserMessageBeans().get(0).getUserId());
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp();
    }

    /*分页兼职审核信息*/
    @RequestMapping(value = "/AuditingJobFairs", method = RequestMethod.POST)
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
    @RequestMapping(value = "/AuditingSummerJobs", method = RequestMethod.POST)
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
    @RequestMapping(value = "/publishSummerJob", method = RequestMethod.POST)
    @ResponseBody
    public FairListBaseResponse publishSummerJob(@RequestBody BeeSummerJobDetailed beeSummerJobDetailed, HttpServletRequest request) {
        try {
            String tag;
            if (beeSummerJobDetailed.getCheck().size() == 0) {
                tag = "false";
            } else {
                tag = beeSummerJobDetailed.getCheck().get(0);
            }
            if (tag.equals("true")) {
                beeSummerJobDetailed.setaValue("显示联系");
            } else {
                beeSummerJobDetailed.setaValue("隐藏联系");
            }
            if (beeSummerJobDetailed.getJobFairStyle().equals("暑假工")) {
                beeDataService.publishSummerJob(beeSummerJobDetailed, tag);
            } else {
                beeDataService.publishJobFair(beeSummerJobDetailed, tag);
            }
        } catch (ServiceException e) {
            return FairListBaseResponse.createSysErrorResp();
        }
        return FairListBaseResponse.createSuccessResp();
    }

    /*根据openId获取对应的未审核兼职数据*/
    @RequestMapping(value = "/AuditingJobFairsByOpenId",method = RequestMethod.POST)
    @ResponseBody
    public FairListResponse AuditingJobFairsByOpenId(@RequestBody WeChatJobTime data) {
        try {
            String openId = data.getOpenId();
            String page = data.getPages();
            fairListResponse = new FairListResponse();
            int pageIndex = 0;
            int pageSize = 5;
            int rowCount = 0;
            int pages = 0;
            pageIndex = Integer.parseInt(page);
            beeJobTime = beeDataService.getAuditingBeeJobTimeByOpenId(openId);
            rowCount = beeJobTime.getJobTimeBeans().size();
            if (rowCount < pageSize) {
                pages = 1;
            } else if (rowCount % pageSize != 0) {
                pages = rowCount / pageSize + 1;
            } else {
                pages = rowCount / pageSize;
            }
            beeJobTime = beeDataService.getAuditingBeeJobTimesByOpenId(openId,pageIndex,pageSize);
            FairListResponse.PageAll pageAll = new FairListResponse.PageAll(Integer.parseInt(page), pages);
            beeJobTime.setPages(pages);
            fairListResponse.setArr(beeJobTime);
            fairListResponse.setPageAll(pageAll);
            return fairListResponse;
        } catch (ServiceException e) {
        }
        return fairListResponse;
    }

    /*根据openId获取相应的审核通过兼职信息*/
    @RequestMapping(value = "/JobFairsByOpenId",method = RequestMethod.POST)
    @ResponseBody
    public FairListResponse JobFairsByOpenId(@RequestBody WeChatJobTime data) {
        try {
            String openId = data.getOpenId();
            String page = data.getPages();
            fairListResponse = new FairListResponse();
            int pageIndex = 0;
            int pageSize = 5;
            int rowCount = 0;
            int pages = 0;
            pageIndex = Integer.parseInt(page);
            beeJobTime = beeDataService.getBeeJobTimeByOpenId(openId);
            rowCount = beeJobTime.getJobTimeBeans().size();
            if (rowCount < pageSize) {
                pages = 1;
            } else if (rowCount % pageSize != 0) {
                pages = rowCount / pageSize + 1;
            } else {
                pages = rowCount / pageSize;
            }
            beeJobTime = beeDataService.getBeeJobTimesByOpenId(openId,pageIndex,pageSize);
            FairListResponse.PageAll pageAll = new FairListResponse.PageAll(Integer.parseInt(page), pages);
            beeJobTime.setPages(pages);
            for(int i = 0;i<beeJobTime.getJobTimeBeans().size();i++){
                String[] JidS = beeDataService.getJids();
                for (int j =0;j<JidS.length;j++){
                    String[] jids = JidS[j].split("/");
                    for (int z = 0;z<jids.length;z++){
                        if(beeJobTime.getJobTimeBeans().get(i).getjId() == Integer.parseInt(jids[z])){
                            beeJobTime.getJobTimeBeans().get(i).setIsGet(1);
                        }
                    }
                }
            }
            fairListResponse.setArr(beeJobTime);
            fairListResponse.setPageAll(pageAll);
            return fairListResponse;
        } catch (ServiceException e) {
        }
        return fairListResponse;
    }

    /*分页获取兼职报名信息*/
    @RequestMapping(value = "/getSignUpJobFairsByJid", method = RequestMethod.POST)
    @ResponseBody
    public FairListResponse getSignUpJobFairsByJid(@RequestBody WeChatSignUpJobTime weChatSignUpJobTime) {
        try {
            String jid = weChatSignUpJobTime.getJid();
            String page = weChatSignUpJobTime.getPage();
            fairListResponse = new FairListResponse();
            int pageIndex = 0;
            int pageSize = 4;
            int rowCount = 0;
            int pages = 0;
            pageIndex = Integer.parseInt(page);
            userMessageList = beeDataService.getSignUpJobFairsByJid();
            userMessageList1 = new UserMessageList();
            for(int i = 0;i<userMessageList.getUserMessageBeans().size();i++){
                String[] JidS = userMessageList.getUserMessageBeans().get(i).getJids().split("/");
                for (int j =0;j<JidS.length;j++){
                    if(jid.equals(JidS[j])){
                        userMessageList1.setUserMessageBeans(new ArrayList<UserMessage>());
                        userMessageList1.getUserMessageBeans().add(userMessageList.getUserMessageBeans().get(i));
                    }
                }
            }
            rowCount = userMessageList1.getUserMessageBeans().size();
            if (rowCount < pageSize) {
                pages = 1;
            } else if (rowCount % pageSize != 0) {
                pages = rowCount / pageSize + 1;
            } else {
                pages = rowCount / pageSize;
            }
            userMessageList = beeDataService.getSignUpJobFairByJid(userMessageList1,pageIndex,pageSize);
            FairListResponse.PageAll pageAll = new FairListResponse.PageAll(Integer.parseInt(page), pages);
            beeJobTime.setPages(pages);
            fairListResponse.setArr(userMessageList);
            fairListResponse.setPageAll(pageAll);
            return fairListResponse;
        } catch (ServiceException e) {
        }
        return fairListResponse;
    }

    /*根据openId获取报名的职位*/
    @RequestMapping(value = "JobFairsUserByOpenId",method = RequestMethod.POST)
    @ResponseBody
    public FairListResponse JobFairsUserByOpenId(@RequestBody WeChatJobTime data){
        String openId = data.getOpenId();
        String page = data.getPages();
        fairListResponse = new FairListResponse();
        int pageIndex = 0;
        int pageSize = 5;
        int rowCount = 0;
        int pages = 0;
        pageIndex = Integer.parseInt(page);
        String jidS = beeDataService.getJidsByOpenId(data.getOpenId());
        String[] split = jidS.split("/");
        List<String> jidS1 = Arrays.asList(split);
        beeJobTime1 = beeDataService.getJobTimeByOpenId(jidS1);
        rowCount = beeJobTime1.getJobTimeBeans().size();
        if (rowCount < pageSize) {
            pages = 1;
        } else if (rowCount % pageSize != 0) {
            pages = rowCount / pageSize + 1;
        } else {
            pages = rowCount / pageSize;
        }
        beeJobTime = beeDataService.getBeeJobTimesByOpenIds(beeJobTime1,pageIndex,pageSize);
        FairListResponse.PageAll pageAll = new FairListResponse.PageAll(Integer.parseInt(page), pages);
        beeJobTime.setPages(pages);
        for (int i = 0;i<beeJobTime.getJobTimeBeans().size();i++){
            int amount = beeDataService.selectIsGet(beeJobTime.getJobTimeBeans().get(i).getjId());
            if (amount>0){
                beeJobTime.getJobTimeBeans().get(i).setIsGet(amount);
            }
        }
        fairListResponse.setArr(beeJobTime);
        fairListResponse.setPageAll(pageAll);
        return fairListResponse;
    }

    @RequestMapping(value = "/getAccess_token")
    @ResponseBody
    public String getAccess_token(){
        JSONObject access_token1 = WXAppletUserInfo.getAccess_token();
        String access_token = (String) access_token1.get("access_token");
        return access_token;
    }
    /*微信登陆*/
    @RequestMapping(value = "/loginWeChat", method = RequestMethod.POST)
    @ResponseBody
    public String loginWeChat(@RequestBody WeChatBean jsonDate, HttpServletRequest httpServletRequest) {
        JSONObject sessionKeyOropenid = WXAppletUserInfo.getSessionKeyOropenid(jsonDate.getCode());
        JSONObject userInfo = WXAppletUserInfo.getUserInfo(jsonDate.getEncryptedData(), sessionKeyOropenid.get("session_key").toString(), jsonDate.getIv());
        Object targetId = beeDataService.selectOpenIds(userInfo.get("openId"));
        int amount = beeDataService.selectOpenId(userInfo.get("openId"));
        if( amount == 0){
            beeDataService.putOpenId(userInfo.get("openId"),jsonDate.getTargetId());
        }else if(!targetId.equals(jsonDate.getTargetId())){
            return "您已注册其他类型用户";
        }
        return (String) userInfo.get("openId");
    }
}
