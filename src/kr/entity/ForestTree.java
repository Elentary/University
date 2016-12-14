package kr.entity;

/**
 * Created by amareelez on 14.12.16.
 */

public class ForestTree extends Tree {
    private double amountOfLog;

    public ForestTree() {
    }

    public ForestTree(String name, int age, Type type, double amountOfLog) {
        super(name, age, type);
        this.amountOfLog = amountOfLog;
    }

    public Object[] getFields() {
        return new Object[] {name, age, type, amountOfLog};
    }

    @Override public int compareTo(Tree tree) {
        if (!name.equals(tree.name))
            return new Integer(age).compareTo(tree.age);
        else
            return name.compareTo(tree.name);
    }

    public double getAmountOfLog() {
        return amountOfLog;
    }

    public void setAmountOfLog(double amountOfLog) {
        this.amountOfLog = amountOfLog;
    }
}
