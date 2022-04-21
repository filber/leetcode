package dfs;

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

import java.util.*;

public class _698_PartitionToKEqualSumSubsets {

    int k;
    int[] nums;
    int target;
    int n;
    boolean[] used;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        this.k = k;
        n = nums.length;
        used = new boolean[n];

        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        target = sum / k;
        // sort in decreasing order
        // so the sum quickly exceeds target
        this.nums = Arrays.
                stream(nums).
                boxed().
                sorted(Collections.reverseOrder()).
                mapToInt(v -> v).
                toArray();
        return backtracking(0, 0, 0);
    }

    private boolean backtracking(int group, int i, int sum) {
        if (group == k) {
            // finished all groups
            return true;
        } else if (sum > target) {
            // sum exceeds target
            return false;
        } else if (sum == target) {
            return backtracking(group + 1, 0, 0);
        }

        int last = -1; // store the last number used
        for (int j = i; j < n; j++) {
            if (used[j]) continue;
            // skip same numbers
            if (nums[j] == last)
                continue;

            last = nums[j];
            used[j] = true;
            if (backtracking(group, j + 1, sum + nums[j])) {
                return true;
            }
            used[j] = false;
        }

        return false;
    }
}
