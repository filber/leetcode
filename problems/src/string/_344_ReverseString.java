package string;

//https://leetcode.com/problems/reverse-string/

public class _344_ReverseString {

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char lCh = s[l];
            s[l] = s[r];
            s[r] = lCh;
            l++;
            r--;
        }
    }
}
