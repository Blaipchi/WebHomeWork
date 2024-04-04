<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dao.dataBaseDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

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
                String sql = "select uid,flag from users";
                ResultSet res = dataBaseDAO.queryBySql(sql);
                Map<String,Integer> userMap = new HashMap<>();
                while(res.next()){
                    userMap.put(res.getString("uid"),res.getInt("flag"));
                }
                session.setAttribute("userMap",userMap);
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

        .adminInfo{
            width: auto;
            height: 70px;
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
    </style>
</head>
<body onload="showUserInfo()">
<div class="sty1">
        <div class="sty2">
            <h3>计算机知识交流平台分享-用户管理</h3>
            <hr color="skyblue">
        </div>
        
        <div class="adminInfo">
            <h4 style="margin-top: -10px;">adminName:</h4>
            <input type="button" value="返回" onclick="" style="margin-right: 30px;">
            <input type="button" value="退出登录" onclick="">
            <hr color="skyblue">
        </div>

        <div class="users">
            <h5>用户列表</h5>
            <hr style= "border:1px dashed skyblue;">
            <form action="" method="post" id="MyForm">
            <table style="overflow-y: scroll;">
                <thead>	
                    <tr>
                        <pre style="font-weight:bolder">
  uid            权限           操作
                        </pre>
                    </tr>
                </thead>
                
                <tbody> 
                    <%
                        Map<String,Integer> users = new HashMap<>();
                        users = (Map<String,Integer>)session.getAttribute("userMap");
                        for(Map.Entry<String, Integer> entry : users.entrySet()) {
                            String key = entry.getKey();
                            int value = entry.getValue();
                    %>
                    <tr>
                        <td><%=key%></td>
                        <td><%=value%></td>
                        <td>
                            <input type="button" value="修改权限" onclick="document.getElementById('MyForm').action = 'AddAdminServlet'">
                            <input type="button" value="删除" onclick="document.getElementById('MyForm').action = 'DeleteUserServlet'">
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