package view.user;

import model.User;
import model.Users;
import tools.Menu;
import tools.MyTool;

public class ShowUsersView {

    public static void show(Users users) {
        MyTool.header("List of Pets");
        if (users._Users.length > 0) {
            users.updateWidths();
            System.out.print(users.header());
            for (User pet : users._Users) {
                System.out.print(pet.tabular(users._widths));
            }
            System.out.println(users._line);
        }
        Menu.anyKey();
        
    }

}
