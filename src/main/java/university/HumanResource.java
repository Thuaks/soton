package university;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class HumanResource {
    public HashMap<Staff, Float> staffSalary;

    public void addStaff(Staff staff){
        //staff.skill

        Random random = new Random();
        int num = (random.nextInt(105 - 95) + 95)/10;
        float salary = (float) (num * staff.skill) /100;

        this.staffSalary.put(staff,salary);
    }

    public float getTotalSalary(){
        float total = 0;
        for(Float f : staffSalary.values()){
            total += f;
        }

        return total;
    }

    public Iterator<Staff> getStaff(){
        return this.staffSalary.keySet().iterator();
    }

    public HumanResource(){
        this.staffSalary = new HashMap<>();
    }

    public static void main(String args[]){
        HumanResource h = new HumanResource();

        float f = h.getTotalSalary();

        Staff s = new Staff("vic",50);

        h.addStaff(s);

        f = h.getTotalSalary();

        System.out.println(f);
    }
}
