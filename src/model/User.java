package model;

import tools.Menu;
import tools.MyTool;
import tools.SecretKey;

public class User {
    public int id;
    public String userName;
    public String password;
    public int userType;
    public String salt;
    

    public User() {
    }

    public User(String[] data) {
        this.id     = Integer.parseInt(data[0]);
        this.userName = data[1];
        this.password   = data[2];
        this.userType   = Integer.parseInt(data[3]);
        this.salt   = data[4];
    }
    
    
    public void readuserName() {
        this.userName = MyTool.readName();
        if (this.userName.length() <= 0) this.userName = null;
    }

    public void readPassword(){
        this.password = MyTool.readPassword();
        
    }
    public void readUserType(){
        do{
            Menu.showMenu("User Types", userTypes(), 2);
            this.userType = Menu.getOption(userTypes());
            if (this.userType >= 1 && this.userType <= 3) break;
            
        }while(true);
    }

    public static final String[] userTypes(){
        String[] s = {"Administrator","Owner","Guest"};
        return s;
    }

    public void encrypt(){
        this.salt = SecretKey.getSaltvalue(30);
        this.password = SecretKey.generateSecurePassword(this.password, this.salt);
    }

    public boolean checkPassword(String passwordToCheck){
        return SecretKey.verifyUserPassword(passwordToCheck, this.password, this.salt);

    }


    public String details() {
        String s = "";
        s += "Id        : " + this.id + "\n";
        s += "userName  : " + this.userName + "\n";
        s += "userType  : " + userTypes()[this.userType-1] + "\n";
        
        return s;
    }

    public String tabular(int[] widths) {
        String s = "";
        s += "|" + Menu.align("" + this.id, widths[0], Menu.RIGHT);
        s += "|" + Menu.align("" + this.userName, widths[1], Menu.LEFT);
        s += "|" + Menu.align("" + "***", widths[2], Menu.LEFT);
        s += "|" + Menu.align("" + userTypes()[this.userType-1], widths[3], Menu.LEFT);
        s += "|" + Menu.align("" + "***", widths[4], Menu.LEFT);
        return s + "|\n";
    }

    public String[] options() {
        String[] options = {
            "User Name   : " + this.userName,
            "User userType   : " + userTypes()[this.userType-1],
            
        };
        return options;
    }
}
