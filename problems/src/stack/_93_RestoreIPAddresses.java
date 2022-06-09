package stack;

//https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddresses {

    List<String> ans = new ArrayList<>();
    char[] chars;
    int n;

    int[] stack;
    int top = -1;

    public List<String> restoreIpAddresses(String s) {
        chars = s.toCharArray();
        n = chars.length;
        stack = new int[n];
        backtracking(0);
        return ans;
    }

    private void backtracking(int i) {
        if (i == n) {
            if (top == 3) {
                StringBuilder sb = new StringBuilder();
                sb.append(stack[0]).append(".");
                sb.append(stack[1]).append(".");
                sb.append(stack[2]).append(".");
                sb.append(stack[3]);
                ans.add(sb.toString());
            }
            return;
        }
        int val = chars[i] - '0';
        if (top != -1 && stack[top] != 0 && stack[top] * 10 + val <= 255) {
            stack[top] = stack[top] * 10 + val;
            backtracking(i + 1);
            stack[top] = (stack[top] - val) / 10;
        }
        stack[++top] = val;
        backtracking(i + 1);
        top--;
    }

}
