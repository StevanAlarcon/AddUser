package view.owner;

import model.owner;
import tools.Menu;
import tools.MyTool;

public class DeletOwnerView {

    public static int getid() {
        MyTool.header("Delete Owner");
        return MyTool.readInt("Owner Id", -1);
    }

    public static boolean confirm(owner owner) {
        System.out.println(owner.details());
        if(Menu.getConfirm("Are you sure you want to delete this owner?")){
            return true;
        }
        return false;
    }

}
