package controller;

import model.Pet;
import model.Pets;
import tools.Database;
import tools.Menu;
import tools.MyTool;
import view.AdminView;
import view.pet.AddPetView;
import view.pet.DeletePetView;
import view.pet.SearchPetView;
import view.pet.ShowPetsView;
import view.pet.UpdatePetView;

public class PetController {
    Database _db;

    public PetController(Database _db) {
        this._db = _db;
    }

    public void menu() {
        Menu.clearScreen();
        String[] options = {
            "Show all pets", "Search a pet", "Add a pet", 
            "Update a pet", "Delete a pet"
        };
        int choice;
        do {
            AdminView.showCow();
            Menu.showMenu("Pets menu", options, 2);
            choice = Menu.getOption(options);
            switch (choice) {
                case 1: showAll(); break;
                case 2: search(); break;
                case 3: add(); break;
                case 4: update();break;
                case 5: delete(); break;
                default: break;
            }
        } while(choice != 0);
    }


   

    private void showAll() {
        Pets pets = new Pets(this._db, "");
        ShowPetsView.show(pets);
    }

    private void search() {
        Menu.clearScreen();
        String name = MyTool.readName("pet", "petName");
        Pets pets = new Pets(
            this._db, "petName LIKE '%" + name + "%'"
        );
        if (pets._pets.length > 0) {
            SearchPetView.show(pets._pets[0]);
        }
        else {
            Menu.showError("Pets not found!");
        }
    }

    private void add() {
        Pets pets = new Pets(_db,"");
        Pet pet = AddPetView.getData(pets);
        if (pet != null ){
           if (this._db.insert(pet)){
            Menu.showConfirm("Pet added!");
           }
           else{
            Menu.showError("Pet not added!");
           }
        }
    }

    
    private void update() {
        int id = UpdatePetView.getid();
        if(id >= 0){
            Pets pets = new Pets(_db, "id =" + id);
            Pet pet = pets.get(id);
            if(pet != null){
                pets = new Pets(_db,"");
                pet = UpdatePetView.getData(pet,pets);
                if(pet != null){
                    if(this._db.update(pet.id,pet)){
                        Menu.showConfirm("Pet updated!");
                    }
                    else{
                        Menu.showError("Pet not updated!");
                    }
                }
            }
            else{
                Menu.showError("Pet not found!");
            }
        }
    }

    private void delete() {
        int id = DeletePetView.getid();
        if(id >= 0){
            Pets pets = new Pets(_db, "id =" + id);
            Pet pet = pets.get(id);
            if(pet != null){
                if (DeletePetView.confirm(pet)){
                    if (this._db.delete(pet.id,"pet")){
                        Menu.showConfirm("Pet deleted!");
                    }
                }
            }
            else{
                Menu.showError("Pet not found!");
            }
        }
    }
}
