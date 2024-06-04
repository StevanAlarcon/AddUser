package view.owner;

import model.owner;
import model.owners;
import tools.Menu;
import tools.MyTool;

public class UpdateOwnerVIew {
    

    public static int getid() {
        MyTool.header("Update owner");
        return MyTool.readInt("owner id", -1);
    }

    public static owner getData(owner owner, owners owners) {
        int choice;
        do{
            Menu.showMenu("Update " + owner.name, owner.options(),2);
            choice = Menu.getOption(owner.options());
            switch (choice) {
                case 1:owner.readname(); break;
                case 2:owner.readphone(); break;
                case 3:owner.reademail();break;
                case 4:owner.readonumpets();break;
               
            }
        }while(choice != 0);

        return owner;
    }

}


    

