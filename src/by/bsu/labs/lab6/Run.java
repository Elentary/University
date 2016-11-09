package by.bsu.labs.lab6;

import by.bsu.labs.lab4.exception.ArgumentOutOfRangeException;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter matrix dimension:");
            int n = scanner.nextInt();
            ArithmeticSquare arithmeticSquare = new ArithmeticSquare(n);
            System.out.println(arithmeticSquare);
        } catch (ArgumentOutOfRangeException e) {
            e.printStackTrace();
        }
    }
}
