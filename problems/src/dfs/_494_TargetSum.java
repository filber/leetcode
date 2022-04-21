package dfs;

//https://leetcode.com/problems/target-sum/

public class _494_TargetSum {

    int ways = 0;
    int n;
    int[] nums;
    int target;

    public int findTargetSumWaysBacktracking(int[] nums, int target) {
        this.nums = nums;
        n = nums.length;
        this.target = target;
        backtracking(0, 0, 0);
        return ways;
    }

    private void backtracking(int i, int left, int right) {
        if (i == n) {
            ways += left - right == target ? 1 : 0;
            return;
        }
        int w = nums[i];
        backtracking(i + 1, left + w, right);
        backtracking(i + 1, left, right + w);
    }
}
