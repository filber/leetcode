package math;

//https://leetcode.com/problems/mirror-reflection/

public class _858_MirrorReflection {

    public int mirrorReflection(int p, int q) {
        if (q == 0) {
            return 0;
        }
        int lcm = lcm(p, q);
        int n = lcm / q;
        int m = lcm / p;
        if (n % 2 == 0) {
            return 2;
        } else if (m % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int lcm(int x, int y) {
        int gcd = gcd(x, y);
        return x * y / gcd;
    }

    private int gcd(int x, int y) {
        if (x < y) {
            return gcd(y, x);
        } else if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x % y);
        }
    }
}
