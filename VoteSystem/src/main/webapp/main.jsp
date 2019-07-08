<%--
  User: zayvion
  Date: 2019-06-28
  Time: 16:19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1",maximum-scale=1,user-scalable=no">
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
        a{
            text-decoration: none;
            color:inherit;
            cursor: pointer
        }
        #search_btn{
            height: 34px;
        }
    </style>
</head>
<body>
<!-- 修改投票模态框 -->
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
                            <input type="text" name="vote_title" class="form-control" id="vote_title_input" placeholder="请输入标题">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">投票类型</label>
                        <div class="col-sm-10">
                            <input type="radio" class="checkbox-inline" name="vote_type" value="0">单选
                            <input type="radio" class="checkbox-inline" name="vote_type" value="1">多选
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">投票选项</label>
                        <div class="col-sm-10" id="vote_options">
       <%--                 <input type="text" name="item " class="form-control"value="跑步"><br>
                            <input type="text" name="item " class="form-control"value="跑步"><br>
                            <input type="text" name="item " class="form-control"value="跑步"><br>--%>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="vote_save_btn">保存</button>
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

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-danger" id="del_button">删除</button>
            </div>
        </div>
    </div>
</div>
<div class="container container-fluid">
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
            <div class="input-group">
                <input type="text" id="search_input" class="form-control" aria-label="Text input with multiple buttons" placeholder="请输入关键字" style="width: 40%;float: right">
                <div class="input-group-btn">
                    <button type="button" id="search_btn" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                </div>
            </div><!-- /.input-group -->
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


<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/bootstrap/js/bootstrap.js"></script>
<script>
    var uid = <%= session.getAttribute("userid")%>;
    $(function () {
        //为管理员添加用户管理
        if (uid== 1) {
            $("#menu").append("  <li role='presentation'><a href='manage_user.jsp'>用户管理</a></li>");
        }

        $.ajax({
            url: "getall",
            data: "userid="+<%=session.getAttribute("userid")%>,
            type: "get",
            datatype: "json",
            success: function (result) {
                var userid =<%= session.getAttribute("userid")%>;
                $.each(result, function (index, item) {
                    //console.log( item.create_time);
                    var join_button = "<a href='vote?id="+item.id+"'><button  type='button'  class='btn btn-success btn-sm' isJoin='"+item.isJoin+"' isValidTime='"+item.isValidTime+"'>参与投票</button></a>&nbsp;&nbsp;&nbsp;&nbsp;";
                    var edit_button = "<input type='button' value='不可修改' class='btn btn-primary btn-sm disabled' name='button' onclick='update("+item.id+")' oper_user='"+item.oper_user+"' joinNum='"+item.joinNum+"' isjoin='"+item.isJoin+"' isInvalid='"+item.isInvalid+"'>&nbsp;&nbsp;&nbsp;&nbsp;";
                    var del_button = "<button type='button'  class='btn btn-danger btn-sm disabled' onclick='confirm_del(" + item.id + ")' oper_del='"+item.oper_user+"'>不可删除</button>";
                    var p = $("<p></p>").addClass("text-right").append(join_button).append(edit_button).append(del_button);
                    var span = "<span>共有<strong>"+item.optionNum+"</strong>个选项，网友已参加<strong>"+item.joinNum+"</strong>次投票</span>";
                    var panel_body = $("<div></div>").addClass("panel-body").append(span).append(p);
                    var panel_title = $("<h3></h3>").addClass("panel-title").append("<a href='result?id="+item.id+"'"+">"+item.title+"</a>");
                    var panel_heading = $("<div></div>").addClass("panel-heading").append(panel_title);
                    var panel = $("<div></div>").addClass("panel panel-default panel-info").append(panel_heading).append(panel_body);
                    $("#content").append(panel);
                    //参加过投票的禁止投票
                    $("button[isJoin=true]").empty().append("已投票");
                    $("button[isJoin=true]").addClass("disabled");
                    //自己创建的投票且未投票过才允许修改
                    $("input[oper_user=<%= session.getAttribute("userid")%>]").val("修改").removeClass("disabled");
                    $(".text-right input[isjoin= true]").val("不可修改").addClass("disabled");
                    $(".text-right input[joinNum!= 0]").val("不可修改").addClass("disabled");
                    //超过一天显示超时，不能投票
                    $("button[isValidTime= false]").empty().append("已超时");
                    $("button[isValidTime= false]").addClass("disabled");
                    $("button[oper_del = <%= session.getAttribute("userid")%>]").empty().removeClass("disabled").append("删除");


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
                //console.log(result);
                $.each(result, function (index, item) {
                    //console.log(item.title)
                    var edit_button = "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"update(" + item.id + "\)\">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;";
                    var del_button = "<bu#tton type=\"button\" class=\"btn btn-danger btn-sm\" onclick=\"confirm_del(" + item.id + "\)\">删除</button>";
                    var p = $("<p></p>").addClass("text-right").append(vote_button).append(edit_button).append(del_button);
                    var span = "<span>共有<strong>2</strong>个选项，已有<strong>2</strong>个网友参与</span>";
                    var panel_body = $("<div></div>").addClass("panel-body").append(span).append(p);
                    var panel_title = $("<h3></h3>").addClass("panel-title").append(item.title);
                    var panel_heading = $("<div></div>").addClass("panel-heading").append(panel_title);
                    var panel = $("<div></div>").addClass("panel panel-default panel-info").append(panel_heading).append(panel_body)

                    $("#content").append(panel);

                })
            }
        })

    }
    function loadData(id) {
        $.ajax({
            url: "getdata",
            data: "id="+id,
            type: "get",
            datatype: "json",
            success: function (result) {
                //console.log(result);
                $("input[name=vote_title]").val(result.title);
                $("input[name=vote_type]").val([result.type]).attr('checked', 'checked');
                $.each(result.options,function (index,item) {
                    $("#vote_options").append("<input type='text' name='item' class='form-control' value="+item.option+" oid='"+item.id+"'><br>")
                })
                $("#vote_save_btn").click(function () {
                    save(id);
                });
            }

        })
    }
    function cleanOptions() {
        $("#vote_options").empty();
    }
    function update(id) {
        cleanOptions();
        loadData(id);
        $('#vote_update').modal().show();
    }

    function save(id) {
        var arr=new Array();
        var num;
         num = $("input:text[name=item]").length
        for (var i = 0; i <= $("input:text[name=item]").length-1; i++) {
            var data;
           data = {
                "id": $("input:text[name=item]").eq(i).attr("oid"),
                "option": $("input:text[name=item]").eq(i).val()
            }
            arr[i]=data;

            }
        console.log($("input[name='vote_type']:checked").val());
        $.ajax({
            url: "update",
            data: {
                "length":num,
                "id":id,
                "title":$("#vote_title_input").val(),
                "type":$("input[name='vote_type']:checked").val(),
                "options":arr,
            },
            type: "get",
            datatype: "json",
            success: function (result) {
                //console.log(result);
                $('#vote_update').modal('hide');
                window.location.replace("<%=basePath%>main.jsp");

            }

        })
    }
    function confirm_del(id) {
        $("#confirm_del .modal-body").append("<span style='font-size: 16px'>是否删除id为"+id+"的投票题目吗？</span>");
        $('#confirm_del').modal('show');
        $("#del_button").click(function () {
            del(id);
            window.location.replace("<%= basePath+"main.jsp"%>");
        });

    }

    function del(id) {
        $.ajax({
            url: "del",
            data: "id="+id ,
            type: "post",
            datatype: "json",
            success: function (result) {
                //console.log(result);
                $('#confirm_del').modal('hide');
            }

        })
    }

$("#search_btn").click(function () {
    if ($("#search_input").val() ==''){
        window.location.replace("<%= basePath+"main.jsp"%>");
    } else {
        $.ajax({
            url: "search",
            data: {
                "userid":<%=session.getAttribute("userid")%>,
                "condition":$("#search_input").val(),
            },
            type: "post",
            datatype: "json",
            success: function (result) {
                $("#content").empty();
                var userid =<%= session.getAttribute("userid")%>;
                console.log("abc"+result);
                $.each(result, function (index, item) {
                    var join_button = "<a href='vote?id="+item.id+"'><button  type='button'  class='btn btn-success btn-sm' isJoin='"+item.isJoin+"' isValidTime='"+item.isValidTime+"'>参与投票</button></a>&nbsp;&nbsp;&nbsp;&nbsp;";
                    var edit_button = "<input type='button' value='不可修改' class='btn btn-primary btn-sm disabled' name='button' onclick='update("+item.id+")' oper_user='"+item.oper_user+"' joinNum='"+item.joinNum+"' isjoin='"+item.isJoin+"' isInvalid='"+item.isInvalid+"'>&nbsp;&nbsp;&nbsp;&nbsp;";
                    var del_button = "<button type='button'  class='btn btn-danger btn-sm disabled' onclick='confirm_del(" + item.id + ")' oper_del='"+item.oper_user+"'>不可删除</button>";
                    var p = $("<p></p>").addClass("text-right").append(join_button).append(edit_button).append(del_button);
                    var span = "<span>共有<strong>"+item.optionNum+"</strong>个选项，网友已参加<strong>"+item.joinNum+"</strong>次投票</span>";
                    var panel_body = $("<div></div>").addClass("panel-body").append(span).append(p);
                    var panel_title = $("<h3></h3>").addClass("panel-title").append("<a href='result?id="+item.id+"'"+">"+item.title+"</a>");
                    var panel_heading = $("<div></div>").addClass("panel-heading").append(panel_title);
                    var panel = $("<div></div>").addClass("panel panel-default panel-info").append(panel_heading).append(panel_body);
                    $("#content").append(panel);
                    //参加过投票的禁止投票
                    $("button[isJoin=true]").empty().append("已投票");
                    $("button[isJoin=true]").addClass("disabled");
                    //自己创建的投票且未投票过才允许修改
                    $("input[oper_user=<%= session.getAttribute("userid")%>]").val("修改").removeClass("disabled");
                    $(".text-right input[isjoin= true]").val("不可修改").addClass("disabled");
                    $(".text-right input[joinNum!= 0]").val("不可修改").addClass("disabled");
                    //超过一天显示超时，不能投票
                    $("button[isValidTime= false]").empty().append("已超时");
                    $("button[isValidTime= false]").addClass("disabled");
                    $("button[oper_del = <%= session.getAttribute("userid")%>]").empty().removeClass("disabled").append("删除");


                })
            }
        })
    }
});

</script>

</body>
</html>