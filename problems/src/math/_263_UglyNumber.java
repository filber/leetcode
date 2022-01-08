package math;

//https://leetcode.com/problems/ugly-number/
public class _263_UglyNumber {
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        int arr[]={2,3,5};
        for (int prime : arr) {
            while (n%prime==0) {
                n /= prime;
            }
        }
        if (n==1) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        boolean b1 = isUgly(6); // true
        boolean b2 = isUgly(1); // true
        boolean b3 = isUgly(15);// true
        boolean b4 = isUgly(14);// false
    }
}
