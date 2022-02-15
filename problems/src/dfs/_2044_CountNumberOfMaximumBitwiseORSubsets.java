package dfs;

// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
public class _2044_CountNumberOfMaximumBitwiseORSubsets {

    int maxOr = 0;
    int maxCnt = 0;
    int[] nums;
    int n;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dfs(0, 0);
        return maxCnt;
    }

    private void dfs(int or, int i) {
        if (i == n) {
            if (or > maxOr) {
                maxOr = or;
                maxCnt = 1;
            } else if (or == maxOr) {
                maxCnt++;
            }
            return;
        }

        dfs(or | nums[i], i + 1);
        dfs(or, i + 1);
    }
}
