package by.bsu.labs.lab7;

import by.bsu.labs.lab4.exception.ArgumentOutOfRangeException;

import java.util.Scanner;

/**
 * Created by amareelez on 9.11.16.
 */

public class Run {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter string (empty string is ignored) or End to finish:");
                String temp = scanner.nextLine();
                if (temp.equals("End"))
                    break;
                else
                    System.out.println(Converter.convert(Integer.parseInt(temp)));
            }
        } catch (ArgumentOutOfRangeException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Empty string detected");
        }
    }
}
