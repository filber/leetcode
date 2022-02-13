package dp;

import java.util.*;

//https://leetcode.com/problems/different-ways-to-add-parentheses/
public class _241_DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        char[] chars = input.toCharArray();
        int n = chars.length;
        List<Integer>[][] mem = new List[n][n];
        return dfs(chars, mem, 0, n - 1);
    }

    private List<Integer> dfs(char[] chars, List<Integer>[][] mem, int start, int end) {
        if (mem[start][end] != null) {
            return mem[start][end];
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = start + 1; i < end; i++) {
            if (chars[i] < '0') {
                List<Integer> left = dfs(chars, mem, start, i - 1);
                List<Integer> right = dfs(chars, mem, i + 1, end);
                ans.addAll(calculate(left, chars[i], right));
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(new String(chars, start, end - start + 1)));
        }
        mem[start][end] = ans;
        return ans;
    }

    public List<Integer> diffWaysToComputeDP(String input) {
        List<Integer> expression = new ArrayList<>();
        char[] chars = input.toCharArray();
        int m = chars.length;
        int pre = 0;
        for (int i = 0; i < m; i++) {
            if (chars[i] < '0') {
                String operand = input.substring(pre, i);
                char operator = input.charAt(i);
                pre = i + 1;
                expression.add(Integer.valueOf(operand));
                expression.add((int) operator);
            }
        }
        expression.add(Integer.valueOf(input.substring(pre)));

        int n = expression.size();
        List<Integer>[][] dp = new List[n][n];
        for (int i = 0; i < n; i += 2) {
            dp[i][i] = new ArrayList<>();
            dp[i][i].add(expression.get(i));
        }

        for (int len = 3; len <= n; len += 2) {
            // sub expression[i,j]
            for (int i = 0; i + len <= n; i += 2) {
                int j = i + len - 1;
                List<Integer> val = new ArrayList<>();
                for (int k = i + 1; k < j; k += 2) {
                    char operator = (char) expression.get(k).intValue();
                    List<Integer> left = dp[i][k - 1];
                    List<Integer> right = dp[k + 1][j];
                    val.addAll(calculate(left, operator, right));
                }
                dp[i][j] = val;
            }
        }

        List<Integer> res = new ArrayList<>(dp[0][n - 1]);
        return res;
    }

    private List<Integer> calculate(List<Integer> left, char operator, List<Integer> right) {
        List<Integer> res = new ArrayList<>();
        for (int l : left) {
            for (int r : right) {
                switch (operator) {
                    case '+':
                        res.add(l + r);
                        break;
                    case '-':
                        res.add(l - r);
                        break;
                    case '*':
                        res.add(l * r);
                        break;
                }
            }
        }
        return res;
    }
}
