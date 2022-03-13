package stack;

//https://leetcode.com/problems/valid-parentheses/

public class _20_ValidParentheses {

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        char[] stack = new char[n];
        int top = -1;
        char[] map = new char[128];
        map[')'] = '(';
        map[']'] = '[';
        map['}'] = '{';

        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack[++top] = ch;
            } else if (top == -1 || stack[top] != map[ch]) {
                return false;
            } else {
                top--;
            }
        }

        return top == -1;
    }
}
