package by.bsu.labs.lab5;

import by.bsu.labs.lab5.exception.InvalidCoordinatesNumberException;
import by.bsu.labs.lab5.exception.NullCoordinatesException;

/**
 * Created by amareelez on 2.11.16.
 */

interface Point {

    double[] getCoordinates() throws NullCoordinatesException;

    void setCoordinates(double[] _coordinates) throws InvalidCoordinatesNumberException;

    void shift(Point point) throws NullCoordinatesException;

    void rotate(double angle) throws NullCoordinatesException;
}
