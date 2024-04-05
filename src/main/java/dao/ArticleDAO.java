package dao;

import bean.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    //点击发布文章后，数据库中的article表中添加该文章的信息,添加成功返回true，添加失败返回false
    public boolean addArticle(){
        return false;
    }

    //修改文章后，数据库中的article表中该文章的信息，也同时发生改变，更改成功返回true，失败返回false
    public boolean updateArticle(){
        return false;
    }

    //删除文章后，数据库中的article表也会删除该文章的所有信息，删除成功返回true，删除失败返回false
    public boolean deleteArticle(){
        return false;
    }

    //查询数据库中article表中的所有文章信息,查询成功返回一个List装有所有文章的articleList
    public List<Article> findArticle(){
        //初始化
        List<Article> articleList = new ArrayList<>();

        return articleList;
    }

    //根据artid查询数据库中article表中的文章信息,查询成功返回一个article类
    public Article findArticleByArtid(){
        //初始化
        Article article;
        article = null;

        return article;
    }

    //根据uid查询数据库中article表中的文章信息,查询成功返回一个article类
    public Article findArticleByUid(){
        //初始化
        Article article;
        article = null;

        return article;
    }


}
