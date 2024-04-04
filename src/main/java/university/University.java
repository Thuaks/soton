package university;

import facilities.Facility;
import facilities.buildings.Building;

public class University {
    float budget;
    public Estate estate;

    public HumanResource humanResource;

    int numberOfStudents;

    int reputation;
    public Facility build(String type, String name) throws Exception {
        Facility newfacility = this.estate.addFacility(type,name);

        if(newfacility != null){
            this.reputation += 100;
            this.budget -= (float) newfacility.getBaseBuildingCost();

            if(this.budget < 0) throw  new Exception();
        }

        return newfacility;
    }

    public void upgrade (Building building) throws Exception {
        boolean found = false;
        for(Building b : this.estate.facilities){
            if(b.equals(building)){
                if(b.getLevel() >= b.getMaxLevel()){
                    throw new Exception();
                }

                found = true;
                b.increaseLevel();
                this.budget -= b.getUpgradeCost();
                break;
            }
        }

        if(!found) {
            throw new Exception();
        }
    }

    public float getBudget() {
        return this.budget;
    }

    public void increaseBudget(float newBudget){
        this.budget += newBudget;
    }

    public int getReputation() {
        return this.reputation;
    }

    public void deductBudget(float amount) throws Exception {
        this.budget -= amount;
        if(amount < 0) throw new Exception();
    }

    public int getNumberOfStudents(){
        return this.numberOfStudents;
    }

    public void deductReputation(int num){
        this.reputation -= num;
    }
    public University(int funding){
        this.budget = (float) funding;
        this.estate = new Estate();
        this.reputation = 0;
        this.humanResource = new HumanResource();
        this.numberOfStudents = 1000;
    }
}
