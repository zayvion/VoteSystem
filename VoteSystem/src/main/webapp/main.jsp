<%--
  User: zayvion
  Date: 2019-06-28
  Time: 16:19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <title>在线投票系统</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
    <style>
        body {
            margin-top: 70px;
        }

        #welcome {
            font-size: 16px;
            line-height: 50px;
        }
    </style>
</head>
<body>
<!-- 员工添加的模态框 -->
<div class="modal fade" id="vote_update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改投票</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal"  method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">投票内容</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="vote_title_input" placeholder="请输入标题">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">投票类型</label>
                        <div class="col-sm-10">
                            <input type="radio" class="checkbox-inline" name="type" value="0">男
                            <input type="radio" class="checkbox-inline" name="type" value="1">女
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">投票选项</label>
                        <div class="col-sm-10">
                            <input type="checkbox" class="checkbox-inline" name="item" value="跑步">跑步 <br>
                            <input type="checkbox" class="checkbox-inline" name="item" value="游泳">游泳 <br>
                            <input type="checkbox" class="checkbox-inline" name="item" value="打球">打球 <br>
                            <input type="checkbox" class="checkbox-inline" name="item" value="拳击">拳击 <br>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="emp_save_btn" onclick="f()">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <nav class="navbar  navbar-fixed-top navbar-default">

        <div class="container">
            <span id="welcome"> 欢迎您：<strong>${sessionScope.userFlag}</strong></span>
            <c:if test="${!sessionScope.userFlag}">
            <a type="button" class="btn btn-default navbar-btn navbar-right" href="logout">退出系统</a>
            </c:if>


    </nav>
    <div class="col-lg-4">
        <ul class="nav nav-pills nav-stacked">
            <li role="presentation" class="active"><a href="main.jsp">投票列表</a></li>
            <li role="presentation"><a href="new_vote.jsp">新建投票</a></li>
            <li role="presentation"><a href="main.jsp">投票管理</a></li>
        </ul>
    </div>
    <div class="col-lg-8">
        <div id="content"></div>
        <%--<div class="panel panel-default panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">你最喜欢哪种下载工具</h3>
            </div>
            <div class="panel-body">
                <span>共有<strong>2</strong>个选项，已有<strong>2</strong>个网友参与</span>
                <p class="text-right">
                    <button type="button" class="btn btn-primary btn-sm" onclick="update()">修改</button>&nbsp;&nbsp;
                    <button type="button" class="btn btn-danger btn-sm">删除</button>
                </p>
            </div>--%>
        </div>

        <footer class="modal-footer">
            <h4 class="text-center">在线投票系统</h4>
            <h5 class="text-center">Copyright © 2019&nbsp;&nbsp;&nbsp;2018200279李紫霖. All rights reserved</h5>
        </footer>
    </div>
</div>

<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/bootstrap/js/bootstrap.js"></script>
<script>
    $(function () {
        $.ajax({
            url: "getall",
            data: "",
            type: "get",
            datatype: "json",
            success: function (result) {
                console.log(result);
                $.each(result, function (index, item) {
                    console.log(item.title)
                    var edit_button = "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"update(" + item.id + "\)\">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;";
                    var del_button = "<bu#tton type=\"button\" class=\"btn btn-danger btn-sm\" onclick=\"del(" + item.id + "\)\">删除</button>";
                    var p = $("<p></p>").addClass("text-right").append(edit_button).append(del_button);
                    var span = "<span>共有<strong>2</strong>个选项，已有<strong>2</strong>个网友参与</span>";
                    var panel_body = $("<div></div>").addClass("panel-body").append(span).append(p);
                    var panel_title = $("<h3></h3>").addClass("panel-title").append(item.title);
                    var panel_heading = $("<div></div>").addClass("panel-heading").append(panel_title);
                    var panel = $("<div></div>").addClass("panel panel-default panel-info").append(panel_heading).append(panel_body)

                    $("#content").append(panel);


                })
            }
        })

    });

</script>
<script>
    function update(id) {
        $.ajax({
            url: "getitem",
            data: "",
            type: "get",
            datatype: "json",
            success: function (result) {
                console.log(result);
                $.each(result, function (index, item) {
                    console.log(item.title)
                    var edit_button = "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"update(" + item.id + "\)\">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;";
                    var del_button = "<bu#tton type=\"button\" class=\"btn btn-danger btn-sm\" onclick=\"del(" + item.id + "\)\">删除</button>";
                    var p = $("<p></p>").addClass("text-right").append(edit_button).append(del_button);
                    var span = "<span>共有<strong>2</strong>个选项，已有<strong>2</strong>个网友参与</span>";
                    var panel_body = $("<div></div>").addClass("panel-body").append(span).append(p);
                    var panel_title = $("<h3></h3>").addClass("panel-title").append(item.title);
                    var panel_heading = $("<div></div>").addClass("panel-heading").append(panel_title);
                    var panel = $("<div></div>").addClass("panel panel-default panel-info").append(panel_heading).append(panel_body)

                    $("#content").append(panel);


                })
            }
        }
        $('#vote_update').modal().show();
    }
    function f() {
        
    }
</script>
</body>
</html>