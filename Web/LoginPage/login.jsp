<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            width: 300px;
            text-align: center;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group input[type="text"],
        .form-group input[type="password"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        .form-group button[type="submit"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .form-group button[type="submit"]:hover {
            background-color: #45a049;
        }

        .register-link {
            display: block;
            text-decoration: none;
            color: #4CAF50;
            margin-top: 10px;
            font-size: 14px;
        }

        .register-link:hover {
            text-decoration: underline;
        }
        h1{
            color: #007bff;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>计算机知识交流平台</h1>
    <form action="../LoginServlet" method="post" id="loginForm">
        <div class="form-group">
            <label for="uname">姓名:</label><br>
            <input type="text" name="username" id="uname" required>
        </div>
        <div class="form-group">
            <label for="upwd">密码:</label><br>
            <input type="password" name="password" id="upwd" required>
        </div>
        <div class="form-group">
            <button type="submit" id="loginBtn">登录</button>
        </div>
        <a href="Register.jsp" class="register-link">前往注册页面</a>
    </form>
</div>
</body>
</html>
