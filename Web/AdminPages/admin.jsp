<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dao.DBServices" %>
<%@ page import="java.util.*" %>
<%@ page import="pojo.*" %>
<%@ page import="dao.UsersDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User</title>
    <script>
        function showUserInfo(){
            <%
            User ul = (User) session.getAttribute("user");

            UsersDAO usersDAO = new UsersDAO();
            List<User> lut = usersDAO.selectAllUsers();
            session.setAttribute("userMap",lut);

            %>
        }

        function updateFlag(uid,flag){
            document.MyForm.action="../AddAdminServlet?uid="+uid+"&flag="+flag;
            document.MyForm.submit();
        }
        function deleteUser(uid){
            document.MyForm.action="../DeleteUserServlet?uid="+uid;
            document.MyForm.submit();
        }

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
            text-shadow: 1px 1px rgb(128, 128, 128);
            background-color:white;
            color:black;
            width:80px;
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
    </style>
</head>
<body onload="showUserInfo()">
<div class="sty1">
    <div class="sty2">
        <h3>计算机知识交流平台分享-用户管理</h3>
        <hr color="skyblue">
    </div>

    <div class="adminInfo">
        <h4 style="margin-top: -10px;">adminName:<%=ul.getUsername() %></h4>
        <input type="button" value="退出登录" onclick="window.location.href='../LoginPage/Login.jsp';">
        <hr color="skyblue">
    </div>

    <div class="users">
        <h5>用户列表</h5>
        <hr style= "border:1px dashed skyblue;">
        <form name="MyForm" method="post">
            <table style="overflow-y: scroll;">
                <thead>
                <tr>
                            <pre style="font-weight:bolder">
uid      usernamme      flag      操作
                            </pre>
                </tr>
                </thead>

                <tbody>
                <%
                    List<User> lu = (ArrayList<User>)session.getAttribute("userMap");
                    for(int i=0;i<lu.size();++i) {
                        User j = lu.get(i);
                        int uid = j.getUid();
                        String username = j.getUsername();
                        int flag = j.getFlag();
                %>
                <tr>
                    <td><input name="uid" value="<%=uid%>" disabled></td>
                    <td><input name="username" value="<%=username%>"></td>
                    <td><input name="flag" value="<%=flag%>"></td>

                    <td>
                        <input type="button" value="修改权限" onclick="updateFlag(<%=uid%>,<%=flag%>)">
                        <input type="button" value="删除" onclick="deleteUser(<%=uid%>)">
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </form>
    </div>
</div>
</body>
</html>