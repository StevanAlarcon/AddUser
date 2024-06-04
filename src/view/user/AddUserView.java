package view.user;

import model.User;
import model.Users;
import tools.Menu;
import tools.MyTool;

public class AddUserView {

    public static User getData(Users users) {
        MyTool.header("Add User");
        User user = new User();
        user.readuserName();
        if (user.userName == null) return null;
        if (users.exists(user.userName)){
            Menu.showError("User already exists!");
            return null;
        }
        user.readPassword();
        user.readUserType();
        
        return user;
    
    }

}
