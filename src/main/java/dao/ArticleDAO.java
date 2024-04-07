package dao;

import bean.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    /*点击发布文章后，数据库中的article表中添加该文章的信息,添加成功返回true，添加失败返回false
    将文章的信息存储在对象article中，并且将article对象存储在数据库中
     */
    public boolean addArticle(Article article){
        //获取添加文章的信息
        String uid = article.getUid();
        String artid = article.getArtid();
        String title = article.getTitle();
        String content = article.getContent();
        String publicTime = article.getPublicTime();

        //mysql插入语句
        String sql = "insert into article(uid,artid,title,content,publicTime) values('"+uid+"','"+artid+"','"+title+"','"+content+"','"+publicTime+"')";

        //执行sql语句
        if(DBServices.modifyBySql(sql)==1){
            //添加成功，返回true
            return true;
        }else {
            //添加失败，返回false
            return false;
        }
    }

    /*修改文章后，数据库中的article表中该文章的信息，也同时发生改变，更改成功返回true，失败返回false
    通过文章的artid进行修改，文章content和title两个属性.
     */
    public boolean updateArticle(Article article){
        //获取修改文章的信息
        String artid = article.getArtid();
        String content = article.getContent();
        String title = article.getTitle();

        //mysql修改语句
        String sql = "update article set content='"+content+"',title='"+title+"' where artid='"+artid+"'";

        //判断用户是否输入了修改的信息
        if(content != null && title != null){
            //用户输入了修改的信息
            //执行sql语句
            if(DBServices.modifyBySql(sql)==1){
                //修改成功，返回true
                return true;
            }else {
                //修改失败，返回false
                return false;
            }
        }else {
            //用户没有输入修改的信息
            System.out.println("用户没有输入修改的信息");
            return false;
        }
    }

    /*删除文章后，数据库中的article表也会删除该文章的所有信息，删除成功返回true，删除失败返回false
    通过文章的artid进行删除
     */
    public boolean deleteArticle(Article article){
        String artid = article.getArtid();

        //mysql删除语句
        String sql = "delete from article where artid='"+artid+"'";

        //执行sql语句
        if(DBServices.modifyBySql(sql)==1){
            //删除成功，返回true
            return true;
        }else {
            //删除失败，返回false
            return false;
        }

    }

    /*查询数据库中article表中的所有文章信息,查询成功返回一个List装有所有文章的articleList
     */
    public List<Article> findArticle(){
        //初始化，用于存储查询结果
        List<Article> articleList = new ArrayList<>();
        articleList = null;

        //mysql查询语句
        String sql = "select * from article";

        ResultSet resultSet = DBServices.queryBySql(sql);

        //执行sql语句,并且将查询结果存储在存放在articleList中
        if(resultSet!=null){
            //查询成功
            //将查询结果存储在articleList中
            while (true){
                try {

                    if (!resultSet.next()) break;
                    Article article = new Article();
                    article.setUid(resultSet.getString("uid"));
                    article.setArtid(resultSet.getString("artid"));
                    article.setTitle(resultSet.getString("title"));
                    article.setContent(resultSet.getString("content"));
                    article.setPublicTime(resultSet.getString("publicTime"));
                    articleList.add(article);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            //返回查询成功的articleList
            return articleList;

        }else {
            //查询失败
            System.out.println("查询失败");
            //返回查询失败的articleList，即返回一个空列表
            return articleList;
        }
    }

    /*根据artid查询数据库中article表中的文章信息,查询成功返回一个article类
    输入需要查询的artid，查询成功返回一个article类
     */
    public Article findArticleByArtid(Article article){
        //获取查询的artid
        String artid = article.getArtid();

        //初始化需要返回的article0
        Article article0 = null;

        //mysql的数据库查询根据artid查询语句
        String sql = "select * from article where artid='"+artid+"'";

        ResultSet resultSet = DBServices.queryBySql(sql);

        //执行sql语句,将查询成功的结果存储在article中
        if(resultSet!=null){
            //查询成功
            //将查询结果存储在article中
            try {
                if (resultSet.next()) {
                    article0.setUid(resultSet.getString("uid"));
                    article0.setArtid(resultSet.getString("artid"));
                    article0.setTitle(resultSet.getString("title"));
                    article0.setContent(resultSet.getString("content"));
                    article0.setPublicTime(resultSet.getString("publicTime"));
                }
                //返回查询成功的article0
                return article0;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            //查询失败
            System.out.println("查询失败");
            //返回查询失败的article0，即返回一个空article0
            return article0;
        }
    }

    //根据uid查询数据库中article表中的文章信息,查询成功返回一个article类
    public Article findArticleByUid(Article article){
        //获取查询的uid
        String uid = article.getUid();

        //初始化需要返回的article0
        Article article0 = null;

        //mysql的数据库查询根据uid查询语句
        String sql = "select * from article where uid='"+uid+"'";

        ResultSet resultSet = DBServices.queryBySql(sql);

        //执行sql语句,将查询成功的结果存储在article中
        if(resultSet!=null){
            //查询成功
            //将查询结果存储在article中
            try {
                if (resultSet.next()) {
                    article0.setUid(resultSet.getString("uid"));
                    article0.setArtid(resultSet.getString("artid"));
                    article0.setTitle(resultSet.getString("title"));
                    article0.setContent(resultSet.getString("content"));
                    article0.setPublicTime(resultSet.getString("publicTime"));
                }

                //返回查询成功的article0
                return article0;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            //查询失败
            System.out.println("查询失败");
            //返回查询失败的article0，即返回一个空article0
            return article0;
        }
    }



}
