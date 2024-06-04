package model;

import tools.Menu;
import tools.MyTool;

public class User {
    public int id;
    public String userName;
    public String password;
    public String userType;
    public String salt;
    

    public User() {
    }

    public User(String[] data) {
        this.id     = Integer.parseInt(data[0]);
        this.userName = data[1];
        this.password   = data[2];
        this.userType   = data[3];
        this.salt   = data[4];
    }
    
    
    public void readuserName() {
        this.userName = MyTool.readName();
        if (this.userName.length() <= 0) this.userName = null;
    }

    public void readpassword() {
        this.password = MyTool.readName();
        if (this.password.length() <= 0) this.password = null;
    }

    public void readuserType() {
        this.userType = MyTool.readName();
        if (this.userType.length() <= 0) this.userType = null;
    }


    public void readsalt() {
        this.salt = MyTool.readName();
        if (this.salt.length() <= 0) this.salt = null;
    }



    public String details() {
        String s = "";
        s += "Id        : " + this.id + "\n";
        s += "userName  : " + this.userName + "\n";
        s += "password  : " + this.password + "\n";
        s += "userType  : " + this.userType + "\n";
        s += "salt      : " + this.salt + "\n";
        return s;
    }

    public String tabular(int[] widths) {
        String s = "";
        s += "|" + Menu.align("" + this.id, widths[0], Menu.RIGHT);
        s += "|" + Menu.align("" + this.userName, widths[1], Menu.LEFT);
        s += "|" + Menu.align("" + "***", widths[2], Menu.LEFT);
        s += "|" + Menu.align("" + this.userType, widths[3], Menu.LEFT);
        s += "|" + Menu.align("" + "***", widths[4], Menu.LEFT);
        return s + "|\n";
    }

    public String[] options() {
        String[] options = {
            "User userName   : " + this.userName,
            "User password     : " + this.password,
            "User userType   : " + this.userType,
            "User salt     : " + this.salt,
            
        };
        return options;
    }
}
