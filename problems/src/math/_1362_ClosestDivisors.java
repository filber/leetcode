package math;

// https://leetcode.com/problems/closest-divisors/
public class _1362_ClosestDivisors {

    //    Constraints:
//            1 <= num <= 10^9
    public int[] closestDivisors(int num) {
        int start = (int) Math.sqrt((double) (num + 2));
        int[] res = new int[2];
        res[0] = 1;
        res[1] = num + 1;
        for (int i = start; i >= 1; i--) {
            if ((num + 1) % i == 0) {
                res[0] = i;
                res[1] = (num + 1) / i;
                break;
            } else if ((num + 2) % i == 0) {
                res[0] = i;
                res[1] = (num + 2) / i;
                break;
            }
        }
        return res;
    }
}
