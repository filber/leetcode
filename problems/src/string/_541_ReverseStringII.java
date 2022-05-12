package string;

//https://leetcode.com/problems/reverse-string-ii/

public class _541_ReverseStringII {

    char[] chars;
    int n;

    public String reverseStr(String s, int k) {
        if (k == 1) {
            return s;
        }

        chars = s.toCharArray();
        n = chars.length;

        for (int i = 0; i < n; i += 2 * k) {
            swapRange(i, Math.min(i + k - 1, n - 1));
        }

        return new String(chars);
    }

    private void swapRange(int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
}
