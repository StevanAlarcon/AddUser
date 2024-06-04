package view.owner;

import model.owner;
import tools.Menu;

public class searchowner {

    public static void show(owner owner) {
        System.out.println(owner.details());
        Menu.anyKey();
    }

}


    
   