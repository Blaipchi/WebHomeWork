package pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer uid;
    private Integer artid;
    private String title;
    private String content;
    private Date publicTime;

    public Article()
    {

    }

    public Article(Integer uid, String title, String content)
    {
        this.uid = uid;
        this.title = title;
        this.content = content;
    }

//    public Article(String uid, String artid, String title, String content, String publicTime)
//    {
//        this.uid = uid;
//        this.artid = artid;
//        this.title = title;
//        this.content = content;
//        this.publicTime = publicTime;
//    }

//    public String getUid() {
//        return uid;
//    }
//
//    public void setUid(String uid) {
//        this.uid = uid;
//    }
//
//    public String getArtid() {
//        return artid;
//    }
//
//    public void setArtid(String artid) {
//        this.artid = artid;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getPublicTime() {
//        return publicTime;
//    }
//
//    public void setPublicTime(String publicTime) {
//        this.publicTime = publicTime;
//    }
}
