package by.bsu.labs.lab5;

import by.bsu.labs.lab5.exception.InvalidCoordinatesNumberException;
import by.bsu.labs.lab5.exception.NullCoordinatesException;

import java.util.Arrays;

/**
 * Created by amareelez on 2.11.16.
 */

public class Run {
    public static void main(String[] args) {
        try {
            PolarPoint point1 = new PolarPoint();
            point1.setCoordinates(new double[] {2, Math.PI});
            System.out.println(point1);
            point1.rotate(Math.PI / 4);
            System.out.println(point1);
            point1.shift(new PolarPoint(new double[] {1., Math.PI}));
            System.out.println(Arrays.toString(point1.getCoordinates()));
        } catch (InvalidCoordinatesNumberException | NullCoordinatesException e) {
            e.printStackTrace();
        }
        try {
            CartesianPoint point2 = new CartesianPoint(new double[] {3, 0});
            System.out.println(point2);
            point2.shift(new CartesianPoint(new double[] {1, 1}));
            System.out.println(point2);
            point2.rotate(Math.PI / 4);
            System.out.println(point2);
            point2.setCoordinates(new double[] {0, 0});
            System.out.println(point2);
        } catch (InvalidCoordinatesNumberException | NullCoordinatesException e) {
            e.printStackTrace();
        }
    }
}
