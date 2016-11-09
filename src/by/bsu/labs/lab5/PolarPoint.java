package by.bsu.labs.lab5;

import by.bsu.labs.lab4.exception.ArgumentOutOfRangeException;
import by.bsu.labs.lab5.exception.InvalidCoordinatesNumberException;
import by.bsu.labs.lab5.exception.NullCoordinatesException;

import java.util.Arrays;

import static java.lang.Math.*;

/**
 * Created by amareelez on 2.11.16.
 */

public class PolarPoint implements Point {
    private double[] coordinates = null;

    public PolarPoint() {
    }

    public PolarPoint(double[] _coordinates) throws InvalidCoordinatesNumberException {
        if (_coordinates.length != 2)
            throw new InvalidCoordinatesNumberException(
                String.format("2 coordinates expected, but %d found", _coordinates.length));
        this.coordinates = _coordinates;
    }

    @Override public String toString() {
        return "PolarPoint{" + "coordinates=" + Arrays.toString(coordinates) + '}';
    }

    @Override public double[] getCoordinates() throws NullCoordinatesException {
        if (coordinates == null)
            throw new NullCoordinatesException();
        return coordinates;
    }

    @Override public void setCoordinates(double[] _coordinates)
        throws InvalidCoordinatesNumberException {
        if (_coordinates.length != 2)
            throw new InvalidCoordinatesNumberException(
                String.format("2 coordinates expected, but %d found", _coordinates.length));
        if (_coordinates[0] < 0)
            throw new ArgumentOutOfRangeException(
                String.format("Non-negative R expected, but %f found", _coordinates[0]));
        coordinates = _coordinates.clone();
    }

    @Override public void shift(Point point) throws NullCoordinatesException {
        if (coordinates == null)
            throw new NullCoordinatesException();
        if (!(point instanceof PolarPoint))
            throw new IllegalArgumentException(
                String.format("PolarPoint argument expected, but %s found", point.getClass()));
        double[] tempCoordinates =
            {coordinates[0] * cos(coordinates[1]) + ((PolarPoint) point).coordinates[0] * cos(
                ((PolarPoint) point).coordinates[1]),
                coordinates[0] * sin(coordinates[1]) + ((PolarPoint) point).coordinates[0] * sin(
                    ((PolarPoint) point).coordinates[1])};
        coordinates[0] = sqrt(pow(tempCoordinates[0], 2) + pow(tempCoordinates[1], 2));
        coordinates[1] = atan(tempCoordinates[1] / tempCoordinates[0]);
        if (tempCoordinates[0] < 0)
            coordinates[1] += PI;
    }

    @Override public void rotate(double angle) throws NullCoordinatesException {
        if (coordinates == null)
            throw new NullCoordinatesException();
        coordinates[1] += angle;
    }
}
