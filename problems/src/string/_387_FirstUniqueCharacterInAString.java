package string;

//https://leetcode.com/problems/first-unique-character-in-a-string/

import java.util.Arrays;

public class _387_FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int[] idx = new int[26];
        Arrays.fill(idx, -1);

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (idx[ch - 'a'] == -1) {
                idx[ch - 'a'] = i; // first time to detect
            } else {
                idx[ch - 'a'] = Integer.MAX_VALUE;
            }
        }

        int rst = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (idx[i] != -1) {
                rst = Math.min(rst, idx[i]);
            }
        }

        if (rst == Integer.MAX_VALUE) {
            return -1;
        } else {
            return rst;
        }
    }
}
