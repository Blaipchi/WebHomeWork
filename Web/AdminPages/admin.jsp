<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dao.DBServices" %>
<%@ page import="java.util.*" %>
<%@ page import="pojo.*" %>
<%@ page import="dao.UsersDAO" %>
<!DOCTYPE html>
<html>
<head>
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
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light" onload="showUserInfo()">
<div class="container bg-white rounded mt-5 p-4">
    <div class="row">
        <div class="col">
            <h2 class="mb-3">用户管理平台</h2>
        </div>
        <div class="col text-right">
            <h4 class="mb-0">管理员: <%=((User) session.getAttribute("user")).getUsername() %></h4>
            <button class="btn btn-primary mt-2" onclick="window.location.href='../LoginPage/login.jsp';">退出登录</button>
        </div>
    </div>
    <hr>

    <div class="row mt-4">
        <div class="col">
            <h5>用户列表</h5>
            <form name="MyForm" method="post">
                <table class="table table-striped mt-3">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">用户ID</th>
                        <th scope="col">用户名</th>
                        <th scope="col">用户类别</th>
                        <th scope="col">操作</th>
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
                        <td><input name="username" value="<%=username%>" disabled></td>
                        <td>
                            <select name="flag">
                                <option value="0" <%= flag == 0 ? "selected" : "" %>>管理员</option>
                                <option value="1" <%= flag == 1 ? "selected" : "" %>>普通用户</option>
                            </select>
                        </td>
                        <td>
                            <button class="btn btn-primary" onclick="updateFlag(<%=uid%>,<%=flag%>)">修改权限</button>
                            <button class="btn btn-danger" onclick="deleteUser(<%=uid%>)">删除</button>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<script src="js/scripts.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>