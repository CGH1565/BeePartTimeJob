<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>旺旺兼职管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="<%=basePath%>/images/logo2.jpg">
<link rel="shortcut icon" href="<%=basePath%>/images/logo2.jpg">
<script src="<%=basePath%>js/jquery-2.1.4.min.js"></script>
</head>

<body class="user-select">
<section class="container-fluid">
  <header>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="/views/job-time.jsp">BEEmanaGeS</a> </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="">消息 <span class="badge">1</span></a></li>
            <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">admin <span class="caret"></span></a>
              <ul class="dropdown-menu dropdown-menu-left">
                <li><a title="查看或修改个人信息" data-toggle="modal" data-target="#seeUserInfo">个人信息</a></li>
                <li><a title="查看您的登录记录" data-toggle="modal" data-target="#seeUserLoginlog">登录记录</a></li>
              </ul>
            </li>
            <li><a onclick="exits()">退出登录</a></li>
            <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>
          </ul>
          <form action="" method="post" class="navbar-form navbar-right" role="search">
            <div class="input-group">
              <input type="text" class="form-control" autocomplete="off" placeholder="键入关键字搜索" maxlength="50">
            <span class="input-group-btn">
              <button class="btn btn-default" type="submit">搜索</button>
              </span> </div>
        </form>
        </div>
      </div>
    </nav>
  </header>
  <div class="row">
    <aside class="col-sm-3 col-md-2 col-lg-2 sidebar">
      <ul class="nav nav-sidebar">
        <li class="active"><a href="index.jsp">主面板</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="job-time.jsp">兼职管理</a></li>
        <li><a href="summer-job.jsp">暑期工管理</a></li>
        <li><a href="jobfair-user.jsp">兼职应聘管理</a></li>
        <li><a href="summerjob-user.jsp">暑期应聘管理</a></li>
        <li><a href="auditing-jobfair.jsp">兼职审核管理</a></li>
        <li><a href="auditing-summer-job.jsp">暑期工审核管理</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a class="dropdown-toggle" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">用户</a>
          <ul class="dropdown-menu" aria-labelledby="userMenu">
            <li><a data-toggle="modal" data-target="#areDeveloping">管理用户组</a></li>
            <li><a href="Admin-user.jsp">管理用户</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">管理登录日志</a></li>
          </ul>
        </li>
      </ul>
    </aside>
    <%
      Class.forName("com.mysql.jdbc.Driver");
      String userName = "admin";
      String userPasswd = "123456";
      String dbName = "mfjzxcx2017";
      String tableName = "bst_auditing_company_plurality";
      String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="+ userName + "&password=" + userPasswd;

      Connection connection = DriverManager.getConnection(url);
      Statement statement = connection.createStatement();
      String sql = " SELECT * FROM " + tableName;
      ResultSet rs = statement.executeQuery(sql);
      rs.last();
      int amount = rs.getRow();
      rs.close();
      statement.close();
      connection.close();

      String tableName1 = "bst_auditing_company_summerjob";
      Connection connection1 = DriverManager.getConnection(url);
      Statement statement1 = connection1.createStatement();
      String sql1 = " SELECT * FROM " + tableName1;
      ResultSet rs1 = statement1.executeQuery(sql1);
      rs1.last();
      int amount1 = rs1.getRow();
    %>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
      <h1 class="page-header">信息总览</h1>
      <div class="row placeholders">
        <div class="col-xs-6 col-sm-3 placeholder">
          <h4>兼职审核</h4>
          <span class="text-muted"><a href="auditing-jobfair.jsp"><%=amount%></a>&nbsp;&nbsp;条</span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
          <h4>暑期工审核</h4>
          <span class="text-muted"><a href="auditing-summer-job.jsp"><%=amount1%></a>&nbsp;&nbsp;条</span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
          <h4>友链</h4>
          <span class="text-muted">0 条</span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
          <h4>访问量</h4>
          <span class="text-muted">0</span> </div>
      </div>
      <%
        rs1.close();
        statement1.close();
        connection1.close();
      %>
      <h1 class="page-header">状态</h1>
      <div class="table-responsive">
        <table class="table table-striped table-hover">
          <tbody>
            <tr>
              <td>登录者: <span>admin</span>，这是您第 <span>13</span> 次登录</td>
            </tr>
            <tr>
              <td>上次登录时间: 2016-01-08 15:50:28 , 上次登录IP: ::1:55570</td>
            </tr>
          </tbody>
        </table>
      </div>
      <h1 class="page-header">系统信息</h1>
      <div class="table-responsive">
        <table class="table table-striped table-hover">
          <thead>
            <tr> </tr>
          </thead>
          <tbody>
            <tr>
              <td>管理员个数:</td>
              <td>2 人</td>
              <td>服务器软件:</td>
              <td>Apache/2.4.10 (Win32) OpenSSL/1.0.1i mod_fcgid/2.3.9</td>
            </tr>
            <tr>
              <td>浏览器:</td>
              <td>Chrome47</td>
              <td>PHP版本:</td>
              <td>5.6.1</td>
            </tr>
            <tr>
              <td>操作系统:</td>
              <td>Windows 10</td>
              <td>PHP运行方式:</td>
              <td>CGI-FCGI</td>
            </tr>
            <tr>
              <td>登录者IP:</td>
              <td>::1:55570</td>
              <td>MYSQL版本:</td>
              <td>5.5.40</td>
            </tr>
            <tr>
              <td>程序版本:</td>
              <td class="version">YlsatCMS 1.0 <font size="-6" color="#BBB">(20160108160215)</font></td>
              <td>上传文件:</td>
              <td>可以 <font size="-6" color="#BBB">(最大文件：2M ，表单：8M )</font></td>
            </tr>
            <tr>
              <td>程序编码:</td>
              <td>UTF-8</td>
              <td>当前时间:</td>
              <td>2016-01-08 15:50:30</td>
            </tr>
          </tbody>
          <tfoot>
            <tr></tr>
          </tfoot>
        </table>
      </div>
      <footer>
        <h1 class="page-header">程序信息</h1>
        <div class="table-responsive">
        <table class="table table-striped table-hover">
          <tbody>
            <tr>
              <td><span style="display:inline-block; width:8em">版权所有</span> POWERED BY WY ALL RIGHTS RESERVED</td>
            </tr>
            <tr>
              <td><span style="display:inline-block;width:8em">页面加载时间</span> PROCESSED IN 1.0835s  SECONDS 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></td>
            </tr>
          </tbody>
        </table>
        </div>
      </footer>
    </div>
  </div>
</section>
<!--个人信息模态框-->
<div class="modal fade" id="seeUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <form action="" method="post">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" >个人信息</h4>
        </div>
        <div class="modal-body">
          <table class="table" style="margin-bottom:0px;">
            <thead>
              <tr> </tr>
            </thead>
            <tbody>
              <tr>
                <td wdith="20%">姓名:</td>
                <td width="80%"><input type="text" value="王雨" class="form-control" name="truename" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">用户名:</td>
                <td width="80%"><input type="text" value="admin" class="form-control" name="username" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">电话:</td>
                <td width="80%"><input type="text" value="18538078281" class="form-control" name="usertel" maxlength="13" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">旧密码:</td>
                <td width="80%"><input type="password" class="form-control" name="old_password" maxlength="50" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">新密码:</td>
                <td width="80%"><input type="password" class="form-control" name="password" maxlength="50" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">确认密码:</td>
                <td width="80%"><input type="password" class="form-control" name="new_password" maxlength="50" autocomplete="off" /></td>
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
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" >登录记录</h4>
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
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
      </div>
      <div class="modal-body" style="text-align:center"> <img src="../images/card.jpg" alt="" style="cursor:pointer"/> </div>
    </div>
  </div>
</div>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/admin-scripts.js"></script>
<script>

    function exits() {
        if (window.confirm("此操作不可逆，是否确认？")) {
            $.ajax({
                url: "/test/exit",
                dataType: "json",
                success: function (data) {
                },
            });
            window.location.href = "login.jsp";
        }
    }
</script>
</body>
</html>
