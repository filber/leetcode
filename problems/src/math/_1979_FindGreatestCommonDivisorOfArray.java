package math;

//https://leetcode.com/problems/find-greatest-common-divisor-of-array/
public class _1979_FindGreatestCommonDivisorOfArray {

    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return gcd(min, max);
    }

    public int gcd(int a, int b) {
        if (a > b) {
            return gcd(b, a);
        } else if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
