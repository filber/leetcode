package stack;

//https://leetcode.com/problems/remove-k-digits/

public class _402_RemoveKDigits {

    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        char[] stack = new char[chars.length];
        int top = -1;
        for (char ch : chars) {
            while (top != -1 && stack[top] > ch & k > 0) {
                top--;
                k--;
            }
            stack[++top] = ch;
        }

        // skip last k elements in stack
        int stackSize = top + 1 - k;
        for (int i = 0; i < stackSize; i++) {
            if (stack[i] != '0') {
                return new String(stack, i, stackSize - i);
            }
        }

        return "0";
    }
}
