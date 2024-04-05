package dao;

import bean.User;

public class UsersDAO {

    //验证登录是成功，成功返回true，失败返回false
    public boolean checkLogin(User user){
        return false;
    }

    //注册完后，在数据库中的users表中添加该注册的用户，成功添加返回true,添加失败返回false
    public boolean addUser(User user){
        return false;
    }

    //用户修改个人信息后，数据库中users表中的信息也要更新，修改成功返回true，修改失败返回false
    public boolean updateUserInfo(User user){
        return false;
    }

    //管理员删除用户后，数据库中的users表中该用户也要删除，删除成功返回true,返回失败返回false
    public boolean deleteUser(User user){
        return false;
    }


}
