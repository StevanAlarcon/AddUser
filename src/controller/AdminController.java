package controller;

import tools.Database;
import tools.Menu;
import view.AdminView;

public class AdminController {
    Database _db;

    public AdminController(Database _db) {
        this._db = _db;
    }

    public void menu() {
        Menu.clearScreen();
        String[] options = {
            "Users", "Owners", "Pets", "Reports",
            "Change password"
        };
        int choice;
        AdminView av = new AdminView();
        do {
            choice = av.showMenu(options);
            switch (choice) {
                case 1:{ 
                    UserController us = new UserController(_db);
                    us.menu();
                }  break;
                case 2:{ 
                    ownerController ow = new ownerController(_db);
                    ow.menu();
                }  break;
                case 3:{ 
                    PetController dc = new PetController(_db);
                    dc.menu();
                }  break;
                case 4: break;
                case 5: break;
                default: break;
            }
        } while(choice != 0);
    }

}
