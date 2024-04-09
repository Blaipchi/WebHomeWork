package pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private Integer flag;
    List<Article> articleList;

    public User() {

    }
    public User(String username, String password, String email, Integer age, Integer flag, List<pojo.Article> articleList) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.flag = flag;
        this.articleList = articleList;
    }

}
