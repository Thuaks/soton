import facilities.Facility;
import university.Staff;
import university.University;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class EcsSim {
    University university;
    ArrayList<Staff> staffMarket;
    //ALGORITHM
    public void build() throws Exception {
        // build new buildings
        Facility hall = this.university.build("Hall", "hall1");
        Facility lab = this.university.build("Lab", "lab1");
        Facility Theatre = this.university.build("Theatre", "Theatre1");
    }

    public void upgrade() throws Exception {
        // upgrade buildings
        for(Facility f : this.university.estate.facilities) {
            if(f.getLevel() < f.getMaxLevel()) this.university.upgrade(f);
        }
    }

    public void increaseBudget(){
        this.university.increaseBudget(1000000);
    }

    public void hire(){
        int i = 0;

        //randomly hire new staff from market
        for(Staff staff : this.staffMarket){
            if(i % 5 == 0){
                this.university.humanResource.addStaff(staff);
            }
            i++;
        }
    }

    public void allocate(){
        Iterator<Staff> staffIter = this.university.humanResource.getStaff();

        // allocate staff with students
        while(staffIter.hasNext()){
            staffIter.next().instruct(4);
        }
    }

    public void payMaintenance() throws Exception {
        // pay maintainace of buildings
        float cost = this.university.estate.getMaintenanceCost();
        this.university.deductBudget(cost);
    }

    public void increaseYearsOfTeaching(){
        Iterator<Staff> it = this.university.humanResource.getStaff();
        // increase years of teaching for those under 30 years
        while(it.hasNext()){
            Staff s = it.next();

            if(s.getYearsOfteaching() < 30){
                s.increaseYearsOfTeaching();
            }
        }
    }

    public void deductreputation(){

        // deduct reputation for uninstructed students
        Iterator<Staff> it = this.university.humanResource.getStaff();
        int studentsInstructed = 0;
        int totalStudents = this.university.getNumberOfStudents();
        while(it.hasNext()){
            studentsInstructed += it.next().getNoOfStudentsInstructing();
        }

        int unInstructedStudents = totalStudents - studentsInstructed;

        this.university.deductReputation(unInstructedStudents);
    }

    public void realeaseStaff() {
        Iterator<Staff> it = this.university.humanResource.getStaff();

        // remove staff over 30 years
        while(it.hasNext()){
            Staff s = it.next();
            if(s.getYearsOfteaching() >= 30 ){
                this.university.humanResource.staffSalary.remove(s);
            }

            // remove staff with less stamina;
            if(s.getStamina() < 5){
                this.university.humanResource.staffSalary.remove(s);
            }
        }
    }

    public void replenishStaff() {
        // increase stamina of remaining
        Iterator<Staff> it = this.university.humanResource.getStaff();
        while (it.hasNext()){
            it.next().replenishStamina();
        }
    }
    void simulate() throws Exception {
        this.build();
        this.upgrade();
        this.increaseBudget();
        this.hire();
        this.allocate();
        this.payMaintenance();
        this.deductreputation();
        this.realeaseStaff();
        this.increaseYearsOfTeaching();
        this.replenishStaff();
    }

    void simulate(int years) throws Exception {
        for(int i = 0; i < years; i++){
            this.simulate();
        }
    }

    public static ArrayList<Staff> parseFile(String path) {
        String example = "hello word (20)\nHi bro ui (30)\nvic nor yu io (40)";

        ArrayList<Staff> stff = new ArrayList<>();

        try(
                BufferedReader br = new BufferedReader(new FileReader(path))
                ) {
            String line;

            while((line = br.readLine()) != null){
                String[] parts = line.split("\\(");

                if(parts.length == 2){
                    String name = parts[0].trim();
                    String skill = parts[1].replaceAll("\\)","").trim();

                    stff.add(new Staff(name, Integer.parseInt(skill)));
                    //System.out.println(name +" " + skill);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
        return stff;
    }

    public EcsSim(ArrayList<Staff> staffMkt, int years, int funding) throws Exception {
        this.university = new University(funding);
        this.staffMarket = staffMkt;


        for(int i = 0; i < years; i++){
            this.simulate();
        }

    }

    public static void main(String args[]) throws Exception {
       ArrayList<Staff> s = parseFile(args[0]);
       int years = Integer.parseInt(args[1]);
       int funding = Integer.parseInt(args[2]);

       EcsSim e = new EcsSim(s,years,funding);

       System.out.println("Simulation complete");
    }
}
