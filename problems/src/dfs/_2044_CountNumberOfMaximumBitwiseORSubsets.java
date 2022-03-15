package dfs;

// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
public class _2044_CountNumberOfMaximumBitwiseORSubsets {


    int maxOr = Integer.MIN_VALUE;
    int cnt = 0;
    int[] nums;
    int n;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        dfs(0, 0);
        return cnt;
    }

    private void dfs(int or, int i) {
        if (i == n) {
            if (or > maxOr) {
                maxOr = or;
                cnt = 1;
            } else if (or == maxOr) {
                cnt++;
            }
            return;
        }

        dfs(or | nums[i], i + 1);
        dfs(or, i + 1);
    }
}
