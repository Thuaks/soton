package facilities;

public class Main {
    public static void main(String args[]) {
        Hall h = new Hall("hall one");

        int cap;
        cap = h.getCapacity();

        //h.increaseLevel();

        //cap = h.getUpgradeCost();

        System.out.println(cap);
    }
}
