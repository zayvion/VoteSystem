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
        body {
            margin-top: 70px;
        }

        #welcome {
            font-size: 16px;
            line-height: 50px;
        }

        a {
            padding-left: 10px;
            text-decoration: none;
            cursor: pointer;
            color: inherit;
        }

        .progress-bar {
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
            <li role="presentation"><a href="main.jsp">投票管理</a></li>
            <li role="presentation" class="active"><a href="new_vote.jsp">新建投票</a></li>
        </ul>
    </div>
    <div class="col-lg-8">
        <form id="form">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h2 class="panel-title">参与投票</h2>
                </div>

                <div class="panel-body">
                    <label id="vote_title" type=""></label>
                    <br>
                    <div id="vote_option">
                        <%--<p><input type="radio" name="a" value="">迅雷</p>
                        <p><input type="radio" name="a" value="">迅雷</p>
                        <p><input type="radio" name="a" value="">迅雷</p>
                        <p><input type="radio"name="a" value="">迅雷</p>--%>
                        <%--<p><label><input type='checkbox' value='' name='checkbox'>选项 1</label></p>
                        <p><label><input type="checkbox" value="" name="checkbox">选项 1</label></p>
                        <p><label><input type="checkbox" value="" name="checkbox">选项 1</label></p>
                        <p><label><input type="checkbox" value="" name="checkbox">选项 1</label></p>--%>
        </form>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="vote(${id})">投票</button>
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
<script>
    $(function () {
            var uid = <%= session.getAttribute("userid")%>;
                //为管理员添加用户管理
                if (uid== 1) {
                    $("#menu").append("  <li role='presentation'><a href='manage_user.jsp'>用户管理</a></li>");
                }
            let href = window.location.href;
            let indexOf = href.indexOf("=");
            var id = href.substring(indexOf + 1, href.length)
            console.log(id);
            $.ajax({
                url: "getdata",
                data: "id=" + id,
                type: "get",
                datatype: "json",
                success: function (result) {
                    console.log(result);
                    $("#vote_title").attr("type", result.type);
                    $("#vote_title").append(result.title);
                    if (result.type == '0') {
                        $.each(result.options, function (index, item) {
                            $("#vote_option").append($("<p><input type='radio' name='radio' value='" + item.id + "'>" + item.option + "</p>"));
                            $('input:radio:first').attr('checked', 'checked');
                        })
                    } else {
                        $.each(result.options, function (index, item) {
                            //var tag = $("<p><input type='radio' name='a' value='"+item.id+"'>"+item.option+"</p>")
                            $("#vote_option").append($("<p><label><input type='checkbox' value='" + item.id + "' name='checkbox'>" + item.option + "</label></p>"))
                        })
                    }


                }

            });
            $("#addoption").click(function () {
                $("#options").append("<input type=\"text\" class=\"form-control\" placeholder=\"请输入选项\" aria-describedby=\"sizing-addon1\">");
            });
        }
    )

        function vote(id) {
        console.log($("#vote_title").attr("type"))
        let array = $("#form").serializeArray();
        let optionvalue = array[0].value;
        var optionvalues = [];
         optionvalues = array;
        console.log(optionvalue.toString());
        if ($("#vote_title").attr("type") == "0") {
            $.ajax({
                url: "addresult",
                data: {
                    "s_id": id,
                    "userid":<%=session.getAttribute("userid")%>,
                    "o_id":optionvalue.toString(),
                    "type":0
                },
                type: "post",
                success: function (result) {
                    window.location.replace("<%= basePath+"main.jsp"%>");
                },
                error: function (e) {

                }
            })
        }else if ($("#vote_title").attr("type") == "1"){
            let length = optionvalues.length;
          $.ajax({
                url: "addresult",
                data: {
                    "s_id": id,
                    "userid":<%=session.getAttribute("userid")%>,
                    "length":length,
                    "o_id":optionvalues,
                    "type":1
                },
                type: "post",
                success: function (result) {
                    window.location.replace("<%= basePath+"main.jsp"%>");
                },
                error: function (e) {

                }
            })
        }
    }
</script>
</body>
</html>
