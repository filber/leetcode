package dfs;

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
            remove(s, endBracket,startBracket, 0, 0, list);
        } else {
            // both redundant startBrackets and endBrackets have been deleted!
            // s already reversed back
            list.add(s);
        }
    }

    // Breadth First Search
    public static List<String> removeInvalidParenthesesBFS(String s) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(s);
        Set<String> ansSet = new HashSet<>();
        Set<String> reduceSet = new HashSet<>();
        boolean found = false;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    // found the first valid substring!
                    // no need to traverse next level
                    // still need to consume remaining str in queue
                    found = true;
                    ansSet.add(str);
                } else if (!found) {
                    // not found, still need to search next level
                    for (int j = 0; j < str.length(); j++) {
                        if (str.charAt(j) == '(' || str.charAt(j) == ')') {
                            // Remove j
                            String cand = str.substring(0, j) + str.substring(j + 1);
                            // if candidate not in reduceSet, add it to the queue for next BFS
                            // Avoiding too many duplicates being added to queue
                            if (reduceSet.add(cand)) {
                                queue.add(cand);
                            }
                        }
                    }
                }
            }

        }

        List<String> ans = new ArrayList<>(ansSet);
        if (ans.isEmpty()) {
            ans.add("");
        }
        return ans;
    }

    public static List<String> removeInvalidParenthesesDFS(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        // 1. Calculate len of valid substrings
        int[] stack = new int[n];
        int top = -1;
        // DPi: len of valid substring ending with i
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            // Push '(', pop ')' for len
            // For letters, just change DP, don't modify Stack
            char ch = s.charAt(i);
            if (ch == '(') {
                // DPi=0;
                stack[++top] = i;
            } else if (ch == ')') {
                if (top != -1 && s.charAt(stack[top]) == '(') {
                    // Valid Substring
                    int start = stack[top--];
                    int len = i - start + 1;
                    if (start > 0) {
                        len += dp[start - 1];
                    }
                    dp[i] = len;
                }
            } else {
                if (i > 0) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
            }
        }
        // s is valid, no need to delete any parentheses
        if (dp[n - 1] == n) {
            ans.add(s);
            return ans;
        }

        // 2. Iterate DP for the sum of lengths of all valid substrings
        int sum = 0;
        for (int i = n - 1; i >= 0; ) {
            if (dp[i] > 0) {
                sum += dp[i];
                i -= dp[i];
            } else {
                i--;
            }
        }
        if (sum == 0) {
            // no valid substrings
            ans.add("");
            return ans;
        }


        char[] preChar = new char[n];
        int preSize = 0;
        int prefix = 0;
        for (int i = prefix; i < n; i++) {
            prefix = i;
            char ch = s.charAt(i);
            if (ch == '(') {
                break;
            } else if (ch != ')') {
                sum--;
                preChar[preSize++] = ch;
            }
        }

        int suffix = n - 1;
        char[] suffChar = new char[n];
        int suffSize = n - 1;
        for (int i = suffix; i >= 0; i--) {
            suffix = i;
            char ch = s.charAt(i);
            if (ch == ')') {
                break;
            } else if (ch == '(') {
            } else {
                sum--;
                suffChar[suffSize--] = ch;
            }
        }

        String preStr = new String(preChar, 0, preSize);
        String suffStr = new String(suffChar, suffSize + 1, n - 1 - suffSize);
        if (prefix >= suffix) {
            ans.add(preStr.length() < suffStr.length() ? suffStr : preStr);
            return ans;
        }

        // 4. Backtracking for all valid substrings by removing n-sum letters
        String middleStr = s.substring(prefix, suffix + 1);
        int cnt = middleStr.length() - sum;
        Set<String> set = new HashSet<>();
        backtracking(middleStr, set, new StringBuffer(), cnt, 0);
        for (String substr : set) {
            ans.add(preStr + substr + suffStr);
        }
        return ans;
    }

    private static void backtracking(String s, Set<String> set, StringBuffer sb, int cnt, int i) {
        // move i until Si is '(' or ')'
        while (i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')') {
            sb.append(s.charAt(i)); // append all letters
            i++;
        }

        if (cnt == 0 && i == s.length()) {
            String substr = sb.toString();
            if (!set.contains(substr) && isValid(substr)) {
                set.add(substr);
            }
        } else if (i == s.length()) {
            // no enough letters have been deleted
        } else {
            // Use Si
            if (i < s.length()) {
                // set state
                sb.append(s.charAt(i));
                // recursion
                backtracking(s, set, sb, cnt, i + 1);
                // reverse state
                sb.deleteCharAt(sb.length() - 1);
            }

            // Ignore Si
            if (cnt > 0) {
                backtracking(s, set, sb, cnt - 1, i + 1);
            }
        }

        // delete all letters at tail
        while (!sb.isEmpty() && sb.charAt(sb.length() - 1) != '(' && sb.charAt(sb.length() - 1) != ')') {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean isValid(String str) {
        char[] stack = new char[str.length()];
        int top = -1;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack[++top] = ch;
            } else if (ch == ')') {
                if (top == -1 || stack[top] != '(') {
                    return false;
                }
                top--;
            }
        }

        return top == -1;
    }

    public static void main(String[] args) {
        // ["()()()"]
        List<String> l3 = removeInvalidParentheses("()()()");
        // [""]
        List<String> l4 = removeInvalidParentheses(")(");
        // ["()()()","(())()"]
        List<String> l1 = removeInvalidParentheses("()())()");
        // ["(a)()()","(a())()"]
        List<String> l2 = removeInvalidParentheses("(a)())()");
        // ["n"]
        List<String> l5 = removeInvalidParentheses("n");
        List<String> l7 = removeInvalidParentheses("abc");
        List<String> l8 = removeInvalidParentheses("abc(ww)");
        List<String> l9 = removeInvalidParentheses("(w(w)");
        List<String> l10 = removeInvalidParentheses("abc(w(ww)abc");
        List<String> l11 = removeInvalidParentheses("))(((((()())(()");
        List<String> l12 = removeInvalidParentheses("))))))))))))))))))))aaaaa");
        List<String> l13 = removeInvalidParentheses(")))a)))a)))a)))))a)))a))a)");
        List<String> l14 = removeInvalidParentheses("aaaaa))))))))))))))))))))");
        List<String> l15 = removeInvalidParentheses("aaaaa((((((((((((((((((");
        List<String> l16 = removeInvalidParentheses("((((((((((((((((((aaaaa");
        List<String> l17 = removeInvalidParentheses("((a(a(a(a(((((((((((((");
        List<String> l18 = removeInvalidParentheses(")))))))aaaaa(((((((((((");
        List<String> l19 = removeInvalidParentheses("))))))bbb(aaaaa(((((((((");
        List<String> l20 = removeInvalidParentheses("))))))bbb()aaaaa(((((((((");
        List<String> l21 = removeInvalidParentheses(")(f");
    }
}
