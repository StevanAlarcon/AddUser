package view.pet;

import model.Pet;
import model.Pets;
import tools.Menu;
import tools.MyTool;

public class UpdatePetView {

    public static int getid() {
        MyTool.header("Update Pet");
        return MyTool.readInt("pet id", -1);
    }

    public static Pet getData(Pet pet, Pets pets) {
        int choice;
        do{
            Menu.showMenu("Update " + pet.petName, pet.options(),2);
            choice = Menu.getOption(pet.options());
            switch (choice) {
                case 1:pet.readSpecie(); break;
                case 2:pet.readRace(); break;
                case 3:pet.readColor();break;
                case 4:pet.readPetName();break;
            }
        }while(choice != 0);

        return pet;
    }

}
