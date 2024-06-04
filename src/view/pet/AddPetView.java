package view.pet;

import model.Pet;
import model.Pets;
import tools.Menu;
import tools.MyTool;

public class AddPetView {

    public static Pet getData(Pets pets) {
        MyTool.header("Add Pet");
        Pet pet = new Pet();
        pet.readPetName();
        if (pet.petName == null) return null;
        if (pets.exists(pet.petName)){
            Menu.showError("Pet already exists!");
            return null;
        }
        pet.readSpecie();
        pet.readRace();
        pet.readColor();
        return pet;
    
    }

}
