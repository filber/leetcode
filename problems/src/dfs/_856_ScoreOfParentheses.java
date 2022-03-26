package dfs;

//https://leetcode.com/problems/score-of-parentheses/

import java.util.HashMap;
import java.util.Map;

public class _856_ScoreOfParentheses {


    Map<String, Integer> mem = new HashMap<>();

    public int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        } else if (mem.containsKey(s)) {
            return mem.get(s);
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] stack = new int[n];
        int top = -1;
        int score = 0;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch == '(') {
                stack[++top] = i;
            } else if (top == 0) {
                int preIdx = stack[top--];
                if (i - preIdx == 1) {
                    score += 1;
                } else {
                    score += 2 * scoreOfParentheses(s.substring(preIdx + 1, i));
                }
            } else {
                top--;
            }
        }

        mem.put(s, score);
        return score;
    }
}
