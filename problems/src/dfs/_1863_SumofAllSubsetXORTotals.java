package dfs;

// https://leetcode.com/problems/sum-of-all-subset-xor-totals/
public class _1863_SumofAllSubsetXORTotals {

    int sum = 0;
    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return sum;
    }

    private void dfs(int[] nums, int xor, int pos) {
        if (pos == nums.length) {
            sum += xor;
            return;
        }
        // use nums[pos]
        dfs(nums, xor ^ nums[pos], pos + 1);

        // not use nums[pos]
        dfs(nums, xor, pos + 1);
    }


//    Constraints:
//            1 <= nums.length <= 12
//            1 <= nums[i] <= 20
    public static void main(String[] args) {
        int s1 = new _1863_SumofAllSubsetXORTotals().
                subsetXORSum(new int[]{1, 3}); // 6

        int s2 = new _1863_SumofAllSubsetXORTotals().
                subsetXORSum(new int[]{5, 1, 6}); // 28

        int s3 = new _1863_SumofAllSubsetXORTotals()
                .subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}); // 480

        int s4 = new _1863_SumofAllSubsetXORTotals().
                subsetXORSum(new int[]{1}); // 1

    }

}
