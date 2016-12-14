package kr.entity;

/**
 * Created by amareelez on 14.12.16.
 */

public class FruitTree extends Tree {
    private double mass;
    private int storageDays;

    public FruitTree() {
    }

    public FruitTree(String name, int age, Type type, double mass, int storageDays) {
        super(name, age, type);

        this.mass = mass;
        this.storageDays = storageDays;
    }

    public Object[] getFields() {
        return new Object[] {name, age, type, mass, storageDays};
    }

    @Override public int compareTo(Tree tree) {
        if (!name.equals(tree.name))
            return new Integer(age).compareTo(tree.age);
        else
            return name.compareTo(tree.name);
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public int getStorageDays() {
        return storageDays;
    }

    public void setStorageDays(int storageDays) {
        this.storageDays = storageDays;
    }
}
