<%--
  Created by IntelliJ IDEA.
  User: zayvion
  Date: 2019-05-07
  Time: 19:45
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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>在线投票系统-注册</title>
    <base href="<%=basePath%>">
    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1>在线投票系统</h1>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>请注册</h3>
                                <p>输入用户名和密码完成注册:</p>
                                <p id="msg" style="color: red">${msg}</p>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-lock"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <form role="form" action="register" method="post" class="login-form">
                                <div class="form-group">
                                    <label class="sr-only" for="form-username">用户名</label>
                                    <input type="text" name="username" placeholder="请输入用户名..."
                                           class="form-username form-control" id="form-username">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="password">密码</label>
                                    <input type="password" name="password" placeholder="请输入密码..."
                                           class="form-password form-control" id="password">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="password2">Password</label>
                                    <input type="password" name="password2" placeholder="请再次输入密码..."
                                           class="form-password form-control" id="password2">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="email">E-mail</label>
                                    <input type="text" name="email" placeholder="请输入邮箱地址..."
                                           class="form-email form-control" id="email">
                                </div>
                                <button type="submit" class="btn" id="sub">注册</button>
                            </form>
                            <a class="text-center center-block" href="${pageContext.request.contextPath}/index.jsp">去登录</a>
                        </div>
                    </div>
                </div>

            </div>

        </div>


        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>

        <!--[if lt IE 10]>
        <script src="assets/js/placeholder.js"></script>
        <![endif]-->
    </div>
</div>
<script>
    $(function () {

        $("#sub").click(function () {
            var uname =$("input[name='username']").val();
            var pwd = $("input[name='password']").val();
            console.log(uname.length)
            var cpwd = $("input[name='password2']").val();
            if (uname.length<5 || uname.length>13) {
                $("#msg").empty();
                $("#msg").append("用户名长度应在5-10位之间!");
                $("input[name='username']").val("");
                return false;
            }
            if (pwd != cpwd) {
                $("#msg").empty();
                $("#msg").append("两次密码不一致!");
                $("input[name='password']").val("");
                $("input[name='password2']").val("");
                return false;
            } else if (pwd == "" || cpwd == "") {
                $("#msg").empty();
                $("#msg").append("密码不能为空!");
                $("input[name='password']").val("");
                $("input[name='password2']").val("");
                return false;
            }else if(pwd.length<5 || pwd.length>13){
                $("#msg").empty();
                $("#msg").append("密码长度应在5-10位之间!");
                $("input[name='password']").val("");
                $("input[name='password2']").val("");
                return false;
            }
            var email = $("input[name='email']").val();
            var regEmail = /^([a-zA-Z0-9_.-]+)@([da-z.-]+).([a-z.]{2,6})$/;
            if (!regEmail.test(email)) {
                $("#msg").empty();
                $("#msg").append("邮箱格式不正确，请重新输入!");
                $("input[name='email']").val("");
                return false;
            }  else {
                return true;
            }

        });
    });

</script>

</body>

</html>