package facilities;

import facilities.buildings.Building;

public class Facility implements Building {
    String name;
    int level;
    int maxLevel;
    int baseCapacity;
    int baseBuildingCost;

    public float getMaintenanceCost() {
        return (float)(this.baseCapacity * 0.1);
    }
    public Facility (String name) {
        this.name = name;
    }

    public String getName() {
        return  this.name;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void increaseLevel() {

    }

    @Override
    public int getUpgradeCost() {
        return 0;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getBaseBuildingCost() {
        return this.baseBuildingCost;
    }
    @Override
    public int getMaxLevel(){
        return this.maxLevel;
    }
}
