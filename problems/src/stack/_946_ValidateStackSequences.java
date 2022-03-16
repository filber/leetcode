package stack;

public class _946_ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int r = 0;
        int n = pushed.length;
        int[] stack = new int[n];
        int top = -1;
        for (int l = 0; l < n; l++) {
            if (top >= 0 && popped[r] == stack[top]) {
                l--;
                top--;
                r++;
            } else if (pushed[l] == popped[r]) {
                r++;
            } else {
                stack[++top] = pushed[l];
            }
        }

        while (r < n && stack[top] == popped[r]) {
            top--;
            r++;
        }

        return top == -1;
    }
}
