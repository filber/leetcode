package bfs;

//https://leetcode.com/problems/remove-invalid-parentheses/

import java.util.*;

public class _301_RemoveInvalidParentheses {

    // Constraints:
    //    1 <= s.length <= 25
    //    s consists of lowercase English letters and parentheses '(' and ')'.
    //    There will be at most 20 parentheses in s.
    public static List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        remove(s, '(', ')', 0, 0, list);
        return list;
    }

    public static void remove(String s, char startBracket, char endBracket, int m, int n, List<String> list) {
        char[] chars = s.toCharArray();
        int stack = 0;
        for (int i = m; i < chars.length; i++) {
            if (chars[i] == startBracket) stack++;
            if (chars[i] == endBracket) stack--;

            if (stack == -1) {
                // endBrackets are just ONE more than startBrackets
                // need to delete just ONE endBracket in [n,i]
                for (int j = n; j <= i; j++) {
                    // ignore adjacent endBracket
                    if (chars[j] == endBracket && (j == n || chars[j - 1] != endBracket)) {
                        // remove j
                        String s1 = s.substring(0, j) + s.substring(j + 1);
                        // SE = EB for [0,i], for next recursion, m = i
                        // EB for [0,j] have been deleted at least once, for next recursion, n = j
                        remove(s1, startBracket, endBracket, i, j, list);
                    }
                }
                // no need to continue, subsequent chars have been taken care of
                return;
            }
        }

        s = new StringBuilder(s).reverse().toString();
        if (startBracket == '(') {
            // SE>= EB for all substrings, no need to delete any endBrackets
            // reverse and try to delete startBrackets
            // m,n starts from 0 again
            remove(s, endBracket, startBracket, 0, 0, list);
        } else {
            // both redundant startBrackets and endBrackets have been deleted!
            // s already reversed back
            list.add(s);
        }
    }

    // Breadth First Search
    public List<String> removeInvalidParenthesesBFS(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        Set<String> reduceSet = new HashSet<>();
        queue.add(s);
        reduceSet.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String ss = queue.poll();
            if (isValid(ss)) {
                found = true;
                ans.add(ss);
            } else if (!found) {
                for (int i = 0; i < ss.length(); i++) {
                    if (ss.charAt(i) == '(' || ss.charAt(i) == ')') {
                        String candidate = ss.substring(0, i) + ss.substring(i + 1);
                        if (reduceSet.add(candidate)) {
                            queue.add(candidate);
                        }
                    }
                }
            }
        }

        return ans;
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int top = -1;
        for (char ch : chars) {
            if (ch == '(') {
                top++;
            } else if (ch == ')') {
                if (top == -1) {
                    return false;
                }
                top--;
            }
            // ignore letters
        }
        return top == -1;
    }
}
