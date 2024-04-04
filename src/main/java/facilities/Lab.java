package facilities;

import facilities.buildings.Building;

public class Lab extends Facility implements Building {
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

    public Lab(String name) {
        super(name);
        this.baseBuildingCost = 300;
        this.baseCapacity = 5;
        this.maxLevel = 5;
        this.level = 1;
    }
}
