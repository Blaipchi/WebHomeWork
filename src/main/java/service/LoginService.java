package service;

import dao.UsersDAO;
import pojo.User;
import pojo.valueobject.MessageModel;
import util.StringUtil;

public class LoginService {
    public MessageModel userLogin(String uname, String upwd){
        MessageModel messageModel = new MessageModel();

        //回显数据
        User u = new User();
        u.setUsername(uname);
        u.setPassword(upwd);
        messageModel.setObject(u);

        //1.参数的非空判断
        if(StringUtil.isEmpty(uname)||StringUtil.isEmpty(upwd)){
            // 将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMessage("用户名或密码不能为空");

            return messageModel;
        }
        // 2.调用dao层的查询方法，通过用户名查询用户对象
        SqlSession session = GetSqlSession.createSqlSession();
        UsersDAO usersDAO = session.getMapper(UsersDAO.class);
        User user = usersDAO.queryUserByName(uname);

        //3.判断用户对象是否为空
        if(user==null){
            //将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMessage("用户名不存在");

            return messageModel;
        }

        //4.判断数据库中查询到的用户密码与前台传递过来的密码作比较
        if(!upwd.equals(user.getUserPwd())){
            //如果不相等，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMessage("用户密码错误！");
            return messageModel;
        }
        //登录成功，将用户信息设置到消息模型中
        messageModel.setObject(user);

        return messageModel;
    }
}
