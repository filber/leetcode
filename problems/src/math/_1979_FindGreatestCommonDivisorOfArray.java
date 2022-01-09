package math;

//https://leetcode.com/problems/find-greatest-common-divisor-of-array/
public class _1979_FindGreatestCommonDivisorOfArray {
    public static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
//        int gcd = gcdRecursion(max, min);
        int gcd = gcdLoop(max, min);
        return gcd;
    }

    private static int gcdRecursion(int a, int b) {
        if (a < b) {
            return gcdRecursion(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcdRecursion(b, a % b);
    }

    private static int gcdLoop(int a, int b) {
        if (a < b) {
            return gcdLoop(b, a);
        }
        while (b!=0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int g1 = findGCD(new int[]{2, 5, 6, 9, 10});
        int g2 = findGCD(new int[]{7, 5, 6, 8, 3});
        int g3 = findGCD(new int[]{3, 3});
    }

}
