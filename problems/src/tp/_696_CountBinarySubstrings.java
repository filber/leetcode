package tp;

//https://leetcode.com/problems/count-binary-substrings/

public class _696_CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int cur = 1; // length of current consecutive values
        int last = 0; // length of previous consecutive values
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                cur++;
            } else {
                last = cur;
                cur = 1;
            }
            if (last >= cur) {
                // suppose current value is 1
                // previous values are 0, 00, 000. All will form [0,1]

                // suppose current value is 111
                // previous values are 0, 00. Both [0111] and [00111] are not legal.
                res++;
            }
        }
        return res;
    }
}
