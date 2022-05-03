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
        int total = Arrays.stream(nums).sum();
        if (total % k != 0) {
            return false;
        }
        target = total / k;
        n = nums.length;
        Arrays.sort(nums);
        this.nums = nums;
        used = new boolean[n];
        this.k = k;

        return dfs(0, n - 1, 0);
    }

    private boolean dfs(int group, int i, int sum) {
        if (group == k) {
            return true;
        } else if (sum == target) {
            return dfs(group + 1, n - 1, 0);
        } else if (sum > target) {
            return false;
        }
        int last = -1;
        for (int j = i; j >= 0; j--) {
            if (used[j] || nums[j] == last) {
                continue;
            }
            used[j] = true;
            last = nums[j];
            if (dfs(group, j - 1, nums[j] + sum)) {
                return true;
            } else {
                used[j] = false;
            }
        }
        return false;
    }
}
