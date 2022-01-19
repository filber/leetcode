package math;

// https://leetcode.com/problems/closest-divisors/
public class _1362_ClosestDivisors {

    public static int[] closestDivisors(int num) {
        int val = (int) Math.sqrt((double) num + 2);
        while (val >= 1) {
            if ((num + 1) % val == 0) {
                // found
                return new int[]{val, (num + 1) / val};
            } else if ((num + 2) % val == 0) {
                // found
                return new int[]{val, (num + 2) / val};
            } else {
                val--;
            }
        }
        return new int[]{1, num + 1};
    }

    public static int[] closestDivisorsGreedy(int num) {
        int l = (int) Math.sqrt(num + 2), r = (int) Math.sqrt(num + 2);
        while (l >= 1 && r <= num + 1) {
            if (l * r == num + 1 || l * r == num + 2) {
                return new int[]{l, r};
            } else if (l * r < num + 1) {
                r++;
            } else {
                // l * r > num + 2
                l--;
            }
        }

        return new int[]{1, num + 1};
    }

    public static void main(String[] args) {
        // [3,3]
        int[] c1 = closestDivisors(8);
        // [5,25]
        int[] c2 = closestDivisors(123);

        int[] c3 = closestDivisors(999);
        // [1,2]
        int[] c4 = closestDivisors(1);
        // [2,2]
        int[] c5 = closestDivisors(2);
    }


}
