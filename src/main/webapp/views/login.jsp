<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@
 page pageEncoding="UTF-8"
%>
<html>
<head>
    <style type="text/css">
        html{height:100%;}
        body{min-height:100%;margin:0;padding:0;position:relative;}
        .footers{position:absolute;bottom:0;width:100%;height:100px;text-align: center;line-height:100px;}
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>旺旺兼职管理系统</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/login.css">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/images/logo2.jpg">
    <link rel="shortcut icon" href="<%=basePath%>/images/logo2.jpg">
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

<style>
    body{background: url("<%=basePath%>/images/timg5.jpg") no-repeat; background-size:100%;}
</style>
<body class="user-select">
<div class="container">
    <div class="siteIcon"><img src="<%=basePath%>/images/user.jpg" alt="" data-toggle="tooltip" data-placement="top"
                               title="欢迎使用蜜蜂兼职系统" draggable="false"/></div>
    <form  autocomplete="off" class="form-signin" name="loginform" onsubmit="return false">
        <h2 class="form-signin-heading">管理员登录</h2>
        <label for="userName" class="sr-only">用户名</label>
        <input type="text" id="userName" name="userName" class="form-control" placeholder="请输入用户名" required autofocus
               autocomplete="off" maxlength="10">
        <label for="userPwd" class="sr-only">密码</label>
        <input type="password" id="userPwd" name="passWord" class="form-control" placeholder="请输入密码" required
               autocomplete="off" maxlength="50">
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="signinSubmit" onclick="login(this.form)" >登录
        </button>
    </form>
</div>
<div class="footers">
    2008 - 2017 新工作人才网 版权所有 闽公网安备 闽ICP备09046318号-3 闽公网安备
    <a href="http://www.miitbeian.gov.cn">http://www.miitbeian.gov.cn</a>
</div>
<script src="../js/bootstrap.min.js"></script>
<script language="JavaScript">
   /* $('[data-toggle="tooltip"]').tooltip();
    window.oncontextmenu = function () {
    //return false;
    };
    $('.siteIcon img').click(function () {
    window.location.reload();
    });*/
    function login(loginform) {
        if (loginform.userName.value == "") {
            alert("请输入用户名！");
            loginform.userName.focus();
            return false;
        }else if (loginform.passWord.value ==""){
            alert("请输入密码！");
            loginform.passWord.focus();
            return false;
        }
        $.ajax({
            url:"/test/job-time",
            type:"POST",
            data:JSON.stringify({"userName":$("#userName").val(),"passWord":$("#userPwd").val()}),
            dataType:"json",
            contentType: "application/json",
            success:function (data) {
                if(data=="true"){
                    window.location.href="/views/index.jsp";
                }else if(data=="false"){
                    alert("登陆失败，用户名或密码错误！！");loginform.userName.focus();return false;
                }
            },
            error:function(){
                alert("服务器出错！！") }
        })
   }

</script>
</body>
</html>
