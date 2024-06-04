package view.pet;

import model.Pet;
import tools.Menu;
import tools.MyTool;

public class DeletePetView {

    public static int getid() {
        MyTool.header("Delete Pet");
        return MyTool.readInt("Pet Id", -1);
    }

    public static boolean confirm(Pet pet) {
        System.out.println(pet.details());
        if(Menu.getConfirm("Are you sure you want to delete this pet?")){
            return true;
        }
        return false;
    }

}
