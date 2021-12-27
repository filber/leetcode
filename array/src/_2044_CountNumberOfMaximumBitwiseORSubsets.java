// TOPICS:
// [Bit Manipulation], [Backtracking], [DFS]

// TIPS:
// dfs(int[] nums, int tempResult, int i)
public class _2044_CountNumberOfMaximumBitwiseORSubsets {
    private int max = 0;
    private int maxCnt = 0;

    public int countMaxOrSubsets(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        dfs(nums, 0, 0);
        return maxCnt;
    }

    public void dfs(int[] nums, int bitwiseOr, int i) {
        if (i == nums.length) {
            if (bitwiseOr > max) {
                maxCnt = 1;
                max = bitwiseOr;
            } else if (bitwiseOr == max) {
                maxCnt++;
            }
            return;
        }

        // include i
        dfs(nums, bitwiseOr | nums[i], i + 1);
        // exclude i
        dfs(nums, bitwiseOr, i + 1);
    }

    public static void main(String[] args) {
        int c1 = new _2044_CountNumberOfMaximumBitwiseORSubsets().countMaxOrSubsets(
                new int[]{2,2,2}
        );
        int c2 = new _2044_CountNumberOfMaximumBitwiseORSubsets().countMaxOrSubsets(
                new int[]{3,1}
        );
        int c3 = new _2044_CountNumberOfMaximumBitwiseORSubsets().countMaxOrSubsets(
                new int[]{3,2,1,5}
        );
    }


}
