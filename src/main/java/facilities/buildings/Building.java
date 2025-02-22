package facilities.buildings;

public interface Building {
    int getLevel();

    void increaseLevel();

    int getUpgradeCost();

    public int getCapacity();

    int getBaseBuildingCost();

    int getMaxLevel();
}
