package stack;

//https://leetcode.com/problems/maximum-subarray-min-product/

public class _1856_MaximumSubarrayMinProduct {

    public int maxSumMinProduct(int[] nums) {
        long mod = (long) (1e9 + 7);
        int[] arr = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        long[] ps = new long[arr.length];
        for (int i = 1; i < ps.length; i++) {
            ps[i] = ps[i - 1] + arr[i];
        }
        int[] stack = new int[arr.length];
        int top = -1;
        long result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            while (top >= 0 && arr[stack[top]] > arr[i]) {
                int peek = stack[top--];
                long value = arr[peek];
                int leftIdx = stack[top];
                int rightIdx = i - 1;
                long sum = ps[rightIdx] - ps[leftIdx];
                long product = sum * value;
                result = Math.max(result, product);
            }
            stack[++top] = i;
        }

        return (int) (result%mod);
    }
}
