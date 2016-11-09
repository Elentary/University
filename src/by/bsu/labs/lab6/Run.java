package by.bsu.labs.lab6;

import by.bsu.labs.lab4.exception.ArgumentOutOfRangeException;

import java.util.Scanner;

/**
 * Created by amareelez on 9.11.16.
 */

public class Run {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            ArithmeticSquare arithmeticSquare = new ArithmeticSquare(n);
            System.out.println(arithmeticSquare);
        } catch (ArgumentOutOfRangeException e) {
            e.printStackTrace();
        }
    }
}
