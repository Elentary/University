package by.bsu.labs.lab10.entity;

import by.bsu.labs.lab10.exception.DataFormatException;

/**
 * Created by amareelez on 5.12.16.
 */

public class Toy implements Comparable<Toy> {
    private String name = null;
    private double price;
    private int lowBorder, highBorder;

    public Toy() {
    }

    public Toy(String s) {
        String[] params = s.split(" ");
        if (params.length != 4)
            throw new DataFormatException(s);
        name = params[0];
        price = Double.parseDouble(params[1]);
        lowBorder = Integer.parseInt(params[2]);
        highBorder = Integer.parseInt(params[3]);
    }

    @Override public int compareTo(Toy toy) {
        return name.compareTo(toy.name);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Toy toy = (Toy) o;

        return Double.compare(toy.price, price) == 0 && lowBorder == toy.lowBorder
            && highBorder == toy.highBorder && (name != null ?
            name.equals(toy.name) :
            toy.name == null);
    }

    @Override public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + lowBorder;
        result = 31 * result + highBorder;
        return result;
    }

    public int getLowBorder() {
        return lowBorder;
    }

    public int getHighBorder() {
        return highBorder;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
