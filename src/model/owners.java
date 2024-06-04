package model;

import tools.DataTableView;
import tools.Database;
import tools.Menu;
import tools.MyTool;

public class owners { Database _db;
    public owner[] _owners;
    public int[] _widths;
    final String[] _headers = { "Id", "name", "phone", "email", "numbpets"};
    public String _line;

    public owners(Database db, String filter) {
        this._db = db;
        select(filter);
    }

    private void select(String filter) {
        String[][] data = this._db.select("Owner", filter);
        this._owners = new owner[data.length - 1];
        for (int i = 1; i < data.length; i++) {
            this._owners[i - 1] = new owner(data[i]);
        }
        this._widths = MyTool.initWiths(this._headers);
    }

    public owner get(int id) {
        for (owner owner : this._owners) {
            if (owner.id == id) return owner;
        }
        return null;
    }

    public owner get(String name) {
        for (owner owner : this._owners) {
            if (owner.name.equalsIgnoreCase(name)) 
                return owner;
        }
        return null;
    }

    public boolean exists(String name) {
        for (owner owner : this._owners) {
            if (owner.name.equals(name)) 
                return true;
        }
        return false;
    }

    public String[] tabular() {
        String[] data = new String[this._owners.length];
        for (int i = 0; i < this._owners.length; i++) {
            data[i] = this._owners[i].tabular(this._widths);
        }
        return data;
    }

    public void updateWidths() {
        this._widths = MyTool.initWiths(this._headers);
        for (owner owner : this._owners) {
            if (this._widths[0] < ("" + owner.id).length()) {
                this._widths[0] = ("" + owner.id).length();
            }
            if (this._widths[1] < owner.name.length()) {
                this._widths[1] = owner.name.length();
            }
            if (this._widths[2] < owner.phone.length()) {
                this._widths[2] = owner.phone.length();
            }
            if (this._widths[3] < owner.email.length()) {
                this._widths[3] = owner.email.length();
            }
            if (this._widths[4] < owner.numpets.length()) {
                this._widths[4] = owner.numpets.length();
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
