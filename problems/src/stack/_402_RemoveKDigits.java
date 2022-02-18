package stack;

//https://leetcode.com/problems/remove-k-digits/

public class _402_RemoveKDigits {

    public String removeKdigits(String num, int k) {
        char[] numChars = num.toCharArray();
        char[] stack = new char[numChars.length];
        int top = -1;

        for (int i = 0; i < numChars.length; i++) {
            char ch = numChars[i];
            while (top != -1 && stack[top] > ch && k > 0) {
                top--;
                k--;
            }
            stack[++top] = ch;
        }

        // skip last k elements in stack
        int stackSize = top + 1 - k;
        for (int i = 0; i < stackSize; i++) {
            if (stack[i] != '0') {
                String res = new String(stack, i, stackSize - i);
                return res;
            }
        }
        return "0";
    }
}
