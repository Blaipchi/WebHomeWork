package Servlet;

import dao.ArticleDAO;
import pojo.Article;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectAllArticleServlet")
public class SelectAllArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过dao查询数据
        List<Article> articles = new ArticleDAO().findArticle();
        // 将数据保存在session中
        req.getSession().setAttribute("userArticles", articles);
        // 重定向至显示文章信息jsp
        resp.sendRedirect(req.getContextPath() + "/ArticlePages/PrintAllArticle.jsp");
    }
}
