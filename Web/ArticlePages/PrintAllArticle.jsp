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
        * {
            padding: 0;
            margin: 0;
            font-size: 20px;
            font-family: Arial, Helvetica, sans-serif;
        }

        body {
            min-height: 100vh;
        }

        .container {
            max-width: 1000px;
            width: 100%;
            margin: 100px auto;
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 50px;
        }

        .article {
            border: 1px solid black;
            padding: 1rem;
            width: 100%;
        }

        .article h3 {
            text-align: center;
            margin-bottom: 1rem;
        }

        .article p {
            text-indent: 2rem;
        }
    </style>
</head>
<body>
    <%
        // 通过session获取文章数据
        List<Article> articles = (List<Article>) session.getAttribute("userArticles");
    %>
    <div class="container">
        <%
             //循环输出文章信息
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

        <a href="../AdminPages/user.jsp">返回用户界面</a>
    </div>
</body>
</html>