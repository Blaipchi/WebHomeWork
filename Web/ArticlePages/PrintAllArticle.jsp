<%@ page import="dao.ArticleDAO" %>
<%@ page import="pojo.Article" %>
<%@ page import="pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>输出所有文章信息页面</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
            min-height: 100vh;
        }

        .container {
            max-width: 1000px;
            width: 90%;
            margin: 50px auto;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .article {
            border: 1px solid #000;
            padding: 20px;
            width: 100%;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        .article h3 {
            text-align: center;
            margin-bottom: 10px;
        }

        .article p {
            text-indent: 2rem;
            line-height: 1.6;
        }

        .back-link {
            margin-top: 20px;
            text-align: center;
        }

        .back-link a {
            background-color: #4a90e2;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .back-link a:hover {
            background-color: #357ae8;
        }
    </style>
</head>
<body>
<div class="container">
    <%
        // 通过session获取文章数据
        List<Article> articles = (List<Article>) session.getAttribute("userArticles");

        // 循环输出文章信息
        for(Article article: articles) {
            String title = article.getTitle();
            String content = article.getContent();
    %>
    <div class="article">
        <h3><%=title%></h3>
        <p><%=content%></p>
    </div>
    <%
        }
    %>
    <div class="back-link">
        <a href="../AdminPages/user.jsp">返回用户界面</a>
    </div>
</div>
</body>
</html>
