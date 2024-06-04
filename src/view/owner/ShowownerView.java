package view.owner;

import model.owner;
import model.owners;
import tools.Menu;
import tools.MyTool;

public class ShowownerView {

    public static void show(owners owners) {
        MyTool.header("List of Owners");
        if (owners._owners.length > 0) {
            owners.updateWidths();
            System.out.print(owners.header());
            for (owner owner : owners._owners) {
                System.out.print(owner.tabular(owners._widths));
            }
            System.out.println(owners._line);
        }
        Menu.anyKey();
    }

}
