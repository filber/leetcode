package ps;

//https://leetcode.com/problems/product-of-array-except-self/

public class _238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 1;
        int[] suffix = new int[n + 1];
        suffix[n] = 1;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];

            int j = n - i;
            suffix[j] = suffix[j + 1] * nums[j];
        }

        int[] product = new int[n];
        for (int i = 0; i < n; i++) {
            product[i] = prefix[i] * suffix[i + 1];
        }
        return product;
    }
}
