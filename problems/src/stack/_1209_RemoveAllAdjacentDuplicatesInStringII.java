package stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

public class _1209_RemoveAllAdjacentDuplicatesInStringII {

    public String removeDuplicates(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        char[] alphaStack = new char[n];
        int[] cntStack = new int[n];
        int top = -1;
        for (char ch : chars) {
            if (top == -1 || alphaStack[top] != ch) {
                alphaStack[++top] = ch;
                cntStack[top] = 1;
            } else {
                alphaStack[top + 1] = ch;
                cntStack[top + 1] = cntStack[top] + 1;
                top++;
            }

            if (cntStack[top] == k) {
                top -= k;
            }
        }

        return new String(alphaStack, 0, top + 1);
    }
}
