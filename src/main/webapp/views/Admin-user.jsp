<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理员 -旺旺兼职管理系统</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/images/logo2.jpg">
    <link rel="shortcut icon" href="<%=basePath%>/images/logo2.jpg">
    <script src="<%=basePath%>/js/jquery-2.1.4.min.js"></script>
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
                        <li><a onClick="exits()">退出登录</a></li>
                        <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>
                    </ul>
                    <form action="" method="post" class="navbar-form navbar-right" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" autocomplete="off" placeholder="键入关键字搜索"
                                   maxlength="50">
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
                <li><a href="summer-job.jsp">暑期工管理</a></li>
                <li><a href="jobfair-user.jsp">兼职应聘管理</a></li>
                <li><a href="summerjob-user.jsp">暑期应聘管理</a></li>
                <li><a href="auditing-jobfair.jsp">兼职审核管理</a></li>
                <li><a href="auditing-summer-job.jsp">暑期工审核管理</a></li>

            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a class="dropdown-toggle" id="userMenu" data-toggle="dropdown" aria-haspopup="true"
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
            <h1 class="page-header">操作</h1>
            <ol class="breadcrumb">
                <li><a data-toggle="modal" data-target="#addUser">增加管理员</a></li>
            </ol>
            <h1 class="page-header">管理员管理&nbsp;<span class="badge">4</span></h1>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th><span class="glyphicon glyphicon-th-large"></span> <span class="visible-lg">ID</span></th>
                        <th><span class="glyphicon glyphicon-user"></span> <span class="visible-lg">用户名</span></th>
                        <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
                    </tr>
                    </thead>
                    <%
                        String driverName = "com.mysql.jdbc.Driver";
                        //数据库用户名
                        String userName = "admin";
                        //密码
                        String userPasswd = "123456";
                        //数据库名
                        String dbName = "mfjzxcx2017";
                        //表名
                        String tableName = "bst_system_administrator";
                        //联结字符串
                        String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="
                                + userName + "&password=" + userPasswd;
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection connection = DriverManager.getConnection(url);
                        Statement statement = connection.createStatement();
                        String sql = "SELECT * FROM " + tableName;
                        ResultSet rs = statement.executeQuery(sql);
                    %>
                    <%
                        while (rs.next()) {
                    %>
                    <tr>
                        <td><% out.print(rs.getString(1));%></td>
                        <td id="user"><% out.print(rs.getString(2));%></td>
                        <td><a data-toggle="modal" data-target="#seeUser" rel="<%out.print(rs.getString(1));%>" name="revise" class="revise" id="<% out.print(rs.getString(2));%>">修改</a>
                            <a rel="<%out.print(rs.getString(1));%>" name="delete" id="delete" class="delete">删除</a>
                        </td>
                    </tr>
                    <% } %>
                </table>
                <%
                    rs.close();
                    statement.close();
                    connection.close();
                %>
            </div>
            </table>
        </div>
    </div>
    </div>
</section>
<!--增加用户模态框-->
<div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="addUserModalLabel">
    <div class="modal-dialog" role="document" style="max-width:450px;">
        <form action="" method="post" autocomplete="off" draggable="false" onsubmit="addAdmin()">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">增加管理员</h4>
                </div>
                <div class="modal-body">
                    <table class="table" style="margin-bottom:0px;">
                        <thead>
                        <tr></tr>
                        </thead>
                        <tbody>
                        <tr>
                        <tr>
                            <td wdith="20%">用户名:</td>
                            <td width="80%"><input type="text" class="form-control" id="userNames" name="userNames"
                                                   maxlength="10" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">新密码:</td>
                            <td width="80%"><input type="password" class="form-control" id="passWords" name="passWords"
                                                   maxlength="50" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">确认密码:</td>
                            <td width="80%"><input type="password" class="form-control" id="new_password"
                                                   name="new_password" maxlength="50" autocomplete="off"/></td>
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
<!--用户信息模态框-->
<div class="modal fade" id="seeUser" tabindex="-1" role="dialog" aria-labelledby="seeUserModalLabel">
    <div class="modal-dialog" role="document" style="max-width:450px;">
        <form action="" method="post" autocomplete="off" draggable="false" onsubmit="reviseAdmin()">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改密码</h4>
                </div>
                <div class="modal-body">
                    <table class="table" style="margin-bottom:0px;">
                        <thead>
                        <tr></tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td wdith="20%">姓名:</td>
                            <td width="80%"><input type="text" value="" class="form-control" id="userN"
                                                   name="userN" maxlength="10" autocomplete="off" disabled="false"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">旧密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="old_password"
                                                   id="old_password"
                                                   maxlength="50" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">新密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="password" id="password" maxlength="50"
                                                   autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">确认密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="new_passwords"
                                                   id="new_passwords"
                                                   maxlength="50" autocomplete="off"/></td>
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
                                                   maxlength="50" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">新密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="password" maxlength="50"
                                                   autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">确认密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="new_password"
                                                   maxlength="50" autocomplete="off"/></td>
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
<script>
    var id;
    function reviseAdmin() {
            if (window.confirm("此操作不可逆，是否确认？")) { //确认框！！！！1
                $.ajax({
                    type: "POST",
                    url: "/test/reviseAdmin",
                    data: JSON.stringify({
                        id:id,
                        userName: $("#userN").val(),
                        usedPassword:$("#old_password").val(),
                        passWord: $("#password").val(),
                        repeatPassword: $("#new_passwords").val(),
                    }),
                    cache: false, //不缓存此页面
                    dataType: "json",
                    contentType: "application/json",
                    success: function (data) {
                        if (data == "true") {
                            alert("密码修改成功！");
                            window.location.reload();
                        }
                    },
                    error: function (data) {
                        alert("服务器出错！！");
                    },
                });
            };
    }



    $(".delete").click(function () {
        var name = $(this);
        var id = name.attr("rel"); //对应id
        if (name.attr("name") === "delete") {
            if (window.confirm("此操作不可逆，是否确认？")) {
                $.ajax({
                    type: "POST",
                    url: "/test/deleteAdmin",
                    data: "id=" + id,
                    cache: false, //不缓存此页面
                    dataType: "json",
                    success: function (data) {
                        if (data == "true") {
                            window.location.reload();
                        }
                    },
                    error: function (data) {
                        alert("服务器出错！！");
                    },
                });
            }
            ;
        }
        ;
        return false;
    });


    function addAdmin() {
        $.ajax({
            url: "/test/addAdmin",
            type: "POST",
            data: JSON.stringify({
                userName: $("#userNames").val(),
                passWord: $("#passWords").val(),
                repeatPassword: $("#new_password").val()
            }),
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                if (data == "true") {
                    alert("添加管理员成功！");
                    window.location.reload();
                }
            },
            error: function () {
                alert("haha");
            }
        });
    }

    $(".revise").click(function() {
        var name = $(this);
        id = name.attr("id");
        window.document.getElementById("userN").value=id;  //获取到这个标签元素
    })

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
