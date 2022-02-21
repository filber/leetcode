package string;

// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

public class _1876_SubstringsOfSizeThreeWithDistinctCharacters {

    //    Constraints:
//        1 <= s.length <= 100
//        s consists of lowercase English letters.
    public static int countGoodSubstrings(String s) {
        char[] chars = s.toCharArray();
        final int n = chars.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int p2 = i + 1;
            int p3 = i + 2;
            count++;
            if (chars[i] == chars[p2] || chars[i] == chars[p3] || chars[p2] == chars[p3]) {
                count--;
            }
        }

        return count;
    }
}