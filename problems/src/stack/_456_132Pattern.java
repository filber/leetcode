package stack;

//https://leetcode.com/problems/132-pattern/


public class _456_132Pattern {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;
        int nK = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int nI = nums[i];
            if (nI < nK) {
                return true;
            }
            while (top > -1 && nI > stack[top]) {
                nK = stack[top--];
            }
            stack[++top] = nI;
        }

        return false;
    }
}