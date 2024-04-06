package bean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class User {
    String uid;
    String username;
    String password;
    String email;
    int age;
    int flag;
    List<Article> articleList;

    public User() {

    }
    public User(String uid, String username, String password, String email, int age, int flag, List<Article> articleList) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.flag = flag;
        this.articleList = articleList;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    //校验注册时的用户名密码是否符合要求，下面时AI自动生成的可供参考
    public boolean checkRegister(String username, String password, String email, int age) {
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

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, String email, int i) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = i;
    }

    public User(ResultSet resultSet) throws SQLException {
        this.uid = resultSet.getString("uid");
        this.username = resultSet.getString("username");
        this.password = resultSet.getString("password");
        this.email = resultSet.getString("email");
        this.age = resultSet.getInt("age");
        this.flag = resultSet.getInt("flag");
    }
    
}
