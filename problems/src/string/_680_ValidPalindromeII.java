package string;

//https://leetcode.com/problems/valid-palindrome-ii/

public class _680_ValidPalindromeII {

    char[] chars;

    public boolean validPalindrome(String s) {
        chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else {
                return valid(l, r - 1) || valid(l + 1, r);
            }
        }
        return true;
    }

    private boolean valid(int l, int r) {
        while (l < r) {
            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
