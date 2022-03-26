package stack;

//https://leetcode.com/problems/remove-duplicate-letters/

public class _316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] stack = new int[n];
        int top = -1;
        int[] lastIdx = new int[26];
        boolean[] used = new boolean[26];

        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            lastIdx[ch - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (used[ch - 'a']) {
                continue; // already in stack
            }
            while (top >= 0 &&
                    ch < chars[stack[top]] &&
                    i < lastIdx[chars[stack[top]] - 'a']) {
                used[chars[stack[top]] - 'a'] = false;
                top--;
            }
            stack[++top] = i;
            used[ch - 'a'] = true;
        }

        char[] ans = new char[top + 1];
        for (int i = 0; i <= top; i++) {
            ans[i] = chars[stack[i]];
        }
        return new String(ans);
    }
}
