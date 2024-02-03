package stack;

//https://leetcode.com/problems/subarray-with-elements-greater-than-varying-threshold/description/

public class _2334_SubarrayWithElementsGreaterThanVaryingThreshold {

    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length + 2;
        int[] values = new int[n];
        for (int i = 0; i < nums.length; i++) {
            values[i + 1] = nums[i];
        }
        int[] stack = new int[n];
        int top = 0;
        for (int i = 1; i < n; i++) {
            while (top > 0 && values[stack[top]] >= values[i]) {
                int height = values[stack[top]];
                top--;
                int width = i - stack[top] - 1;
                if (height * width > threshold) {
                    return width;
                }
            }
            stack[++top] = i;
        }
        return -1;
    }
}
