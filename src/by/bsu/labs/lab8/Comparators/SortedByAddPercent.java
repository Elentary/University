package by.bsu.labs.lab8.Comparators;

import by.bsu.labs.lab8.Paiment;

import java.util.Comparator;

/**
 * Created by amareelez on 9.11.16.
 */

public class SortedByAddPercent implements Comparator<Paiment> {
    @Override public int compare(Paiment paiment, Paiment t1) {
        if (paiment.getAddPercent() < t1.getAddPercent())
            return -1;
        else if (paiment.getAddPercent() > t1.getAddPercent())
            return 1;
        else
            return 0;
    }
}
