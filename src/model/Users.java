package model;

import tools.DataTableView;
import tools.Database;
import tools.Menu;
import tools.MyTool;

public class Users {
    Database _db;
    public User[] _Users;
    public int[] _widths;
    final String[] _headers = {"Id", "userName", "password","userType","salt"};
    public String _line;

    public Users(Database db, String filter) {
        this._db = db;
        select(filter);
    }

    private void select(String filter) {
        String[][] data = this._db.select("user", filter);
        this._Users = new User[data.length - 1];
        for (int i = 1; i < data.length; i++) {
            this._Users[i - 1] = new User(data[i]);
        }
        this._widths = MyTool.initWiths(this._headers);
    }

    public User get(int id) {
        for (User User : this._Users) {
            if (User.id == id) return User;
        }
        return null;
    }

    public User get(String name) {
        for (User User : this._Users) {
            if (User.userName.equalsIgnoreCase(name)) 
                return User;
        }
        return null;
    }

    public boolean exists(String name) {
        for (User User : this._Users) {
            if (User.userName.equals(name)) 
                return true;
        }
        return false;
    }

    public String[] tabular() {
        String[] data = new String[this._Users.length];
        for (int i = 0; i < this._Users.length; i++) {
            data[i] = this._Users[i].tabular(this._widths);
        }
        return data;
    }

    public void updateWidths() {
        this._widths = MyTool.initWiths(this._headers);
        for (User User : this._Users) {
            if (this._widths[0] < ("" + User.id).length()) {
                this._widths[0] = ("" + User.id).length();
            }
            if (this._widths[1] < User.userName.length()) {
                this._widths[1] = User.userName.length();
            }
           // if (this._widths[2] < User.password.length()) {
           //     this._widths[2] = User.password.length();
            //}
            if (this._widths[3] < model.User.userTypes()[User.userType-1].length()) {
                this._widths[3] = model.User.userTypes()[User.userType-1].length();
            }
           //  if (this._widths[4] < User.salt.length()) {
            //     this._widths[4] = User.salt.length();
            // }
        }
    }

    public String header() {
        this._line = DataTableView.getHorizontalLine(this._widths);
        String s = this._line + "\n";
        for (int i = 0; i < this._headers.length; i++) {
            s += "|" + Menu.align(this._headers[i], this._widths[i], Menu.CENTER);
        }
        return s + "|\n" + this._line + "\n";
    }
}
