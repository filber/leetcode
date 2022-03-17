package dfs;

import java.util.HashMap;
import java.util.Map;

public class _856_ScoreOfParentheses {


    Map<String, Integer> mem = new HashMap<>();

    public int scoreOfParentheses(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n == 2) {
            return 1;
        } else if (mem.containsKey(s)) {
            return mem.get(s);
        }

        int score = 0;
        int[] idx = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            idx[i] = i;
            char ch = chars[i];
            if (ch == '(') {
                stack[++top] = i;
            } else {
                idx[i] = stack[top--];
            }
        }


        int start = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ')' && idx[i] == start) {
                int end = i;
                if (start + 1 == end) {
                    score += 1;
                } else {
                    int innerScore = scoreOfParentheses(s.substring(start + 1, end));
                    score += 2 * innerScore;
                }
                start = i + 1; // move start
            }
        }

        mem.put(s, score);
        return score;
    }
}
