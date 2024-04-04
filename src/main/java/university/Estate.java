package university;

import facilities.Facility;
import facilities.Hall;
import facilities.Lab;
import facilities.Theatre;
import facilities.buildings.Building;

import java.util.ArrayList;

public class Estate {
    public ArrayList<Facility> facilities;

    public Facility[] getFacilities(){
        return this.facilities.toArray(new Facility[this.facilities.size()]);
    }

    public Facility addFacility(String type, String name){
        Facility h = null;
        if(type.compareTo("Hall") == 0){
            h = new Hall(name);

        }else if(type.compareTo("Lab") == 0){
            h = new Lab(name);
        }else if (type.compareTo("Theatre") == 0){
            h = new Theatre(name);
        }

        if(h != null){
            this.facilities.add(h);
        }

        return h;
    }

    public float getMaintenanceCost(){
        float total = 0;
        for(Facility f : this.facilities) {
            total += f.getMaintenanceCost();
        }

        return  total;
    }

    public int getNumberOfStudents(){
        int total = 0;

        for(Facility fclty : this.facilities){
            total += fclty.getCapacity();
        }

        return total;
    }
    public Estate() {
        this.facilities = new ArrayList<>();
    }

    public static void main(String args[]) {
        Estate e = new Estate();
        e.addFacility("Lab", "lab1");
        e.addFacility("Hall", "hall1");

        Facility[] fs = e.getFacilities();

        System.out.println(e.getMaintenanceCost());
    }
}
