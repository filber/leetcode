package dfs;

// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
public class _2044_CountNumberOfMaximumBitwiseORSubsets {

    private int maxOr = 0;
    private int maxCnt = 0;

    public int countMaxOrSubsets(int[] nums) {
        dfs(nums, 0, 0);
        return maxCnt;
    }

    private void dfs(int[] nums, int or, int pos) {
        if (pos == nums.length) {
            if (or > maxOr) {
                maxOr = or;
                maxCnt = 1;
            } else if (or == maxOr) {
                maxCnt++;
            }
            return;
        }

        // use nums[pos]
        dfs(nums, or | nums[pos], pos + 1);

        // not use nums[pos]
        dfs(nums, or, pos + 1);
    }

    public static void main(String[] args) {
        // 7
        int c1 = new _2044_CountNumberOfMaximumBitwiseORSubsets().countMaxOrSubsets(
                new int[]{2, 2, 2}
        );
        // 2
        int c2 = new _2044_CountNumberOfMaximumBitwiseORSubsets().countMaxOrSubsets(
                new int[]{3, 1}
        );
        // 6
        int c3 = new _2044_CountNumberOfMaximumBitwiseORSubsets().countMaxOrSubsets(
                new int[]{3, 2, 1, 5}
        );
    }


}
