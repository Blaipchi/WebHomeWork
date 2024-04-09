
package service;

import dao.UsersDAO;
import jakarta.servlet.annotation.WebServlet;
import pojo.User;
import pojo.valueobject.MessageModel;
import util.StringUtil;
@WebServlet("/login")
public class LoginService {
    public MessageModel userLogin(String loginName, String loginPassword){
        MessageModel messageModel = new MessageModel();

        //回显数据
        User u = new User();
        u.setUsername(loginName);
        u.setPassword(loginPassword);
        messageModel.setObject(u);

        //1.参数的非空判断
        if(StringUtil.isEmpty(loginName)||StringUtil.isEmpty(loginPassword)){
            // 将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMessage("用户名或密码不能为空");

            return messageModel;
        }

        // 2. 调用dao层的验证登录方法
        UsersDAO usersDAO = new UsersDAO();
        boolean loginSuccess = usersDAO.checkLogin(loginName, loginPassword);

        if (!loginSuccess) {
            // 登录失败，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMessage("用户名或密码错误");
            return messageModel;
        }

        // 登录成功，将用户信息设置到消息模型中
        messageModel.setObject(u);

        return messageModel;
    }
}