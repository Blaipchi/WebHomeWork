<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dao.dataBaseDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>userInfo</title>
    <script>
        function showUserInfo(){
            <%
                String ud = (String)session.getAttribute("uid");
                String sql = "select uid,username,password,email,age,flag from users where uid = ";
                sql += ud;
                ResultSet res = dataBaseDAO.queryBySql(sql);
                String uid = "";
                String username = "";
                String password = "";
                String email = "";
                int age = 0;
                int flag = 0;

                while(res.next()){
                    uid = res.getString("uid");
                    username = res.getString("username");
                    password = res.getString("password");
                    email = res.getString("email");
                    age = res.getInt("age");
                    flag = res.getInt("flag");
                }

                session.setAttribute("userInfo_uid",uid);
                session.setAttribute("userInfo_username",username);
                session.setAttribute("userInfo_password",password);
                session.setAttribute("userInfo_email",email);
                session.setAttribute("userInfo_age",age);
                session.setAttribute("userInfo_flag",flag);

                res.close();
            %>
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

        input{
            text-shadow: 1px 1px gray;
            background-color:white;
            color:black;

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
<body onload="showUserInfo()">
<div class="sty1">
    <div class="sty2">
        <h3>计算机知识交流平台分享-个人详细信息</h3>
        <hr color="skyblue">
    </div>

    <div class="users">
        <h5>用户具体信息</h5>
        <form action="UpdateUserInfoServlet" method="post">
            <table style="overflow-y: scroll;">
                <tr>
                    <th>uid:<input id="uid" type="text" value="<%=session.getAttribute("userInfo_uid")%>" disabled></th>
                </tr>
                <tr>
                    <th>username:<input type="text" value="<%=session.getAttribute("userInfo_username")%>"></th>
                </tr>
                <tr>
                    <th>password:<input type="text" value="<%=session.getAttribute("userInfo_password")%>"></th>
                </tr>
                <tr>
                    <th>email:<input type="text" value="<%=session.getAttribute("userInfo_email")%>"></th>
                </tr>
                <tr>
                    <th>age:<input type="text" value="<%=session.getAttribute("userInfo_age")%>"></th>
                </tr>
                <tr>
                    <th>flag:<input type="text" value="<%=session.getAttribute("userInfo_flag")%>" disabled></th>
                </tr>
                <tr>
                    <td colspan="3" style="text-align: center;">
                        <input type="button"value="提交" style="margin-left: 30%;">
                        <input type="button"value="取消" onclick="">
                        <input type="button" value="返回" onclick="window.location.href='user.jsp';">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>