<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>user</title>
    <script>

    </script>

    <style>
        .sty1{
            width: 400px;
            height: 600px;
            position: absolute;
            margin-top: 5%;
            margin-left: 35%;
            text-align: center;
            border: 5px solid aqua;
            border-style: outset;
            border-radius: 50px 50px 50px 50px;
            box-shadow:0px 0px 10px 5px #aaa inset;
        }

        .sty2{
            width: auto;
            height: 70px;
            position: relative;
        }

        .adminInfo{
            width: auto;
            height: 70px;
        }

        input{
            text-shadow: 1px 1px gray;
            background-color:white;
            color:black;
            margin-top: 20px;
        }

        .users{
            width: 380px;
            height: 430px;
            margin-top: 10px;
            margin-left: 10px;
            border: 1px solid aqua;
            border-radius: 10px 10px 10px 10px;
            box-shadow:0px 0px 1px 1px #aaa inset;
        }

        th{
            text-align: right;
        }
    </style>
</head>
<body>
<div class="sty1">
    <div class="sty2">
        <h3>计算机知识交流平台分享-个人空间</h3>
        <hr color="skyblue">
    </div>

    <div class="adminInfo">
        <h4 style="margin-top: -10px;">username:
            <%--            --%>
            <%=session.getAttribute("username")%>
        </h4>
        <hr color="skyblue">
    </div>

    <div class="users">
        <input type="button"value="发布的文章" onclick="window.location.href='ArticleSend.jsp';"><br>
        <input type="button" value="编辑个人信息" onclick="window.location.href='userInfo.jsp';"><br>
        <input type="button" value="退出登录" onclick="window.location.href='Login.jsp';">
    </div>
</div>
</body>
</html>