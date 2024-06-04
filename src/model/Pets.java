package model;

import tools.DataTableView;
import tools.Database;
import tools.Menu;
import tools.MyTool;

public class Pets {
    Database _db;
    public Pet[] _pets;
    public int[] _widths;
    final String[] _headers = {"Id", "Specie", "Race","Color","Age","Pet Name"};
    public String _line;

    public Pets(Database db, String filter) {
        this._db = db;
        select(filter);
    }

    private void select(String filter) {
        String[][] data = this._db.select("pet", filter);
        this._pets = new Pet[data.length - 1];
        for (int i = 1; i < data.length; i++) {
            this._pets[i - 1] = new Pet(data[i]);
        }
        this._widths = MyTool.initWiths(this._headers);
    }

    public Pet get(int id) {
        for (Pet pet : this._pets) {
            if (pet.id == id) return pet;
        }
        return null;
    }

    public Pet get(String name) {
        for (Pet pet : this._pets) {
            if (pet.petName.equalsIgnoreCase(name)) 
                return pet;
        }
        return null;
    }

    public boolean exists(String name) {
        for (Pet pet : this._pets) {
            if (pet.petName.equals(name)) 
                return true;
        }
        return false;
    }

    public String[] tabular() {
        String[] data = new String[this._pets.length];
        for (int i = 0; i < this._pets.length; i++) {
            data[i] = this._pets[i].tabular(this._widths);
        }
        return data;
    }

    public void updateWidths() {
        this._widths = MyTool.initWiths(this._headers);
        for (Pet pet : this._pets) {
            if (this._widths[0] < ("" + pet.id).length()) {
                this._widths[0] = ("" + pet.id).length();
            }
            if (this._widths[1] < pet.specie.length()) {
                this._widths[1] = pet.specie.length();
            }
            if (this._widths[2] < pet.race.length()) {
                this._widths[2] = pet.race.length();
            }
            if (this._widths[3] < pet.color.length()) {
                this._widths[3] = pet.color.length();
            }
            if (this._widths[4] < pet.age.length()) {
                this._widths[4] = pet.age.length();
            }
            if (this._widths[5] < pet.petName.length()) {
                this._widths[5] = pet.petName.length();
            }
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
