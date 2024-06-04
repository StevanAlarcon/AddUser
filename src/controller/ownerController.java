package controller;


import model.owner;
import model.owners;
import tools.Database;
import tools.Menu;
import tools.MyTool;
import view.AdminView;
import view.owner.searchowner;
import view.owner.AddOwnerView;
import view.owner.DeletOwnerView;
import view.owner.ShowownerView;
import view.owner.UpdateOwnerVIew;

public class ownerController {
    Database _db;

    public ownerController(Database _db) {
        this._db = _db;
    }

    public void menu() {
        Menu.clearScreen();
        String[] options = {
            "Show all Owner", "Search a Owner", "Add a Owner", 
            "Update a Owner", "Delete a Owner"
        };
        int choice;
        do {
            AdminView.showCow();
            Menu.showMenu("Owner menu", options, 2);
            choice = Menu.getOption(options);
            switch (choice) {
                case 1: showAll(); break;
                case 2: search(); break;
                case 3: add(); break;
                case 4: update();break;
                case 5: delete (); break;
                default: break;
            }
        } while(choice != 0);
    }

    private void showAll() {
        Menu.clearScreen();
        owners owners = new owners(this._db, "");
        ShowownerView.show(owners);
    }

    private void search() {
        Menu.clearScreen();
        String name = MyTool.readName("Owner", "Owner name");
        owners owners = new owners(
            this._db, "name LIKE '%" + name + "%'"
        );
        if (owners._owners.length > 0) {
            searchowner.show(owners._owners[0]);
        }
        else {
            Menu.showError("Owner not found!");
        }
    }

     private void add() {
        owners owners = new owners(_db,"");
        owner owner = AddOwnerView.getData(owners);
        if (owner != null ){
           if (this._db.insert(owner)){
            Menu.showConfirm("Owner added!");
           }
           else{
            Menu.showError("Owner not added!");


               }
        }
    }

    
    private void update() {
        int id = UpdateOwnerVIew.getid();
        if(id >= 0){
            owners owners = new owners(_db, "id =" + id);
            owner owner = owners.get(id);
            if(owner != null){
                owners = new owners(_db,"");
                owner = UpdateOwnerVIew.getData(owner,owners);
                if(owner != null){
                    if(this._db.update(owner.id,owner)){
                        Menu.showConfirm("Owner updated!");
                    }
                    else{
                        Menu.showError("Owner not updated!");
                    }
                }
            }
            
        }
    }
        private void delete() {
        int id = DeletOwnerView.getid();
        if(id >= 0){
            owners owners = new owners(_db, "id =" + id);
            owner owner = owners.get(id);
            if(owner != null){
                if (DeletOwnerView.confirm(owner)){
                    if (this._db.delete(owner.id,"Owner")){
                        Menu.showConfirm("Owner deleted!");
                    }
                }
            }
            else{
                Menu.showError("Owner not found!");
            }
        }
        }
}
