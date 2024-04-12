<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>文章编辑页面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            display: flex;
            min-height: 100vh;
            align-items: center;
            justify-content: center;
            margin: 0;
            padding: 0;
        }

        .container {
            padding: 20px;
            min-width: 900px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .container h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        .container label {
            display: block;
            margin-bottom: 10px;
        }

        .container input[type="text"],
        .container textarea {
            padding: 10px;
            font-size: 16px;
            width: 100%;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            margin-bottom: 20px;
        }

        .container textarea {
            resize: vertical;
            min-height: 200px;
        }

        .container .btn {
            text-align: center;
        }

        .container button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4a90e2;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 10px;
        }

        .container button[type="reset"] {
            background-color: #ccc;
        }

        .container button:hover {
            background-color: #357ae8;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>文章修改页面</h1>
    <!-- 表单提交到添加文章的servlet -->
    <form action="../AddArticleServlet" method="post">
        <div class="title">
            <label for="title">标题：</label>
            <input type="text" id="title" name="title" required>
        </div>

        <div class="content">
            <label for="content">内容：</label>
            <textarea name="content" id="content" rows="10" required></textarea>
        </div>

        <div class="btn">
            <button type="submit">发布</button>
            <button type="reset">重置</button>
        </div>
    </form>
</div>
</body>
</html>
