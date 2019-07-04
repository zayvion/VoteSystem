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
    <title>新建投票</title>
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
            cursor: pointer
        }
    </style>
</head>
<body>
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
            <li role="presentation" class="active"><a href="new_vote.jsp">新建投票</a></li>
        </ul>
    </div>
    <div class="col-lg-8">
        <form id="form">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h2 class="panel-title">添加新投票</h2>
                </div>
                <div class="panel-body">
                    <div class="input-group">
                        <label>投票内容</label>
                        <input type="text" class="form-control" placeholder="请输入标题" aria-describedby="sizing-addon1"
                               id="title">
                    </div>
                    <br>
                    <div class="input-group">
                        <label>投票类型</label><br>
                        <div>
                            <label class="radio-inline" id="votetype">
                                <input type="radio" name="vote_type" value="0"/>单选
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="vote_type" value="1"/>多选
                            </label><br><br>
                        </div>
                    </div>
                    <div class="input-group">
                        <label>结束时间</label><br>
                        <div class="input-group date form_datetime "  data-date-format=" yyyy MM dd - HH:ii p">
                            <input class="form-control"  id="endTime" type="text" value="" readonly="">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    </div>
                    <div class="input-group" id="options">
                        <label>投票选项</label>
                        <input type="text" class="form-control" placeholder="请输入选项" aria-describedby="sizing-addon1"
                               name="option">
                        <input type="text" class="form-control" placeholder="请输入选项" aria-describedby="sizing-addon1"
                               name="option">
                    </div>
                    <br>
                    <button type="button" class="btn btn-primary btn-sm" id="submit">确定</button>
                    <a id="addoption">增加选项</a>
                    <a href="main.jsp">取消操作</a>
                </div>
            </div>
        </form>
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
    $(
        function () {
            $("#addoption").click(function () {
                $("#options").append("<input type=\"text\" class=\"form-control\" placeholder=\"请输入选项\" aria-describedby=\"sizing-addon1\" name=\"option\">");
            });
            $("#submit").click(function () {

                var options = [];
                $("input[name='option']").each(function () {
                    options.push($(this).val());
                })
                //console.log(options);

                var title = $("#title").val().toString();

                var endTime = $("#endTime").val().toString();

                votetype = $("input[name='vote_type'][checked]").val();

                let serialize = $("#form").serializeArray();
                var votetype = serialize[0].value;
                //获取主机名和端口
                var host = window.document.location.origin;
                $.ajax({
                    url: "addvote",
                    data: {"title": title, "endTime": endTime, "type": votetype, "options": options.toString()},
                    type: "post",
                    success: function (result) {
                        alert("添加成功！");
                        window.location.replace(host + "/main.jsp");
                    },
                    error: function (e) {
                        alert("发生错误，添加失败！")
                    }
                })
                return true;
            })
        })
</script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        minView : "day", //  选择时间时，最小可以选择到那层；默认是‘hour’也可用0表示
        language : 'zh-CN', // 语言
        initialDate:new Date(),//默认值
        autoclose : true, //  true:选择时间后窗口自动关闭
        format : 'yyyy-mm-dd hh:00:00', // 文本框时间格式，设置为0,最后时间格式为2017-03-23 17:00:00
        todayBtn : true, // 如果此值为true 或 "linked"，则在日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。
        startDate : new Date() ,  // 窗口可选时间从今天开始
    }
    );
</script>
</body>
</html>
