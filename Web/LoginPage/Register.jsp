<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>
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

        .login-link {
            display: block;
            text-decoration: none;
            color: #4CAF50;
            margin-top: 10px;
            font-size: 14px;
        }

        .login-link:hover {
            text-decoration: underline;
        }
        h1{
            color: #007bff;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>注册页面</h1>
    <form action="../RegisterServlet" method="post" id="registerForm">
        <div class="form-group">
            <label for="username">用户名:</label><br>
            <input type="text" name="username" id="username" required>
        </div>
        <div class="form-group">
            <label for="password">密码:</label><br>
            <input type="password" name="password" id="password" required>
        </div>
        <div class="form-group">
            <button type="submit" id="registerBtn">注册</button>
        </div>
        <a href="login.jsp" class="login-link">返回登录页面</a>
    </form>
</div>
<!-- JavaScript 脚本 -->
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#registerBtn").click(function () {
            var username = $("#username").val();
            var password = $("#password").val();

            if (!isEmpty(username) || !isEmpty(password)) {
                alert("用户名和密码不能为空！");
                return false;
            }
        });

        function isEmpty(str) {
            return !str.trim().length;
        }
    });
</script>
</body>
</html>
