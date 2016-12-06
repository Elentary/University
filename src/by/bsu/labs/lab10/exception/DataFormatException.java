package by.bsu.labs.lab10.exception;

/**
 * Created by amareelez on 5.12.16.
 */

public class DataFormatException extends RuntimeException {
    public DataFormatException(String s) {
        super("Data in string {" + s + "} does not correspond specification");
    }
}
