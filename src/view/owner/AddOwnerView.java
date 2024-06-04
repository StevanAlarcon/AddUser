package view.owner;


import model.owner;
import model.owners;
import tools.Menu;
import tools.MyTool;


public class AddOwnerView {

    public static owner getData(owners owners) {
        MyTool.header("Add Owner");
        owner owner = new owner();
        owner.readname();
        if (owner.name == null) return null;
        if (owners.exists(owner.name)){
            Menu.showError("Owner already exists!");
            return null;
        }
    
        owner.readphone();
        owner.reademail();
        owner.readonumpets();
        
        return owner;
    
    }

}

    

