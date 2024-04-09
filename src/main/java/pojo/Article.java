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

}
