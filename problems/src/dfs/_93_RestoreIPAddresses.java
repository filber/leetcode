package dfs;

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
        if (n < 4) {
            return List.of();
        }
        stack = new int[4];

        backtracking(0);
        return ans;
    }

    private void backtracking(int i) {
        if (top > 3) {
            return;
        } else if (i == n) {
            if (top == 3) {
                List<String> list = new ArrayList<>();
                for (int j = 0; j <= top; j++) {
                    list.add(String.valueOf(stack[j]));
                }
                ans.add(String.join(".", list));
            }
            return;
        }

        int digit = chars[i] - '0';
        if (top < 3) {
            // add a new segment
            stack[++top] = digit;
            backtracking(i + 1);
            top--;
        }

        // append to previous segment
        if (top > -1 && stack[top] > 0 && (stack[top] * 10 + digit <= 255)) {
            stack[top] = stack[top] * 10 + digit;
            backtracking(i + 1);
            stack[top] -= digit;
            stack[top] /= 10;
        }
    }
}
