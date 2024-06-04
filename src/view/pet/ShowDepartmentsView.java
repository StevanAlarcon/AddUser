package view.pet;

import model.Pet;
import model.Pets;
import tools.Menu;
import tools.MyTool;

public class ShowDepartmentsView {

    public static void show(Pets pets) {
        MyTool.header("List of Pets");
        if (pets._pets.length > 0) {
            pets.updateWidths();
            System.out.print(pets.header());
            for (Pet pet : pets._pets) {
                System.out.print(pet.tabular(pets._widths));
            }
            System.out.println(pets._line);
        }
        Menu.anyKey();
    }

}
