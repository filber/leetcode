package stack;

//https://leetcode.com/problems/longest-valid-parentheses/

import java.util.Stack;

public class _32_LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int n = s.length();
        // DPi : length of longest valid substring ending with i
        // Invalid substring : DPi = 0;
        // s[i] = '(', DPi = 0
        int[] dp = new int[n + 1];

        // stores idx
        int[] stack = new int[n];
        int top = -1;
        char[] chars = s.toCharArray();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                // DPi = 0;
                // push to stack
                stack[++top] = i;
            } else if (top != -1 && chars[stack[top]] == '(') {
                // chars[i] == ')'
                // Valid substring
                int idx = stack[top--];
                int len = i - idx + 1;
                // add previous valid substring
                len += dp[idx];
                dp[i + 1] = len;
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // 2
        int l1 = longestValidParentheses("(()");
        // 4
        int l2 = longestValidParentheses(")()())");
        // 0
        int l3 = longestValidParentheses("");
        // 12
        int l4 = longestValidParentheses("(()())()(())");
        // 8
        int l5 = longestValidParentheses("(()())()((");
        // 8
        int l6 = longestValidParentheses("(()())()))");
        // 8
        int l7 = longestValidParentheses(")(()())()))");
    }
}
