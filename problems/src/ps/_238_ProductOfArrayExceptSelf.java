package ps;

//https://leetcode.com/problems/product-of-array-except-self/

public class _238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];

        prefix[0] = 1;
        for (int i = 1; i <= n && nums[i - 1] != 0; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n] = 1;
        for (int i = n - 1; i >= 0 && nums[i] != 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i + 1];
        }
        return ans;
    }
}
