package by.bsu.labs.lab5;

import by.bsu.labs.lab5.exception.InvalidCoordinatesNumberException;
import by.bsu.labs.lab5.exception.NullCoordinatesException;

/**
 * Created by amareelez on 7.11.16.
 */

public class CartesianPoint implements Point {
    private double[] coordinates = null;

    public CartesianPoint() {
    }

    public CartesianPoint(double[] _coordinates) throws InvalidCoordinatesNumberException {
        if (_coordinates.length != 2)
            throw new InvalidCoordinatesNumberException(
                String.format("2 coordinates expected, but %d found", _coordinates.length));
        this.coordinates = _coordinates;
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
        coordinates = _coordinates.clone();
    }

    @Override public void shift(Point point) throws NullCoordinatesException {
        if (coordinates == null)
            throw new NullCoordinatesException();
        if (!(point instanceof CartesianPoint))
            throw new IllegalArgumentException(
                String.format("PolarPoint argument expected, but %s found", point.getClass()));
        coordinates[0] += ((CartesianPoint) point).coordinates[0];
        coordinates[1] += ((CartesianPoint) point).coordinates[1];
    }

    @Override public void rotate(double angle) throws NullCoordinatesException {
        if (coordinates == null)
            throw new NullCoordinatesException();
        double[] tempCoordinates = coordinates.clone();
        tempCoordinates[0] = coordinates[0] * Math.cos(angle) - coordinates[1] * Math.sin(angle);
        tempCoordinates[1] = coordinates[0] * Math.sin(angle) - coordinates[1] * Math.cos(angle);
        coordinates = tempCoordinates.clone();
    }
}
