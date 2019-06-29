<%--
  User: zayvion
  Date: 2019-06-29
  Time: 10:05
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
    <title>后台管理系统-登录</title>
    <link rel="stylesheet" type="text/css" href="assets/css/homepage.css">
    <script type="text/javascript" src="assets/js/jquery-1.11.1.min.js"></script>
    <base href="<%=basePath%>">
</head>
<body>
<div class="bfb tc"></div>
<div class="bfb tc login_text">在线投票系统后台管理</div>
<form id="loginForm" action="/login" method="POST" role="form">
    <input type="hidden" name="usertype" value="0">
    <div class="login_page">
        <div class="bfb tc pst">
            <input style="border-radius:4px 4px 0 0;width:100%;margin:0;height:45px;padding:10px 8px" class="form-control login_line" name="loginInfo.nick" id="nickLogin" type="text" placeholder="管理员账户">
            <div class="login_prompt fs14" id="nickMsg" style="display:none;" ></div>
            <br><br>
            <div class="bfb tc pst">
                <input style="border-radius:0 0 4px 4px;width:100%;margin:0;height:45px;padding:10px 8px"  class="form-control" name="loginInfo.password" id="passwordLogin" type="password" placeholder="密码">
                <div class="login_prompt fs14" id="passwordMsg" style="display:none;" ></div>
            </div>
            <div class="bfb tc">
                <button type="button" class="btn btn-primary login_signin" onclick="login();"/>
                立即登录
                </button>
            </div>
            <div id="go_login"><a href="/">去前台</a></div>
            <div class="bfb tc lh30 fs14 cl4 login_page_input">
                <div class="fl"></div>
            </div>

            <div class="bfb tc">

            </div>
        </div>
    </div>
</form>

</body>
</html>
