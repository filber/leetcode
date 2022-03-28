package greedy;

//https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

import java.util.Arrays;

public class _1663_SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        while (k > 0) {
            if (n == k) {
                Arrays.fill(chars, 0, n, 'a');
                k = 0;
            } else if (k + 1 - n >= 26) {
                int cnt = (k + 1 - n) / 26;
                Arrays.fill(chars, n - cnt, n, 'z');
                n -= cnt;
                k -= 26 * cnt;
            } else {
                int val = k + 1 - n;
                char ch = (char) (val - 1 + 'a');
                chars[n - 1] = ch;
                k -= val;
                n--;
            }
        }

        return new String(chars);
    }
}
