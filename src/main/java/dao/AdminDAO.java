package dao;

import bean.User;

public class AdminDAO {
    /*更改用户的全选，将普通用户更改为管理员，修改完后数据库中的users表中的flag属性也要变，
    修改成功返回true,返回失败返回false*/
    public boolean addAdmin(User user){
        //获取用户user的flag属性
        String uid = user.getUid();

        //mysql修改语句,通过用户的uid,将数据库中的flag属性改为0
        String sql = "update users set flag = 0 where uid = '"+ uid +"'";

        //执行修改语句
        if(DBServices.modifyBySql(sql) == 1){
            //修改成功，返回true
            return true;
        }else{
            //修改失败，返回false
            return false;
        }
    }
}
