package dao;

import pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {

    /*验证登录是成功，成功返回true，失败返回false
    传入一个User对象，该User对象保存这登录是的账号和密码，然后与数据库中的进行查询
     */
    public boolean checkLogin(String username,String password){
        //mysql查询语句,根据账号查询用户是否已经注册
        String sql = "select * from user where username = '" + username + "'";

        //数据库的查询
        ResultSet resultSet = DBServices.queryBySql(sql);

        System.out.println(resultSet);

        //用user1存储从数据库中读取的该用户的账号和密码
        User user1 = new User();
        //判断数据库中查询到的结果是否为空
        if(resultSet != null){
            try{
                //据库中查询到的结果不为空，则执行下面的代码
                if(resultSet.next()) {
                    //查询到后将从数据库中查询的账号密码存储在user1中
                    user1.setUsername(resultSet.getString("username"));
                    user1.setPassword(resultSet.getString("password"));
                }else{
                    //查询不到报错，返回false，退出。
                    System.out.println("用户不存在");
                    return false;
                }
                //判断从数据库中查询到的账号和密码是否与用户输入的账号和密码一致
                if(user1.getUsername().equals(username) && user1.getPassword().equals(password)){
                    //账号和密码一致，返回true
                    return true;
                }else{
                    //账号和密码不一致，返回false
                    return false;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //如果数据库中查询到的结果为空，则返回false
        return false;
    }

    /*注册完后，在数据库中的users表中添加该注册的用户，成功添加返回true,添加失败返回false
    输入User对象，该对象保存着用户注册的信息,并将该信息添加到数据库users表中
     */
    public boolean addUser(User user){
        //获取用户注册的信息
        String username = user.getUsername();
        String password = user.getPassword();
        //注册用户全权限默认是：1
        Integer flag = 1;

        //mysql插入语句
        String sql = "insert into user(username,password) values('" + username + "','" + password + "')";

        //执行插入语句
        if(DBServices.modifyBySql(sql) == 1){
            //插入成功，返回true
            return true;
        }else {
            //插入失败，返回false
            return false;
        }
    }

    /*用户修改个人信息后，数据库中users表中的信息也要更新，修改成功返回true，修改失败返回false
    输入User对象，该对象保存着用户修改的信息,并将该信息添加到数据库users表中
     */
    public boolean updateUserInfo(User user){
        //获取用户修改的信息
        Integer uid = user.getUid();
        String password = user.getPassword();
        String email = user.getEmail();
        Integer age = user.getAge();

        //判断用户是否输入了修改的信息
        if(password != null && email != null && age != 0){
            //用户输入了修改的信息
            //mysql更新uid为uid用户的password,email,age的语句
            String sql = "update user set password = '" + password + "',email = '" + email + "',age = " + age + " where uid = '" + uid + "'";

            //执行更新语句
            if(DBServices.modifyBySql(sql) == 1){
                //更新成功，返回true
                return true;
            }else {
                //更新失败，返回false
                return false;
            }
        }else{
            //用户没有输入修改的信息
            System.out.println("用户没有输入修改的信息");
            return false;
        }
    }

    /*管理员删除用户后，数据库中的user表中该用户也要删除，删除成功返回true,返回失败返回false
        根据用户名，根据用户名删除数据库中的该用户
     */

    public boolean deleteUser(User user){
        //获取用户uid
        Integer uid = user.getUid();

        //mysql删除语句
        String sql = "delete from user where uid = '" + uid + "'";

        //执行删除语句
        if(DBServices.modifyBySql(sql) == 1){
            //删除成功，返回true
            return true;
        }else{
            //删除失败，返回false
            System.out.println("删除失败");
            return false;
        }
    }


    public static User checkFlag(String username,String password){

        User user0 = new User();

        String sql = "select * from user where username = '" + username + "'";

        //数据库的连接
        ResultSet resultSet = DBServices.queryBySql(sql);

            //将获取的信息保存在user0中
            try{
                //判断数据库中查询到的结果是否为空
                if(resultSet.next()) {
                    //查询到后将从数据库中查询的账号密码存储在user0中
                    user0.setUid(resultSet.getInt("uid"));
                    user0.setUsername(resultSet.getString("username"));
                    user0.setPassword(resultSet.getString("password"));
                    user0.setEmail(resultSet.getString("email"));
                    user0.setAge(resultSet.getInt("age"));
                    user0.setFlag(resultSet.getInt("flag"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user0;
    }
}
