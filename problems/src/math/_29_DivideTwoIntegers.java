package math;

//https://leetcode.com/problems/divide-two-integers/

public class _29_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            // Overflow
            return Integer.MAX_VALUE;
        }
        return dividend / divisor;
    }
}
