package by.bsu.labs.lab8;

import by.bsu.labs.lab8.Comparators.SortedByFIO;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Created by amareelez on 9.11.16.
 */

public class Paiment implements Comparable, Iterator {
    Comparator<Paiment> comparator = new SortedByFIO();
    private String FIO, currentField = Paiment.class.getDeclaredFields()[0].getName();
    private int year, workingDays, workedDays;
    private double wage, addPercent, taxPercent, totalSum, holdSum;

    public Paiment(String s) {
        StringTokenizer stringTokenizer = new StringTokenizer(s, ",");
        Field[] fields = Paiment.class.getDeclaredFields();
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String temp = stringTokenizer.nextToken();
            temp = temp.substring(temp.indexOf("=") + 1);
            try {
                if (i < 2)
                    fields[i].set(this, temp);
                else if (i >= 2 && i < 5)
                    fields[i].setInt(this, Integer.parseInt(temp));
                else if (i < 10)
                    fields[i].setDouble(this, Double.parseDouble(temp));
                i++;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        comparator = new SortedByFIO();
        currentField = Paiment.class.getDeclaredFields()[0].getName();
    }

    public Paiment(String FIO, int year, int workingDays, int workedDays, double wage,
        double addPercent, double taxPercent) {
        this.FIO = FIO;
        this.year = year;
        this.workingDays = workingDays;
        this.workedDays = workedDays;
        this.wage = wage;
        this.addPercent = addPercent;
        this.taxPercent = taxPercent;
        incomeSum();
        holdSum();
    }

    private void incomeSum() {
        totalSum = wage * workingDays / workedDays * (1 + addPercent);
    }

    private void holdSum() {
        holdSum = totalSum * (1 - taxPercent);
    }

    double resultiveSum() {
        return totalSum - holdSum;
    }

    @Override public String toString() {
        return "Paiment{" + "FIO=" + FIO + ", currentField='" + currentField + '\'' + ", year="
            + year + ", workingDays=" + workingDays + ", workedDays=" + workedDays + ", wage="
            + wage + ", addPercent=" + addPercent + ", taxPercent=" + taxPercent + ", totalSum="
            + totalSum + ", holdSum=" + holdSum + ", comparator=" + comparator + '}';
    }

    @Override public int compareTo(Object o) {
        return comparator.compare(this, (Paiment) o);
    }

    public String getFIO() {
        return FIO;
    }

    public int getYear() {
        return year;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public double getWage() {
        return wage;
    }

    public double getAddPercent() {
        return addPercent;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public double getHoldSum() {
        return holdSum;
    }

    @Override public boolean hasNext() {
        Field[] fields = Paiment.class.getDeclaredFields();
        if (!Objects.equals(fields[fields.length - 1].getName(), currentField)) {
            return true;
        } else {
            currentField = fields[0].getName();
            return false;
        }
    }

    @Override public Object next() {
        Field[] fields = Paiment.class.getDeclaredFields();
        int currentState = 0;
        for (int i = 0; i < fields.length; i++)
            if (Objects.equals(fields[i].getName(), currentField))
                currentState = i;
        try {
            Object temp = fields[currentState].get(this);

            for (int i = 0; i < fields.length; i++)
                if (Objects.equals(fields[i].getName(), currentField))
                    if (i == fields.length - 1) {
                        currentField = fields[0].getName();
                        break;
                    } else {
                        currentField = fields[i + 1].getName();
                        break;
                    }

            return temp;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
