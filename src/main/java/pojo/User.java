package pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
* 用户
* @TableName user
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
    private String userName;

    /**
    * 密码
    */
    private String userPassword;

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
    private String userRole;

    /**
     * 用户所属文章表
     */
    private List<Article> articleList;

    public boolean checkRegister() {
        if (userName.length() >= 6 && userName.length() <= 20) {
            if (userPassword.length() >= 6 && userPassword.length() <= 20) {
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
