<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dao.DBServices" %>
<%@ page import="java.util.*" %>
<%@ page import="pojo.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>
    <style>        .register-button {
        display: inline-block;
        padding: 8px 16px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .register-button:hover {
        background-color: #45a049;
    }
    </style>
</head>
<body>
<div style="text-align: center">
    <form action="/login" method="post" id="loginForm">
        姓名:<input type="text"name="uname" id="uname" value="${messageModel.object.userName}"><br>
        密码:<input type="password" name="upwd" id="upwd" value="${messageModel.object.userPwd}"> <br>
        <span id="msg" style="font-size:12px;color: red">${messageModel.msg}</span> <br>
        <button type="button" id="loginBtn">登录</button>
        <a href="Register.jsp" class="register-button">前往注册页面</a>
    </form>
</div>
</body>
<%--引入Jquery的js文件 --%>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $("#loginBtn").click(function () {
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();
        if(!isEmpty(uname)){
            $("#msg").html("用户名不能为空!");
            return;
        }
        if(!isEmpty(upwd)){
            $("#msg").html("密码不能为空!");
            return;
        }
        //如果都不为空，则手动提交表单
        $("#loginForm").submit();
    });
    function isEmpty(str) {
        if (str == null || str == "") {
            return true;
        }
        return false;
    };
</script>
</html>

