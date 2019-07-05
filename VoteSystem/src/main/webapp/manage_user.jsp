<%--
  User: zayvion
  Date: 2019-06-28
  Time: 16:19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <title>用户管理</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css">
    <style>
        body {
            margin-top: 70px;
        }

        #welcome {
            font-size: 16px;
            line-height: 50px;
        }

        a {
            padding-left: 10px;
            text-decoration: underline;
            cursor: pointer;
            ext-decoration: none;
            color: inherit;
        }
    </style>
</head>
<body>
<!-- 修改用户信息模态框 -->
<div class="modal fade" id="user_update_madal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改用户</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal"  method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" name="username" class="form-control" id="username" >
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" name="password" class="form-control" id="password" >
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">E-mail</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email" >
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="save_btn">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--    确认删除模态框--%>
<div class="modal fade" tabindex="-1" role="dialog"id="confirm_del">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">确认删除</h4>
            </div>
            <div class="modal-body">
                <span>确认将此用户删除(禁用)吗？</span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-danger" id="del_button">删除</button>
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
            <li role="presentation"><a href="main.jsp">投票管理</a></li>
            <li role="presentation"><a href="new_vote.jsp">新建投票</a></li>
            <li role="presentation" class="active"><a href="manage_user.jsp">用户管理</a></li>
        </ul>
    </div>
    <div class="col-lg-8">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>用户名</th>
                <th>邮箱</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        <footer class="modal-footer">
            <h4 class="text-center">在线投票系统</h4>
            <h5 class="text-center">Copyright © 2019&nbsp;&nbsp;&nbsp;2018200279李紫霖. All rights reserved</h5>
        </footer>
    </div>
</div>
<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/bootstrap/js/bootstrap.js"></script>
<script src="assets/js/bootstrap-datetimepicker.min.js"></script>
<script src="assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(function () {
        $.ajax({
            url: "getusers",
            type: "get",
            data: "",
            datatype: "json",
            success: function (result) {
                $.each(result, function (index, item) {
                    var status = item.status == 1 ? "正常" : "删除"
                        var content = $("<tr> <td>" + item.id + "</td><td>" + item.username + "</td><td>" + item.email + "</td><td class='col-sm-4'>" + status + "</td><td>" +
                        "<button class='btn btn-primary btn-sm'  onclick='btn_update(" + item.id + ")'>修改用户</button>&nbsp;&nbsp;&nbsp;" +
                        "<button class='btn btn-danger btn-sm' id='delete' onclick='btn_del("+item.id+")' status='"+item.status+"'>删除用户</button>" +
                        "</td></tr>");

                    $('tbody').append(content);
                    $("button[status=0]").addClass("disabled").empty().append("已删除");
                    $("button[status=0]").empty().append("已删除");
                })

            },
            error: function (e) {

            }
        })

    })

    function btn_update(id) {
        $.ajax({
            url: "getuser",
            type: "get",
            data: "id=" + id,
            datatype: "json",
            success: function (result) {
                console.log(result);
                $("#username").val([result.username]);
                $("#password").val(result.password);
                $("#email").val(result.email);
                $("#save_btn").attr("onclick","update("+result.id+")");
                $("#user_update_madal").modal('show');
            },
            error: function (e) {

            }
        })
    }

    function update(id) {
    $.ajax({
        url:"updateuser",
        data:{
            "id":id,"method":"information","username":$("#username").val(),"password": $("#password").val(),"email":$("#email").val()
        },
        type: "get",
        datatype: "json",
        success:function (result) {
            $("#user_update_madal").modal('hide');
            window.location.replace(window.location.href)
        },
        error:function (e) {

        }
    })
    }

    function btn_del(id) {
        $("#del_button").attr("onclick","del("+id+")");
        $("#confirm_del").modal('show');
    }

    function del(id) {
        $.ajax({
            url:"updateuser",
            data:{
                "id":id,"method":"del"
            },
            type: "get",
            datatype: "json",
            success:function (result) {
                $("#user_update_madal").modal('hide');
                window.location.replace(window.location.href)
            },
            error:function (e) {

            }
        })
    }
</script>
</body>
</html>
