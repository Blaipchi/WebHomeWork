<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dao.DBServices" %>
<%@ page import="java.util.*" %>
<%@ page import="pojo.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>
    <style>
        .register-button {
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
    <form action="register" method="post" id="registerForm">
        用户名:<input type="text" name="username" id="username" value="${messageModel.object.username}"><br>
        密码:<input type="password" name="password" id="password" value="${messageModel.object.password}"><br>
        确认密码:<input type="password" name="confirmPassword" id="confirmPassword"><br>
        <span id="regMsg" style="font-size:12px; color: red">${messageModel.msg}</span><br>
        <button type="button" id="registerBtn">注册</button>
        <a href="login.jsp" class="register-button">返回登录页面</a>
    </form>
</div>
</body>
<%-- 引入Jquery的js文件 --%>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $("#registerBtn").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();

        if (!isEmpty(username)) {
            $("#regMsg").html("用户名不能为空!");
            return;
        }
        if (!isEmpty(password)) {
            $("#regMsg").html("密码不能为空!");
            return;
        }
        if (password !== confirmPassword) {
            $("#regMsg").html("两次输入的密码不一致!");
            return;
        }

        // 如果都不为空且密码一致，则手动提交表单
        $("#registerForm").submit();
    });

    function isEmpty(str) {
        if (str == null || str == "") {
            return true;
        }
        return false;
    };
</script>
</html>
