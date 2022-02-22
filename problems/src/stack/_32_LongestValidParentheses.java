package stack;

//https://leetcode.com/problems/longest-valid-parentheses/


public class _32_LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] stack = new int[n];
        int top = -1;
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch == '(') {
                stack[++top] = i;
            } else if (top != -1 && chars[stack[top]] == '(') {
                int left = stack[top];
                int len = i - left + 1;
                if (left != 0) {
                    len += dp[left - 1];
                }
                dp[i] = len;
                maxLen = Math.max(maxLen, dp[i]);
                top--;
            }
        }

        return maxLen;
    }
}
