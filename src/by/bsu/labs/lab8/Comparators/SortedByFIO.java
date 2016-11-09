package by.bsu.labs.lab8.Comparators;

import by.bsu.labs.lab8.Paiment;

import java.util.Comparator;

/**
 * Created by amareelez on 9.11.16.
 */

public class SortedByFIO implements Comparator<Paiment> {

    @Override public int compare(Paiment paiment, Paiment t1) {
        return paiment.getFIO().compareTo(t1.getFIO());
    }
}
