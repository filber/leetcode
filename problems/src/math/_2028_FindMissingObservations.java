package math;

//https://leetcode.com/problems/find-missing-observations/

public class _2028_FindMissingObservations {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (m + n);
        int obvSum = 0;
        for (int val : rolls) {
            obvSum += val;
        }
        int mSum = totalSum - obvSum;
        if (mSum > 6 * n || mSum < n) {
            return new int[]{};
        }
        int[] rst = new int[n];
        for (int i = 0; i < n; i++) {
            for (int c = 1; c <= 6; c++) {
                if (isValid(n - i, mSum, c)) {
                    mSum -= c;
                    rst[i] = c;
                    break;
                }
            }
        }
        return rst;
    }

    private boolean isValid(int m, int sum, int candidate) {
        sum -= candidate;
        if (sum > 6 * (m - 1) || sum < (m - 1)) {
            return false;
        } else {
            return true;
        }
    }
}
