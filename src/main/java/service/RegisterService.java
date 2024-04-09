package service;

import dao.UsersDAO;
import jakarta.servlet.annotation.WebServlet;
import pojo.User;
import pojo.valueobject.MessageModel;
import util.StringUtil;
@WebServlet("/register")
public class RegisterService {
    public MessageModel registerUser(String username, String password) {
        MessageModel messageModel = new MessageModel();

        // 回显数据
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        messageModel.setObject(user);

        // 1. 参数的非空判断
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            // 将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMessage("用户名或密码不能为空");

            return messageModel;
        }

        // 2. 创建UsersDAO实例，检查用户名是否已存在
        UsersDAO usersDAO = new UsersDAO();
        if (usersDAO.checkIfUsernameExists(username)) {
            // 将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMessage("用户名已存在");

            return messageModel;
        }

        // 3. 调用dao层的注册方法，创建新用户
        try {
            usersDAO.addUser(user);
            // 注册成功，将用户信息设置到消息模型中
            messageModel.setCode(1);
            messageModel.setMessage("注册成功");
        } catch (Exception e) {
            // 注册失败，记录异常信息并返回错误状态
            messageModel.setCode(0);
            messageModel.setMessage("注册失败，系统异常：" + e.getMessage());
        }

        return messageModel;
    }
}
