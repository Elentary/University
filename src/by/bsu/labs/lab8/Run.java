package by.bsu.labs.lab8;

import by.bsu.labs.lab8.Comparators.SortedByYear;

import java.util.Arrays;

/**
 * Created by amareelez on 9.11.16.
 */

public class Run {
    public static void main(String[] args) {
        Paiment[] paiments = {new Paiment("Ivanov Ivan Ivanovich", 2004, 23, 21, 314.3, 0.13, 0.2),
            new Paiment("Petrov Petr Petrovich", 2006, 30, 30, 215, 0, 0.05),
            new Paiment("Sidorov Sidr Sidorovich", 1998, 31, 14, 166.7, 0.3, 0.01),
            new Paiment("Abrikosov Abrikos Abrikosovich", 2007, 18, 17, 30.42, 0.1, 0),};
        Paiment temp = new Paiment(paiments[0].toString());
        System.out.println(temp + "\nResultive sum: " + temp.resultiveSum());
        System.out.println();

        while (temp.hasNext())
            System.out.println(temp.next());
        System.out.println();

        Arrays.sort(paiments);
        for (Paiment paiment : paiments) {
            System.out.println(paiment);
        }
        System.out.println();
        for (Paiment paiment : paiments)
            paiment.comparator = new SortedByYear();
        Arrays.sort(paiments);
        for (Paiment paiment : paiments) {
            System.out.println(paiment);
        }
    }
}
