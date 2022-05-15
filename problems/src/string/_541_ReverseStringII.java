package string;

//https://leetcode.com/problems/reverse-string-ii/

public class _541_ReverseStringII {

    public String reverseStr(String s, int k) {
        if (k == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int step = 2 * k;
        for (int i = 0; i < chars.length; i += step) {
            reverse(chars, i, Math.min(i + k - 1, chars.length - 1));
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
}
