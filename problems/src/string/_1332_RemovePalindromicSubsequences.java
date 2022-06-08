package string;

//https://leetcode.com/problems/remove-palindromic-subsequences/

public class _1332_RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r && chars[l] == chars[r]) {
            l++;
            r--;
        }
        if (l >= r) {
            return 1;
        } else {
            return 2;
        }
    }
}
