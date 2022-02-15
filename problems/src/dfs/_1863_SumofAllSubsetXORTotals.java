package dfs;

// https://leetcode.com/problems/sum-of-all-subset-xor-totals/
public class _1863_SumofAllSubsetXORTotals {

    int sum = 0;
    int[] nums;
    int n;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dfs(0, 0);
        return sum;
    }

    public void dfs(int xor, int i) {
        if (i == n) {
            sum += xor;
            return;
        }

        dfs(xor, i + 1);
        dfs(xor ^ nums[i], i + 1);
    }
}
