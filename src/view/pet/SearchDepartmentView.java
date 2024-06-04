package view.pet;

import model.Pet;
import tools.Menu;

public class SearchDepartmentView {

    public static void show(Pet pet) {
        System.out.println(pet.details());
        Menu.anyKey();
    }

}
