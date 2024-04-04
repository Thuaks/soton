package facilities;

import facilities.buildings.Building;

public class Hall extends Facility implements Building {

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void increaseLevel() {
        if(this.level <= this.maxLevel){
            this.level++;
        }
    }

    @Override
    public int getUpgradeCost() {
        return this.baseBuildingCost * (this.level + 1);
    }

    @Override
    public int getCapacity() {
        return (int)(this.baseCapacity * Math.pow(2,this.level - 1));
    }

    public Hall(String name) {
        super(name);

        this.baseBuildingCost = 100;
        this.baseCapacity = 6;
        this.maxLevel = 4;
        this.level = 1;
    }
}
