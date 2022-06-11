package greedy;

//https://leetcode.com/problems/monotone-increasing-digits/

import java.util.Arrays;

public class _738_MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int len = str.length();
        int i = len - 1;
        while (i > 0) {
            if (chars[i - 1] > chars[i]) {
                Arrays.fill(chars, i, len, '9');
                chars[i - 1] -= 1;
            }
            i--;
        }

        return Integer.parseInt(new String(chars));
    }
}
