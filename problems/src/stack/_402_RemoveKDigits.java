package stack;

//https://leetcode.com/problems/remove-k-digits/

public class _402_RemoveKDigits {

    public String removeKdigits(String num, int k) {
        char[] numChars = num.toCharArray();
        char[] stack = new char[numChars.length];
        int top = -1;
        int numIdx = 0;
        for (; numIdx < numChars.length; numIdx++) {
            char ch = numChars[numIdx];
            if (k == 0) {
                break;
            } else {
                while (top != -1 && stack[top] > ch && k > 0) {
                    top--;
                    k--;
                }
                stack[++top] = ch;
            }
        }

        int stackSize = top + 1;

        // Copy all chars from stack to resChars, while skipping last k chars
        char[] resChars = new char[stackSize + numChars.length - numIdx - k];
        int nonZeroIdx = -1;
        int resIdx = 0;
        for (; resIdx < stackSize - k; resIdx++) {
            resChars[resIdx] = stack[resIdx];
            if (nonZeroIdx == -1 && resChars[resIdx] != '0') {
                nonZeroIdx = resIdx;
            }
        }

        // Copy all remaining chars from numChars to resChars
        for (int i = numIdx; i < numChars.length; i++, resIdx++) {
            resChars[resIdx] = numChars[i];
            if (nonZeroIdx == -1 && resChars[resIdx] != '0') {
                nonZeroIdx = resIdx;
            }
        }

        if (nonZeroIdx == -1) {
            return "0";
        } else {
            // skip leading zeros
            String res = new String(resChars, nonZeroIdx, resChars.length - nonZeroIdx);
            return res;
        }
    }
}
