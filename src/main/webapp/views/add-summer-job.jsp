<%@ page import="java.sql.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加暑期工职位 - 旺旺兼职管理系统</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/hzw-city-picker.css">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/images/logo2.jpg">
    <link rel="shortcut icon" href="<%=basePath%>/images/logo2.jp">
    <script src="<%=basePath%>/js/jquery-2.1.4.min.js"></script>
    <!--[if gte IE 9]>
    <script src="<%=basePath%>/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/html5shiv.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/respond.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/selectivizr-min.js" type="text/javascript"></script>

    <![endif]-->
    <!--[if lt IE 9]>
    <script>window.location.href = 'upgrade-browser.html';</script>
    <![endif]-->
</head>

<body class="user-select">
<section class="container-fluid">
    <header>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false"><span
                            class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                        <span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="/">BEEmanaGeS</a></div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="">消息 <span class="badge">1</span></a></li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" role="button"
                                                aria-haspopup="true" aria-expanded="false">admin <span
                                class="caret"></span></a>
                            <ul class="dropdown-menu dropdown-menu-left">
                                <li><a title="查看或修改个人信息" data-toggle="modal" data-target="#seeUserInfo">个人信息</a></li>
                                <li><a title="查看您的登录记录" data-toggle="modal" data-target="#seeUserLoginlog">登录记录</a></li>
                            </ul>
                        </li>
                        <li><a href="login.jsp" onClick="if(!confirm('是否确认退出？'))return false;">退出登录</a></li>
                        <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>
                    </ul>
                    <form action="" method="post" class="navbar-form navbar-right" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" autocomplete="off" placeholder="键入关键字搜索"
                                   maxlength="15">
                            <span class="input-group-btn">
              <button class="btn btn-default" type="submit">搜索</button>
              </span></div>
                    </form>
                </div>
            </div>
        </nav>
    </header>
    <div class="row">
        <aside class="col-sm-3 col-md-2 col-lg-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="index.jsp">主面板</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="job-time.jsp">兼职管理</a></li>
                <li class="active"><a href="summer-job.jsp">暑期工管理</a></li>
                <li><a href="jobfair-user.jsp">兼职应聘管理</a></li>
                <li><a href="summerjob-user.jsp">暑期应聘管理</a></li>
                <li><a href="auditing-jobfair.jsp">兼职审核管理</a></li>
                <li><a href="auditing-summer-job.jsp">暑期工审核管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a class="dropdown-toggle" id="userMenu" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">用户</a>
                    <ul class="dropdown-menu" aria-labelledby="userMenu">
                        <li><a href="#">管理用户组</a></li>
                        <li><a href="Admin-user.jsp">管理用户</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">管理登录日志</a></li>
                    </ul>
                </li>
            </ul>
        </aside>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
            <form action="" method="post" onsubmit="return false">
                <h1 class="page-header">添加暑期工信息</h1>
                <table class="table" style="margin-bottom:0px;">
                    <tbody>
                    <tr>
                        <td width="5%">公司名称</td>
                        <td width="40%"><input type="text" value="" id="CompanyName" class="form-controls"
                                               name="CompanyName" maxlength="15" autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td width="5%">职位名:</td>
                        <td width="40%"><input type="text" value="" id="JobName" class="form-controls" name="JobName"
                                               maxlength="15" autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td width="5%">招聘人数:</td>
                        <td width="10%"><input type="text" value="" id="Mans" class="form-controls" name="Mans"
                                               maxlength="10"
                                               autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td width="5%">薪资水平:</td>
                        <td><input type="text" class="form-controls"  id="Salary" name="Salary" maxlength="18"
                                               autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td width="5%">工作地区:</td>
                        <td width="40%"><input type="text"  class="form-controls" id="Address"  value="" name="Address" maxlength="18"
                                               autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td width="5%">详细地址:</td>
                        <td width="40%"><input type="text" class="form-controls" id="WorkPlaceName" name="WorkPlaceName" maxlength="18"
                                               autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td width="5%">工作描述：</td>
                        <td><textarea name="JobDesc" id="JobDesc" maxlength="1000" rows="5" class="form-controls" onkeydown="chkLength(this);" aria-required="true" aria-invalid="false" style="margin: 0px 5px 0px 0px; width: 625px; height: 108px;"></textarea>
                            <span class="tishi">(限1000字)</span>
                        </td>
                    </tr>
                    <tr>
                        <td width="5%">联系人:</td>
                        <td width="40%"><input type="text" class="form-controls" id="LinkMan"name="LinkMan" maxlength="18"
                                               autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td width="5%">手机号码:</td>
                        <td width="40%"><input type="text" class="form-controls" id="MobilePhone" name="MobilePhone" maxlength="18"
                                               autocomplete="off"/></td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <div class="modal-footer" style="padding-right:77%">
                <input type="hidden" name="userid" value=""/>
                <button type="button" class="btn btn-primary" style="margin-right: 10%" onclick="puts()" >提交</button>
                <button type="submit" class="btn btn-default" data-dismiss="modal" onclick="exit()">取消</button>
            </div>
        </div>
    </div>
</section>
<!--用户信息模态框-->
<div class="modal fade" id="seeUser" tabindex="-1" role="dialog" aria-labelledby="seeUserModalLabel">
    <div class="modal-dialog" role="document" style="max-width:450px;">
        <form action="/User/update" method="post" autocomplete="off" draggable="false">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改用户</h4>
                </div>
                <div class="modal-body">
                    <table class="table" style="margin-bottom:0px;">
                        <thead>
                        <tr></tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td wdith="20%">姓名:</td>

                            <td width="80%"><input type="text" value="" class="form-control" id="truename"
                                                   name="truename" maxlength="10" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">用户名:</td>
                            <td width="80%"><input type="text" value="" class="form-control" id="username"
                                                   name="username" maxlength="10" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">电话:</td>
                            <td width="80%"><input type="text" value="" class="form-control" id="usertel" name="usertel"
                                                   maxlength="13" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">旧密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="old_password"
                                                   maxlength="18" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">新密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="password" maxlength="18"
                                                   autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">确认密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="new_password"
                                                   maxlength="18" autocomplete="off"/></td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr></tr>
                        </tfoot>
                    </table>
                </div>
                <div class="modal-footer">
                    <input type="hidden" name="userid" value=""/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<!--个人信息模态框-->
<div class="modal fade" id="seeUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <form action="" method="post" autocomplete="off" draggable="false">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">个人信息</h4>
                </div>
                <div class="modal-body">
                    <table class="table" style="margin-bottom:0px;">
                        <thead>
                        <tr></tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td wdith="20%">姓名:</td>
                            <td width="80%"><input type="text" value="王雨" class="form-control" name="truename"
                                                   maxlength="10" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">用户名:</td>
                            <td width="80%"><input type="text" value="admin" class="form-control" name="username"
                                                   maxlength="10" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">电话:</td>
                            <td width="80%"><input type="text" value="18538078281" class="form-control" name="usertel"
                                                   maxlength="13" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">旧密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="old_password"
                                                   maxlength="18" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">新密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="password" maxlength="18"
                                                   autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">确认密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="new_password"
                                                   maxlength="18" autocomplete="off"/></td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr></tr>
                        </tfoot>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<!--个人登录记录模态框-->
<div class="modal fade" id="seeUserLoginlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">登录记录</h4>
            </div>
            <div class="modal-body">
                <table class="table" style="margin-bottom:0px;">
                    <thead>
                    <tr>
                        <th>登录IP</th>
                        <th>登录时间</th>
                        <th>状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>::1:55570</td>
                        <td>2016-01-08 15:50:28</td>
                        <td>成功</td>
                    </tr>
                    <tr>
                        <td>::1:64377</td>
                        <td>2016-01-08 10:27:44</td>
                        <td>成功</td>
                    </tr>
                    <tr>
                        <td>::1:64027</td>
                        <td>2016-01-08 10:19:25</td>
                        <td>成功</td>
                    </tr>
                    <tr>
                        <td>::1:57081</td>
                        <td>2016-01-06 10:35:12</td>
                        <td>成功</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">朕已阅</button>
            </div>
        </div>
    </div>
</div>
<!--微信二维码模态框-->
<div class="modal fade user-select" id="WeChat" tabindex="-1" role="dialog" aria-labelledby="WeChatModalLabel">
    <div class="modal-dialog" role="document" style="margin-top:120px;max-width:280px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
            </div>
            <div class="modal-body" style="text-align:center"><img src="../images/weixin.jpg" alt=""
                                                                   style="cursor:pointer"/></div>
        </div>
    </div>
</div>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/admin-scripts.js"></script>
<script src="<%=basePath%>/js/jquery-2.1.3.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/city-data.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/hzw-city-picker.min.js" type="text/javascript"></script>
<script>

    function exit() {
        window.location.href = "/views/summer-job.jsp";
    }

    function puts() {
        var now=new Date();
        var year=now.getFullYear();
        var month=now.getMonth()+1;
        var day=now.getDate();
        var updateDate = year+"-"+month+"-"+day;

        var companyName = $.trim($('#CompanyName').val());
        var jobName = $.trim($('#JobName').val());
        var mans = $.trim($('#Mans').val());
        var salary = $.trim($('#Salary').val());
        var address = $.trim($('#Address').val());
        var workPlaceName = $.trim($('#WorkPlaceName').val());
        var jobDesc = $.trim($('#JobDesc').val());
        var linkMan = $.trim($('#LinkMan').val());
        var mobilePhone = $.trim($('#MobilePhone').val());
        $.ajax({
            url:"/test/addSummerJob",
            type:"POST",
            data:JSON.stringify({companyName:companyName,jobName:jobName,mans:mans,salary:salary,address:address,workPlaceName:workPlaceName,
                jobDesc:jobDesc,linkMan:linkMan,mobilePhone:mobilePhone,updateDate:updateDate}),
            dataType:"json",
            contentType: "application/json",
            success:function (data) {
                if (data == "true") {
                    alert("添加成功！")
                    window.location.href="/views/summer-job.jsp";
                } else if (data == "false") {
                    alert("服务器出错！");
                }
            },
            error:function () {
                alert("服务器出错！！");
            }
        })
    }



    var cityPicker = new HzwCityPicker({
        data: data,
        target: 'Address',
        valType: 'k-v',
        hideCityInput: {
            name: 'city',
            id: 'city'
        },
        hideProvinceInput: {
            name: 'province',
            id: 'province'
        },
        callback: function(){
        }
    });

    cityPicker.init();

    $('.dropdown-menu').on('click', function(e) {
        var $target = $(e.target);
        $target.is('a') && $('#texts').text($target.text());
    })

</script>
</body>
</html>
