package by.bsu.labs.lab5.exception;

/**
 * Created by amareelez on 2.11.16.
 */

public class NullCoordinatesException extends Exception {
    public NullCoordinatesException() {
        super("Coordinates are not set");
    }
}
