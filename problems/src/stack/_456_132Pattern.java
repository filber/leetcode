package stack;

//https://leetcode.com/problems/132-pattern/


public class _456_132Pattern {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int nK = Integer.MIN_VALUE;
        int[] stack = new int[n];
        int top = -1;
        for (int i = n - 1; i >= 0; i--) {
            int nI = nums[i];
            if (nI < nK) {
                return true;
            }

            while (top > -1 && stack[top] < nI) {
                nK = stack[top--]; // nK be the biggest elements popped from the stack
            }

            // stack stores all potential nJ
            stack[++top] = nI;
        }

        return false;
    }
}
