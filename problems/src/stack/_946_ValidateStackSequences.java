package stack;

//https://leetcode.com/problems/validate-stack-sequences/

public class _946_ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int l = 0, r = 0;
        int[] stack = new int[n];
        int top = -1;
        while (l < n) {
            if (top >= 0 && stack[top] == popped[r]) {
                top--;
                r++;
            } else if (pushed[l] == popped[r]) {
                r++;
                l++;
            } else {
                stack[++top] = pushed[l];
                l++;
            }
        }

        while (r < n && stack[top] == popped[r]) {
            top--;
            r++;
        }

        return top == -1;
    }
}
