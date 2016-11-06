package by.bsu.labs.lab4;

import by.bsu.labs.lab4.exception.ArgumentOutOfRangeException;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 * Created by amareelez on 18.10.16.
 */
class TeylorSeries {
    static double arcTan(double x, double k) {
        if (abs(x) >= 1)
            throw new ArgumentOutOfRangeException("x value is out of range (-1,1)");
        double currValue = x, eps = pow(10, -k), answer = currValue;
        int step = 3;
        while (abs(currValue / step * x * x) >= eps) {
            currValue = -1 * currValue / step * x * x;
            answer += currValue;
            step += 2;
        }
        return answer;
    }
}


