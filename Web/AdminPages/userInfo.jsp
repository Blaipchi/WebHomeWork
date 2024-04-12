<%@ page import="pojo.User" %>
<%@ page import="dao.UsersDAO" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Information</title>
    <script>
        function showUserInfo() {
            <%-- 这里是您的原始脚本 --%>
            <%
                User ul = (User) session.getAttribute("user");
                System.out.println("111");
                System.out.println(ul);
                UsersDAO usersDAO = new UsersDAO();
                User user = usersDAO.selectUserByUid(ul.getUid());

                session.setAttribute("userInfo_uid", user.getUid());
                session.setAttribute("userInfo_username", user.getUsername());
                session.setAttribute("userInfo_password", user.getPassword());
                session.setAttribute("userInfo_email", user.getEmail());
                session.setAttribute("userInfo_age", user.getAge());
                session.setAttribute("userInfo_flag", user.getFlag());
            %>
        }
    </script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 50px auto;
            text-align: center;
        }

        .header {
            margin-bottom: 30px;
        }

        .header h1 {
            color: #007bff;
        }

        .users {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            border: 2px solid #007bff;
            border-radius: 10px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"],
        input[type="button"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 20px;
            margin-right: 10px;
        }

        input[type="submit"]:hover,
        input[type="button"]:hover {
            background-color: #0056b3;
        }

        th {
            text-align: right;
            padding-right: 10px;
        }

        td {
            text-align: left;
            padding-left: 10px;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ccc;
        }

        .category {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>User Information</h1>
        <hr>
    </div>

    <div class="users">
        <h2>用户信息</h2>
        <form action="../UpdateUserInfoServlet" method="post">
            <table>
                <tr>
                    <th>用户 ID:</th>
                    <td><%= session.getAttribute("userInfo_uid") %></td>
                </tr>
                <tr>
                    <th>用户名:</th>
                    <td><input name="username" type="text" value="<%= session.getAttribute("userInfo_username") %>"></td>
                </tr>
                <tr>
                    <th>密码:</th>
                    <td><input name="password" type="text" value="<%= session.getAttribute("userInfo_password") %>"></td>
                </tr>
                <tr>
                    <th>电子邮件:</th>
                    <td><input name="email" type="text" value="<%= session.getAttribute("userInfo_email") %>"></td>
                </tr>
                <tr>
                    <th>年龄:</th>
                    <td><input name="age" type="text" value="<%= session.getAttribute("userInfo_age") %>"></td>
                </tr>
                <tr>
                    <th>用户类别:</th>
                    <td><input name="flag" type="text" value="<%
                        if (session.getAttribute("userInfo_flag").equals("1")) {
                            out.print("管理员");
                        } else {
                            out.print("普通用户");
                        }
                    %>" disabled></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="提交">
                        <input type="button" value="取消" onclick="location.reload()">
                        <input type="button" value="返回" onclick="window.location.href='user.jsp';">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
