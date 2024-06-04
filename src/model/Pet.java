package model;

import tools.Menu;
import tools.MyTool;

public class Pet {
    public int id;
    public String specie;
    public String race;
    public String color;
    public String age;
    public String petName;
    public int ownerId;
    

    public Pet() {
    }

    public Pet(String[] data) {
        this.id        = Integer.parseInt(data[0]);
        this.specie    = data[1];
        this.race      = data[2];
        this.color     = data[3];
        this.age       = data[4];
        this.petName   = data[5];
    }
    
    
    public void readSpecie() {
        this.specie = MyTool.readString("Specie","specie");
        if (this.specie.length() <= 0) this.specie = null;
    }

    public void readRace() {
        this.race = MyTool.readString("Race","Race");
        if (this.race.length() <= 0) this.race = null;
    }

    public void readColor() {
        this.color = MyTool.readString("Color","Color");
        if (this.color.length() <= 0) this.color = null;
    }

    public void readAge() {
        this.color = MyTool.readString("Age","Age");
        if (this.color.length() <= 0) this.color = null;
    }


    public void readPetName() {
        this.petName = MyTool.readName();
        if (this.petName.length() <= 0) this.petName = null;
    }

   



    public String details() {
        String s = "";
        s += "Id        : " + this.id + "\n";
        s += "Specie    : " + this.specie + "\n";
        s += "Race      : " + this.race + "\n";
        s += "color     : " + this.color + "\n";
        s += "Pet Name  : " + this.petName + "\n";
        return s;
    }

    public String tabular(int[] widths) {
        String s = "";
        s += "|" + Menu.align("" + this.id, widths[0], Menu.RIGHT);
        s += "|" + Menu.align("" + this.specie, widths[1], Menu.LEFT);
        s += "|" + Menu.align("" + this.race, widths[2], Menu.LEFT);
        s += "|" + Menu.align("" + this.color, widths[3], Menu.LEFT);
        s += "|" + Menu.align("" + this.age, widths[4], Menu.LEFT);
        s += "|" + Menu.align("" + this.petName, widths[5], Menu.LEFT);
        return s + "|\n";
    }

    public String[] options() {
        String[] options = {
            "Pet Specie   : " + this.specie,
            "Pet Race     : " + this.race,
            "Pet Color    : " + this.color,
            "Pet Name     : " + this.petName,
        };
        return options;
    }
}
