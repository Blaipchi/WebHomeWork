import dao.UsersDAO;
import pojo.User;

import java.util.List;

public class Test {
    public static void main(String args[]){
        UsersDAO usersDAO = new UsersDAO();
        List<User> lut = usersDAO.selectAllUsers();
        User user = usersDAO.selectUserByUid(1);
        System.out.println(lut.toString());
        System.out.println(user.toString());
    }
}
