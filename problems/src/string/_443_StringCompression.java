package string;

//https://leetcode.com/problems/string-compression/

public class _443_StringCompression {

    public int compress(char[] chars) {
        int l = 0, r = 0, group = 0;
        while (r < chars.length) {
            if (chars[l] == chars[r]) {
                r++;
                group++;
            } else {
                l++;
                l = fillDigits(chars, l, group);
                chars[l] = chars[r];
                group = 0;
            }
        }

        l++;
        if (group != 1) {
            l = fillDigits(chars, l, group);
        }

        return l;
    }

    private int fillDigits(char[] chars, int i, int group) {
        if (group == 1) {
            return i;
        }
        char[] digits = String.valueOf(group).toCharArray();
        for (char digit : digits) {
            chars[i] = digit;
            i++;
        }
        return i;
    }
}
