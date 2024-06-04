package view.user;

import model.User;
import model.Users;
import tools.Menu;
import tools.MyTool;

public class UpdateUserView {

    public static int getid() {
        MyTool.header("Update User");
        return MyTool.readInt("User id", -1);
    }

    public static User getData(User user, Users users) {
        int choice;
        do{
            Menu.showMenu("Update " + user.userName, user.options(),2);
            choice = Menu.getOption(user.options());
            switch (choice) {
                case 1:user.readuserName(); break;
                case 2:user.readPassword(); break;
                case 3:user.readUserType();break;
            }
        }while(choice != 0);

        return user;
    }

}
