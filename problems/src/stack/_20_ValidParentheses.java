package stack;

//https://leetcode.com/problems/valid-parentheses/

public class _20_ValidParentheses {

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        char[] mapping = new char[128];
        mapping[')'] = '(';
        mapping[']'] = '[';
        mapping['}'] = '{';
        char[] stack = new char[s.length()];
        int top = -1;
        for (char ch : chars) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack[++top] = ch;
                    break;
                case ')':
                case ']':
                case '}':
                    if (top == -1 || stack[top] != mapping[ch]) {
                        return false;
                    } else {
                        top--;
                    }
            }
        }
        return top == -1;
    }

    public static void main(String[] args) {
        boolean b1 = isValid("()");
        boolean b2 = isValid("()[]{}");
        boolean b3 = isValid("(()){[]{}}");
        boolean b4 = isValid("(([)){[]{}}");
        boolean b5 = isValid("[}");
        boolean b6 = isValid("(()");
    }
}
