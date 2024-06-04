package model;

import tools.Menu;
import tools.MyTool;

public class owner {
    public int id;
    public String name;
    public String phone;
    public String email;
    public String numpets;
    


    public owner() {
    }

    public owner(String[] data) {
        this.id     = Integer.parseInt(data[0]);
        this.name = data[1];
        this.phone   = data[2];
        this.email   = data[3];
        this.numpets   = data[4];
        
    }
    
    
    public void readname() {
        this.name = MyTool.readName();
        if (this.name.length() <= 0) this.name = null;
    }

    public void readphone() {
        this.phone = MyTool.readString("phone","phone");
        if (this.phone.length() <= 0) this.phone = null;
    }

    public void reademail() {
        this.email = MyTool.readString("email","email");
        if (this.email.length() <= 0) this.email = null;
    }


    public void readonumpets() {
        this.numpets = MyTool.readString("numpets","numpets");
        if (this.numpets.length() <= 0) this.numpets = null;
    }


    



    public String details() {
        String s = "";
        s += "Id              : " + this.id + "\n";
        s += "Owner name      : " + this.name + "\n";
        s += "Owner phone     : " + this.phone + "\n";
        s += "Owner email     : " + this.email + "\n";
        s += "Owner numpets   : " + this.numpets + "\n";
       
        return s;
    }

    public String tabular(int[] widths) {
        String s = "";
        s += "|" + Menu.align("" + this.id, widths[0], Menu.RIGHT);
        s += "|" + Menu.align("" + this.name, widths[1], Menu.LEFT);
        s += "|" + Menu.align("" + this.phone, widths[2], Menu.LEFT);
        s += "|" + Menu.align("" + this.email, widths[3], Menu.LEFT);
        s += "|" + Menu.align("" + this.numpets, widths[4], Menu.LEFT);
     
        return s + "|\n";
    }

    public String[] options() {
        String[] options = {
            "Owner name     : " + this.name,
            "Owner phone    : " + this.phone,
            "Owner email    : " + this.email,
            "Owner numpets  : " + this.numpets,
       
        };
        return options;
    }
}
