package math;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/sequential-digits/
public class _1291_SequentialDigits {

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        int[][] dp = new int[9][9];
        for (int i = 0; i < 9; i++) {
            dp[0][i] = i + 1;
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 9 - i; j++) {
                dp[i][j] = dp[i - 1][j] * 10 + i + j + 1;
            }
        }
        int lowDigits = digits(low);
        int highDigits = digits(high);
        for (int i = lowDigits - 1; i <= highDigits; i++) {
            for (int j = 0; j < 9 - i; j++) {
                if (low <= dp[i][j] && dp[i][j] <= high) {
                    ans.add(dp[i][j]);
                }
            }
        }

        return ans;
    }

    //    Constraints:
//            10 <= low <= high <= 10^9
    public static List<Integer> sequentialDigitsMath(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        int digits = 1;
        int start = low;
        while (start >= 10) {
            start /= 10;
            digits++;
        }

        int val = low;
        while (val <= high) {
            if (digits > 10) {
                break;
            } else if (start + digits > 10) {
                start = 1;
                digits++;
            } else {
                val = 0;
                int tempStart = start;
                for (int i = 0; i < digits; i++) {
                    val = val * 10 + tempStart;
                    tempStart++;
                }
                if (low <= val && val <= high) {
                    ans.add(val);
                }
                start++;
            }
        }

        return ans;
    }

    private static int digits(int val) {
        int digits = 1;
        int start = val;
        while (start >= 10) {
            start /= 10;
            digits++;
        }
        return digits;
    }

    public static void main(String[] args) {
        List<Integer> l1 = sequentialDigits(100, 300);
        List<Integer> l2 = sequentialDigits(1000, 13000);
        List<Integer> l3 = sequentialDigits(1235, 12000);

        List<Integer> l4 = sequentialDigits(10, 1000000000);
    }
}
