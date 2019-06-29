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
        body { margin-top: 70px; }
        #welcome{
            font-size: 16px;
            line-height: 50px ;
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
            <li role="presentation" class="active"><a href="main.jsp">投票列表</a></li>
            <li role="presentation"><a href="new_vote.jsp">新建投票</a></li>
            <li role="presentation"><a href="#">投票管理</a></li>
        </ul>
    </div>
    <div class="col-lg-8">
        <div class="panel panel-default panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">你最喜欢哪种下载工具</h3>
            </div>
            <div class="panel-body">
                <span>共有<strong>2</strong>个选项，已有<strong>2</strong>个网友参与</span>
                <p class="text-right">
                    <button type="button" class="btn btn-primary btn-sm">修改</button>&nbsp;&nbsp;
                    <button type="button" class="btn btn-danger btn-sm">删除</button>
                </p>
            </div>
        </div>
        <div class="panel panel-default panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">你最喜欢哪种下载工具</h3>
            </div>
            <div class="panel-body">
                <span>共有<strong>2</strong>个选项，已有<strong>2</strong>个网友参与</span>
                <p class="text-right">
                    <button type="button" class="btn btn-primary btn-sm">修改</button>&nbsp;&nbsp;
                    <button type="button" class="btn btn-danger btn-sm">删除</button>
                </p>
            </div>
        </div>
        <div class="panel panel-default panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">你最喜欢哪种下载工具</h3>
            </div>
            <div class="panel-body">
                <span>共有<strong>2</strong>个选项，已有<strong>2</strong>个网友参与</span>
                <p class="text-right">
                    <button type="button" class="btn btn-primary btn-sm">修改</button>&nbsp;&nbsp;
                    <button type="button" class="btn btn-danger btn-sm">删除</button>
                </p>
            </div>
        </div>
        <div class="panel panel-default panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">你最喜欢哪种下载工具</h3>
            </div>
            <div class="panel-body">
                <span>共有<strong>2</strong>个选项，已有<strong>2</strong>个网友参与</span>
                <p class="text-right">
                    <button type="button" class="btn btn-primary btn-sm">修改</button>&nbsp;&nbsp;
                    <button type="button" class="btn btn-danger btn-sm">删除</button>
                </p>
            </div>
        </div>
        <footer class="modal-footer">
            <h4 class="text-center">在线投票系统</h4>
            <h5 class="text-center">Copyright © 2019&nbsp;&nbsp;&nbsp;2018200279李紫霖. All rights reserved</h5>
        </footer>
    </div>
</div>

<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/bootstrap/js/bootstrap.js"></script>
</body>
</html>
