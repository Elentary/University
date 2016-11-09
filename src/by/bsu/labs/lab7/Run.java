package by.bsu.labs.lab7;

import by.bsu.labs.lab4.exception.ArgumentOutOfRangeException;

import java.util.Scanner;

/**
 * Created by amareelez on 9.11.16.
 */

public class Run {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                int s = scanner.nextInt();
                System.out.println(Converter.convert(s));
            }
        } catch (ArgumentOutOfRangeException e) {
            e.printStackTrace();
        }
    }
}
