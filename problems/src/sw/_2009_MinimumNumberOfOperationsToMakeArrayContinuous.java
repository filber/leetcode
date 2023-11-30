package sw;

//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/

import java.util.Arrays;

public class _2009_MinimumNumberOfOperationsToMakeArrayContinuous {

    public int minOperations(int[] nums) {
        int N = nums.length;
        int ans = N;
        Arrays.sort(nums);
        int m = 1;
        // deduplicate
        for (int i = 1; i < N; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m] = nums[i];
                m++;
            }
        }

        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < m && nums[j] - nums[i] + 1 <= N) {
                j++;
            }
            // N - WindowSize
            int operations = N - (j - i);
            if (ans > operations) {
                ans = operations;
            }
        }
        return ans;
    }
}
