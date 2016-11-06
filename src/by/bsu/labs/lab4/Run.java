package by.bsu.labs.lab4;

import by.bsu.labs.lab4.exception.ArgumentOutOfRangeException;

import java.util.Scanner;

/**
 * Created by amareelez on 18.10.16.
 */

public class Run {
    public static void main(String[] args) {
        double x;
        int k;
        try {
            if (args.length != 0) {
                x = Double.parseDouble(args[0]);
                k = Integer.parseInt(args[1]);
            } else {
                Scanner reader = new Scanner(System.in);
                System.out.println("Enter x value from (-1,1): ");
                x = reader.nextDouble();
                System.out.println("Enter precision (k in 10^(-k)): ");
                k = reader.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Can't read or parse number");
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("%.").append(k + 1).append("f\n");
        try {
            System.out.printf("Result from Teylor: " + builder, TeylorSeries.arcTan(x, k));
        } catch (ArgumentOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("Result from Math: " + builder, Math.atan(x));
    }
}
