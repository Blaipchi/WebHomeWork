package pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
* 用户
* @TableName User
 * 基础字段 get/set 方法已经利用@Data注入
 * 直接用就可以了
*/
@Data
public class User implements Serializable {

    /**
    * id
    */
    private Long uid;

    /**
    * 账号
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 用户角色：user/admin/ban
    */
    private Integer flag;

    /**
     * 用户所属文章表
     */
    private List<Article> articleList;

    public boolean checkRegister() {
        if (username.length() >= 6 && username.length() <= 20) {
            if (username.length() >= 6 && username.length() <= 20) {
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
