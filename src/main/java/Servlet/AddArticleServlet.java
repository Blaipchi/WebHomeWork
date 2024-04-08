package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        // Integer uid = (Integer) req.getSession().getAttribute("uid");

        /* Article article = new Article(uid,title,content);
        ArticleDAO articleDAO = new ArticleDAO();
        if(articleDAO.addArticle(article)) {
            // 发布文章成功，返回用户界面
            resp.sendRedirect(req.getContextPath()+"/AdminPages/user.jsp");
            System.out.println("文章添加成功");
        } else {
            System.out.println("文章添加失败");
        }
         */
    }
}
