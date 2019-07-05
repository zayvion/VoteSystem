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
    <title>查看结果</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
    <style>
        body { margin-top: 70px; }
        #welcome {
            font-size: 16px;
            line-height: 50px;
        }
        a{
            padding-left:10px ;
            text-decoration:none;
            cursor: pointer;
            color: inherit;
        }
        .progress-bar{
            min-width: 2em;
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
        <ul class="nav nav-pills nav-stacked" id="menu">
            <li role="presentation" class="active"><a href="main.jsp">投票管理</a></li>
            <li role="presentation"><a href="new_vote.jsp">新建投票</a></li>
        </ul>
    </div>
    <div class="col-lg-8">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h2 class="panel-title">查看投票</h2>
            </div>
            <div class="panel-body" >
                <label style="font-size: 25px">${title}</label><br>
                <label id="endTime">本题截止投票时间：${endTime}</label>
                <div id="vote_info"> </div>
                <%-- <p>共有<strong>2</strong>个选项，已有<strong>2</strong>个网友参与</p>--%>
                <div id="process"></div>
                <%--<br>
                    <span>qq旋风（10%)</span>
                <div class='progress'>
                    <div class='progress-bar progress-bar-info progress-bar-striped active' role='progressbar' aria-valuenow='60' aria-valuemin='0' aria-valuemax='100' style='width: 10%;'>
                    </div>
                </div>--%>

            </div>
                &nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-primary" id="back_btn">返回投票列表</button>
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
        var uid = <%= session.getAttribute("userid")%>;
            //为管理员添加用户管理
            if (uid== 1) {
                $("#menu").append("  <li role='presentation'><a href='manage_user.jsp'>用户管理</a></li>");
            }
            let href = window.location.href;
            let indexOf = href.indexOf("=");
            var id = href.substring(indexOf+1,href.length)
            console.log(id);
            $.ajax({
                url: "analyze",
                data: "id="+id,
                type: "get",
                datatype: "json",
                success: function (result) {
                    console.log(result);
                    var p = $("<p>本题共有<strong>"+result.length+"</strong>个选项，选择结果如下：</p>");
                    $("#vote_info").append(p);
                    $.each(result,function (index,item) {
                       var result_item =  $(" <br>\n" +
                            "                    <span>"+item.option+"（"+item.scale+"%)</span>\n" +
                            "                <div class='progress'>\n" +
                            "                    <div class='progress-bar progress-bar-info progress-bar-striped active' role='progressbar' aria-valuenow='60' aria-valuemin='0' aria-valuemax='100' style='width: "+item.scale+"%;'>\n" +
                            "                    </div>\n" +
                            "                </div>");
                       $("#process").append(result_item);
                    })
                }

            });



            $("#addoption").click(function () {
                $("#options").append("<input type=\"text\" class=\"form-control\" placeholder=\"请输入选项\" aria-describedby=\"sizing-addon1\">");
            });
        }
    )
    $("#back_btn").click(function () {
        window.location.replace("<%= basePath%>main.jsp")
    })
</script>
</body>
</html>
