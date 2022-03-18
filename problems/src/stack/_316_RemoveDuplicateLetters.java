package stack;

public class _316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] charCnt = new int[26];
        // true: must delete; false: could delete
        boolean[] deleteFlag = new boolean[26];
        char[] stack = new char[26];
        int top = -1;

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            charCnt[ch - 'a']++;
        }

        for (char ch : chars) {
            if (deleteFlag[ch - 'a']) {
                charCnt[ch - 'a']--;
                continue; // skip ch
            }

            while (top >= 0 && charCnt[stack[top] - 'a'] > 0 && ch < stack[top]) {
                deleteFlag[stack[top] - 'a'] = false;
                top--;
            }

            stack[++top] = ch;

            deleteFlag[stack[top] - 'a'] = true;
            charCnt[stack[top] - 'a']--;
        }

        return new String(stack, 0, top + 1);
    }
}
