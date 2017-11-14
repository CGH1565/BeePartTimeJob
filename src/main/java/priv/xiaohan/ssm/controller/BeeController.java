package priv.xiaohan.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.xiaohan.ssm.model.*;
import priv.xiaohan.ssm.service.AdministratorsService;
import priv.xiaohan.ssm.service.JobTimeService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by HotSauce on 2017/8/29.
 */

@Controller
@RequestMapping("/test")
public class BeeController {

    @Resource
    private AdministratorsService administratorsService;

    @Resource
    private JobTimeService jobTimeService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String home(){
        return "login";
    }

    //登录
    @RequestMapping(value = "/job-time", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Administrators administrators,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        boolean bool = administratorsService.selectAdministrators(administrators);
        request.getSession().setAttribute("userName",administrators);
        String bools = String.valueOf(bool);
        return bools;
    }

    //添加兼职信息
    @RequestMapping(value = "/addJobTime",method = RequestMethod.POST)
    @ResponseBody
    public String addJobTime(@RequestBody JobTime jobTimeBean){
        jobTimeService.addJobTime(jobTimeBean);
        return "true";
    }

    //更新兼职信息
    @RequestMapping(value = "/updateJobTime",method = RequestMethod.POST)
    @ResponseBody
    public String upDateJobTime(@RequestBody JobTimes jobTime){
        jobTimeService.upDateJobTime(jobTime);
        return "true";
    }

    //兼职信息管理删除操作
    @RequestMapping(value = "/deleteJobTime",method = RequestMethod.POST)
    @ResponseBody
    public String deleteJobTime(int id){
        jobTimeService.deleteJobTime(id);
        return "true";
    }


    //兼职管理信息批量删除操作
    @RequestMapping(value = "/deleteJobTimeList",method = RequestMethod.POST)
    @ResponseBody
    public String deleteJobTimeList(@RequestBody List<String> jobtimeIDs){
        jobTimeService.deleteJobTimeList(jobtimeIDs);
        return "true";
    }

    /*-----------------------------------------------------------------------------------------------------------------*/

    //暑期工信息管理添加操作
    @RequestMapping(value = "/addSummerJob",method = RequestMethod.POST)
    @ResponseBody
    public String addSummerJob(@RequestBody SummerJob summerJob){
        jobTimeService.addSummerJob(summerJob);
        return "true";
    }

    //更新暑期工信息
    @RequestMapping(value = "/updateSummerJob",method = RequestMethod.POST)
    @ResponseBody
    public String updateSummerJob(@RequestBody SummerJob summerJob){
        jobTimeService.updateSummerJob(summerJob);
        return "true";
    }

    //暑期工管理删除操作
    @RequestMapping(value = "/deleteSummerJob",method = RequestMethod.POST)
    @ResponseBody
    public String deleteSummerJob(int id){
        jobTimeService.deleteSummerJob(id);
        return "true";
    }

    //暑期工管理批量删除操作
    @RequestMapping(value = "/deleteSummerJobList",method = RequestMethod.POST)
    @ResponseBody
    public String deleteSummerJobList(@RequestBody List<String> jobtimeIDs){
        jobTimeService.deleteSummerJobList(jobtimeIDs);
        return "true";
    }

    /*------------------------------------------------------------------------------------------------------------------*/

    //兼职应聘管理删除操作
    @RequestMapping(value = "/deleteFairJobOffer",method = RequestMethod.POST)
    @ResponseBody
    public String deleteFairJobOffer(int id){
        jobTimeService.deleteFariJobOffer(id);
        return "true";
    }
    //暑期工应聘管理删除操作
    @RequestMapping(value = "/deleteSummerJobOffer",method = RequestMethod.POST)
    @ResponseBody
    public String deleteSummerJobOffer(int id){
        jobTimeService.deleteSummerJobOffer(id);
        return "true";
    }

    //应聘管理批量删除操作
    @RequestMapping(value = "/deleteOfferList",method = RequestMethod.POST)
    @ResponseBody
    public String deleteOfferList(@RequestBody List<String> jobtimeIDs){
        jobTimeService.deleteOfferList(jobtimeIDs);
        return "true";
    }
    /*------------------------------------------------------------------------------------------------------------------*/
    //兼职管理审核删除操作
    @RequestMapping(value = "/auditingDeleteJobFair",method = RequestMethod.POST)
    @ResponseBody
    public String auditingDeleteJobFair(int id){
        jobTimeService.auditingDeleteJobFair(id);
        return "true";
    }

    //更新兼职审核信息
    @RequestMapping(value = "/auditingUpdateJobFair",method = RequestMethod.POST)
    @ResponseBody
    public String auditingUpdateJobFair(@RequestBody JobTimes jobTime){
        jobTimeService.auditingUpdateJobFair(jobTime);
        return "true";
    }


    //兼职审核管理批量删除操作
    @RequestMapping(value = "/auditingDeleteJobFairList",method = RequestMethod.POST)
    @ResponseBody
    public String auditingDeleteJobFairList(@RequestBody List<String> jobtimeIDs){
        jobTimeService.auditingDeleteJobFairList(jobtimeIDs);
        return "true";
    }

    //批量插入兼职审核信息
    @RequestMapping(value = "/auditingJobFairList",method = RequestMethod.POST)
    @ResponseBody
    public String auditingJobFairList(@RequestBody List<String> jobtimeIDs){
        jobTimeService.auditingJobFairList(jobtimeIDs);
        return "true";
    }

    /*------------------------------------------------------------------------------------------------------------------*/
    //暑期工管理审核删除操作
    @RequestMapping(value = "/auditingDeleteSummerJob",method = RequestMethod.POST)
    @ResponseBody
    public String auditingDeleteSummerJob(int id){
        jobTimeService.auditingDeleteSummerJob(id);
        return "true";
    }

    //更新暑期工审核信息
    @RequestMapping(value = "/auditingUpdateSummerJob",method = RequestMethod.POST)
    @ResponseBody
    public String auditingUpdateSummerJob(@RequestBody SummerJob summerJob){
        jobTimeService.auditingUpdateSummerJob(summerJob);
        return "true";
    }

    //暑期工审核管理批量删除操作
    @RequestMapping(value = "/auditingDeleteSummerJobList",method = RequestMethod.POST)
    @ResponseBody
    public String auditingDeleteSummerJobList(@RequestBody List<String> jobtimeIDs){
        jobTimeService.auditingDeleteSummerJobList(jobtimeIDs);
        return "true";
    }

    //批量插入暑期工审核信息
    @RequestMapping(value = "/auditingSummerJobList",method = RequestMethod.POST)
    @ResponseBody
    public String auditingSummerJobList(@RequestBody List<String> jobtimeIDs){
        jobTimeService.auditingSummerJobList(jobtimeIDs);
        return "true";
    }

    /*------------------------------------------------------------------------------------------------------------------*/

    //管理员添加操作
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    @ResponseBody
    public String addAdmin(@RequestBody AdministratorsS administratorss){
        jobTimeService.addAdmin(administratorss);
        return "true";
    }

    // 管理员修改操作
    @RequestMapping(value = "/reviseAdmin",method = RequestMethod.POST)
    @ResponseBody
    public String reviseAdmin(@RequestBody AdministratorsS administratorsS){
        jobTimeService.reviseAdmin(administratorsS);
        return "true";
    }

    // 管理员删除操作
    @RequestMapping(value = "/deleteAdmin",method = RequestMethod.POST)
    @ResponseBody
    public String deleteAdmin(int id){
        jobTimeService.deleteAdmin(id);
        return "true";
    }

    //退出登录
    @RequestMapping(value = "/exit",method = RequestMethod.GET)
    public void exit(HttpServletRequest request){
        request.getSession().invalidate();
    }

    //分页初始化查询
    @RequestMapping(value = "/getData",method = RequestMethod.POST)
    public void getData(int id){

    }
}
