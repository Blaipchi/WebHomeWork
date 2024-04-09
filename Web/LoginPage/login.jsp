<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dao.DBServices" %>
<%@ page import="java.util.*" %>
<%@ page import="pojo.*" %>
<%@ page import="Servlet.*" %>

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
    <form action="../LoginServlet" method="post" id="loginForm">
        姓名:<input type="text" name="username" id="uname"><br>
        密码:<input type="password" name="password" id="upwd"> <br>
        <button type="submit" id="loginBtn">登录</button>
        <a href="Register.jsp" class="register-button">前往注册页面</a>
    </form>
</div>
</body>

</html>

