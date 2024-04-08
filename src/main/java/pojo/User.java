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

//    public String getUid() {
//        return uid;
//    }
//
//    public void setUid(String uid) {
//        this.uid = uid;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getFlag() {
//        return flag;
//    }
//
//    public void setFlag(int flag) {
//        this.flag = flag;
//    }
//
//    public List<pojo.Article> getArticleList() {
//        return articleList;
//    }
//
//    public void setArticleList(List<pojo.Article> articleList) {
//        this.articleList = articleList;
//    }

    public boolean checkRegister() {
        if (username.length() >= 6 && username.length() <= 20) {
            if (password.length() >= 6 && password.length() <= 20) {
                if (email.length() >= 6 && email.length() <= 20) {
                    if (age >= 18 && age <= 100) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
