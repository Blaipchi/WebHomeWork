<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>文章编辑页面</title>
    <style>
        body {
            display: flex;
            min-height: 100vh;
            align-items: center;
            justify-content: center;
        }

        .container {
            padding: 100px, 0;
            min-width: 900px;
        }

        .container h1 {
            text-align: center;
        }

        .container label {
            display: block;
        }

        .container .btn {
            text-align: center;
        }

        .container .title input{
            padding: .5rem 1rem;
            font-size: 16px;
            width: 100%;
        }

        .container .content textarea {
            padding: 1rem;
            font-size: 16px;
            width: 100%;
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
            <input type="text" id="title" name="title">
        </div>

        <div class="content">
            <label for="content">内容：</label>
            <textarea name="content" id="content" rows="30" style="resize: vertical;"></textarea>
        </div>

        <div class="btn">
            <button type="submit">发布</button>
            <button type="reset">重置</button>
        </div>
    </form>
</div>
</body>
</html>
