<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
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
    <title>兼职管理 - 旺旺兼职管理系统</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/login.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css">
    <script src="<%=basePath%>js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>js/bootstrap-paginator.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/images/logo2.jpg">
    <link rel="shortcut icon" href="<%=basePath%>/images/logo2.jpg">
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <!--[if gte IE 9]>
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
                    <a class="navbar-brand" href="/views/job-time.jsp">BEEmanaGeS</a></div>
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
                <li class="active"><a href="job-time.jsp">兼职管理</a></li>
                <li><a href="summer-job.jsp">暑期工管理</a></li>
                <li><a href="count-user.jsp">应聘管理</a></li>
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
                <h1 class="page-header">操作</h1>
                <ol class="breadcrumb">
                    <li><a href="add-job-time.jsp">添加职位</a></li>
                </ol>
                <h1 class="page-header">兼职管理&nbsp;<span class="badge">1</span></h1>
                <div class="table-responsive" id="tables">

                </div>
                <footer class="message_footer">
                    <nav>
                        <div class="btn-toolbar operation" role="toolbar">
                            <div class="btn-group" role="group"><a class="btn btn-default" onClick="seri()">全选</a> <a
                                    class="btn btn-default" onClick="reverse()">反选</a> <a class="btn btn-default"
                                                                                          onClick="noselect()">不选</a>
                            </div>
                            <div class="btn-group" role="group">
                                <button type="submit" id="checkbox_delete" class="btn btn-default" data-toggle="tooltip"
                                        data-placement="bottom" title="删除全部选中" name="checkbox_delete">删除
                                </button>
                            </div>
                        </div>
                    </nav>
                    <div id="pageLimit">
                    </div>
                </footer>
            </form>
        </div>
    </div>
</section>

<!--个人信息模态框-->
<div class="modal fade" id="seeUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <form action="" method="post">
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
<script type="text/javascript">
    $(".deletes").click(function () {
        var name = $(this);
        var id = name.attr("rel"); //对应id
        if (name.attr("name") === "deletes") {
            if (window.confirm("此操作不可逆，是否确认？")) {
                $.ajax({
                    type: "POST",
                    url: "/test/deleteJobTime",
                    data: "id=" + id,
                    cache: false, //不缓存此页面
                    dataType: "json",
                    success: function (data) {
                        if (data == "true") {
                            window.location.reload();
                        }
                    },
                    error: function () {
                        alert("aa");
                    },
                });
            }
            ;
        }
        ;
    });


    //删除
    checkall = document.getElementsByName("checkboxs");
    $("#checkbox_delete").click(function () {
        var flag = false;
        for (var i = 0; i < checkall.length; i++) {
            if (checkall[i].checked) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            alert("请至少选一项！");
            return false;
        }

        var array = new Array();
        var j = 0;
        var i;
        for (i = 0; i < checkall.length; i++) {
            if (checkall[i].checked) {
                array[j] = checkall[i].value;
                j++;
            }
        }
        if (window.confirm("此操作不可逆，是否确认？")) {
            $.ajax({
                type: "POST",
                url: "/test/deleteJobTimeList",
                data: JSON.stringify(array),
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                cache: false,
                success: function (data) {
                    if (data == "true") {
                        window.location.reload();
                    }
                },
                error: function (data) {
                    alert("haha");
                }
            });
        }
        return false;
    });

    function exits() {
        if (window.confirm("此操作不可逆，是否确认？")) {
            $.ajax({
                url: "/test/exit",
                dataType: "json",
                success: function (data) {

                },
            });
            window.location.href = "/views/login.jsp";
        }
    }

    function seri() {
        $.ajax({
            url: "/data/getBeeJobTime",
            dataType: "json",
            success: function (data) {
                if (data != null) {
                    var obj = document.getElementById("tables");
                    obj.innerHTML = '<table class="table table-striped table-hover"><thead><tr>' +
                        '<th><span class="glyphicon glyphicon-th-large"><span class="visible-lg">选择</span></th>' +
                        '<th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">兼职职位</span></th>' +
                        '<th><span class="glyphicon glyphicon-file "></span> <span class="visible-lg">薪资</span></th>' +
                        '<th><span class="glyphicon glyphicon-file "></span> <span class="visible-lg">结算</span></th>' +
                        '<th><span class="glyphicon glyphicon-time "></span> <span class="visible-lg">更新日期</span></th>' +
                        '<th><span class="glyphicon glyphicon-pencil "></span> <span class="visible-lg">操作</span></th>' +
                        '</tr></thead>' +
                        '<tr>' +
                        '<td><input type="checkbox" class="input-control" name="checkboxs" value="1"/></td>' +
                        '<td>2</td>' +
                        '<td>3</td>' +
                        '<td>4e</td>' +
                        '<td>5</td>' +
                        '<td><a name="see" rel="1" href="see-job-time.jsp" draggable="false">查看</a>' + ' ' +
                        '<a rel="1" name="deletes" id="deletes" class="deletes" draggable="false">删除</a>' +
                        '</td></tr></table>';
                }
            }
        })
    }

    var options = {
        currentPage: 1,
        totalPages: 10,
        numberOfPages: 5,
        bootstrapMajorVersion: 1,
        itemTexts: function (type, page, current) {
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一页";
                case "next":
                    return "下一页";
                case "last":
                    return "末页";
                case "page":
                    return page;
            }
        }
    }
    $('#pageLimit').bootstrapPaginator(options);


</script>
</body>
</html>
