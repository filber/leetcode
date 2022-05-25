package greedy;

//https://leetcode.com/problems/monotone-increasing-digits/

import java.util.Arrays;

public class _738_MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int idx = -1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return n;
        }

        Arrays.fill(chars, idx + 1, chars.length, '9');
        int j = idx;
        while (j > 0) {
            if (chars[j - 1] == chars[j]) {
                chars[j] = '9';
                j--;
            } else {
                chars[j] -= 1;
                break;
            }
        }
        if (j==0) {
            chars[j] -= 1;
        }
        int ans = Integer.parseInt(new String(chars));
        return ans;
    }
}
