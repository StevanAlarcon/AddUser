package controller;

import tools.Database;
import tools.Menu;

public class MainController {
    Database _db;

    public MainController(String url) {
        this._db = new Database(url);
    }

    public void login() {
        boolean login = true;   // TODO
        if (login) {
            int userType = 1;
            switch (userType) {
                case 1: {
                    AdminController ac = new AdminController(_db);
                    ac.menu();
                } break;
                case 2: break;  // propietario
                case 3: break;  // invitado
                default: break;
            }
            
        } else {
            Menu.showError("Login failed!");
        }
    }
}
