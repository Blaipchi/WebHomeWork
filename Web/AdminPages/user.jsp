<%@ page import="pojo.User" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            margin-top: 5%;
            width: 600px;
            border-radius: 10px;
            box-shadow: 0 0 10px 0 rgba(33,37,41,.1) !important;
            background-color: #ffffff;
        }
        .title {
            padding: 10px;
            background-color: #007bff;
            color: #ffffff;
            border-radius: 10px 10px 0 0;
        }
        .content {
            padding: 20px;
        }
        .button {
            margin-top: 10px;
            width: 100%;
            font-size: 18px;
            color: #ffffff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="title">
        <h2>个人空间</h2>
    </div>
    <div class="content">
        <hr>
        <h4>uid: <%=((User) session.getAttribute("user")).getUid()%></h4>
        <h4>username: <%=((User) session.getAttribute("user")).getUsername()%></h4>
        <hr>
        <button class="button" onclick="window.location.href='../SelectAllArticleServlet';">全部文章</button>
        <button class="button" onclick="window.location.href='../ArticlePages/EditArticle.jsp';">发布文章</button>
        <button class="button" onclick="window.location.href='userInfo.jsp';">编辑个人信息</button>
        <button class="button" onclick="window.location.href='../LoginPage/login.jsp';">退出登录</button>
    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
