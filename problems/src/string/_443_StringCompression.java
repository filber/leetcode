package string;

//https://leetcode.com/problems/string-compression/

public class _443_StringCompression {

    public int compress(char[] chars) {
        int l = 0, r = 0;
        int count = 0;
        while (r < chars.length) {
            char lCh = chars[l];
            char rCh = chars[r];
            if (lCh == rCh) {
                count++;
                r++;
            } else {
                l++;
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    char[] countChars = countStr.toCharArray();
                    for (int i = 0; i < countChars.length; i++) {
                        chars[l++] = countChars[i];
                    }
                }
                count = 0;
                chars[l] = rCh;
            }
        }

        l++;
        if (count > 1) {
            String countStr = String.valueOf(count);
            char[] countChars = countStr.toCharArray();
            for (int i = 0; i < countChars.length; i++) {
                chars[l++] = countChars[i];
            }
        }

        return l;
    }
}
