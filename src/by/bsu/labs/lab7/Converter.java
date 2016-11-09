package by.bsu.labs.lab7;

import by.bsu.labs.lab4.exception.ArgumentOutOfRangeException;

/**
 * Created by amareelez on 9.11.16.
 */

class Converter {
    static String convert(int n) {
        if (Math.abs(n) > 1000)
            throw new ArgumentOutOfRangeException(
                String.format("Abs(N) <= 1000 expected, but %d found", Math.abs(n)));
        StringBuilder stringBuilder = new StringBuilder();
        if (n == 1000) {
            return "Одна тысяча";
        } else if (n == 0) {
            return "Ноль";
        }
        if (n / 100 > 0)
            stringBuilder.append(convert100(n / 100));
        if (n % 100 > 0)
            if (n % 100 < 10)
                stringBuilder.append(" ").append(convert1(n % 100));
            else if (n % 100 < 20)
                stringBuilder.append(" ").append(specialCase(n % 100));
            else
                stringBuilder.append(" ").append(convert10(n % 100 / 10)).append(" ")
                    .append(convert1(n % 10));
        if (stringBuilder.charAt(stringBuilder.length() - 1) == ' ')
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        if (stringBuilder.charAt(0) == ' ')
            stringBuilder.deleteCharAt(0);
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
        return stringBuilder.toString();
    }

    private static String convert100(int n) {
        switch (n) {
            case 1:
                return "сто";
            case 2:
                return "двести";
            case 3:
                return "триста";
            case 4:
                return "четыреста";
            case 5:
                return "пятьсот";
            case 6:
                return "шестьсот";
            case 7:
                return "семьсот";
            case 8:
                return "восемьсот";
            case 9:
                return "девятьсот";
            default:
                return "";
        }
    }

    private static String convert10(int n) {
        switch (n) {
            case 1:
                return "десять";
            case 2:
                return "двадцать";
            case 3:
                return "тридцать";
            case 4:
                return "сорок";
            case 5:
                return "пятьдесят";
            case 6:
                return "шестьдесят";
            case 7:
                return "семьдесят";
            case 8:
                return "восемьдесят";
            case 9:
                return "девяносто";
            default:
                return "";
        }
    }

    private static String convert1(int n) {
        switch (n) {
            case 1:
                return "один";
            case 2:
                return "два";
            case 3:
                return "три";
            case 4:
                return "четыре";
            case 5:
                return "пять";
            case 6:
                return "шесть";
            case 7:
                return "семь";
            case 8:
                return "восемь";
            case 9:
                return "девять";
            default:
                return "";
        }
    }

    private static String specialCase(int n) {
        switch (n) {
            case 11:
                return "одиннадцать";
            case 12:
                return "двенадцать";
            case 13:
                return "тринадцать";
            case 14:
                return "четырнадцать";
            case 15:
                return "пятнадцать";
            case 16:
                return "шестнадцать";
            case 17:
                return "семнадцать";
            case 18:
                return "восемнадцать";
            case 19:
                return "девятнадцать";
            default:
                return "";
        }
    }
}
