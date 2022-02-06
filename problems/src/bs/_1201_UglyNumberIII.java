package bs;

// https://leetcode.com/problems/ugly-number-iii/
// An ugly number is a positive integer that is divisible by a, b, or c.
public class _1201_UglyNumberIII {

    public static int nthUglyNumber(int n, int a, int b, int c) {
        long a_b = lcm(a, b), a_c = lcm(a, c), b_c = lcm(b, c);
        long a_b_c = lcm(a_b, a_c);
        long l = 0, r = Integer.MAX_VALUE;
        long index = 0l;
        while (l < r) {
            long mid = (l + r) / 2;
            index = mid / a + mid / b + mid / c - mid / a_b - mid / a_c - mid / b_c + mid / a_b_c;
            if (index >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private static long lcm(long a,long b) {
        long gcd = gcdLoop(a,b);
        return a*b/gcd;
    }

    private static long gcdLoop(long a, long b) {
        if (a < b) {
            return gcdLoop(b, a);
        }
        while (b!=0) {
            long c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        // 2, 3, 4, 5, 6, 8, 9, 10...
        int n1 = nthUglyNumber(6, 2, 3, 5);//8
        int n2 = nthUglyNumber(9, 2, 3, 5);//12

        // 2, 3, 4, 6, 8, 9, 10, 12
        int n5 = nthUglyNumber(4, 2, 3, 4);//6
        int n6 = nthUglyNumber(8, 2, 3, 4);//12

        // 2, 4, 6, 8, 10, 11, 12, 13
        int n8 = nthUglyNumber(5, 2, 11, 13); // 10


        int n9 = nthUglyNumber(1000000000, 2, 217983653, 336916467); // 1999999984
    }
}
