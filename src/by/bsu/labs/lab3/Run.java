package by.bsu.labs.lab3;

/**
 * Created by amareelez on 12.10.16 at 22.23.
 */
public class Run {
    public static void main(String[] args) {
        if (args.length > 0)
            System.out.printf("Hello, %s!\n", args[0]);
        else
            System.out.println("Hello world!");
    }
}
