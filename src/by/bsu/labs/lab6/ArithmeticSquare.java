package by.bsu.labs.lab6;

import by.bsu.labs.lab4.exception.ArgumentOutOfRangeException;

/**
 * Created by amareelez on 9.11.16.
 */

class ArithmeticSquare {
    private int[][] array = null;

    ArithmeticSquare(int n) {
        if (n < 0)
            throw new ArgumentOutOfRangeException(
                String.format("N >= 0 expected, but %d found", n));
        array = new int[n][n];
        for (int i = 0; i < n; i++)
            array[i][0] = array[0][i] = 1;
        for (int i = 1; i < n; i++)
            for (int j = 1; j < n; j++)
                array[i][j] = array[i - 1][j] + array[i][j - 1];
    }

    @Override public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArithmeticSquare:\n");
        int n = array.length;
        String sample = "%" + (String.valueOf(array[n - 1][n - 1]).length() + 1) + "d";
        for (int[] anArray : array) {
            for (int anAnArray : anArray)
                stringBuilder.append(String.format(sample, anAnArray));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
