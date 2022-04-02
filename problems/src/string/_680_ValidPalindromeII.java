package string;

//https://leetcode.com/problems/valid-palindrome-ii/

public class _680_ValidPalindromeII {

    char[] chars;

    public boolean validPalindrome(String s) {
        chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        return isValid(l, r, false);
    }

    private boolean isValid(int l, int r, boolean chanceUsed) {
        while (l < r) {
            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else if (!chanceUsed) {
                if (chars[l + 1] == chars[r] && chars[l] == chars[r - 1]) {
                    if (isValid(l + 1, r, true)) {
                        return true;
                    } else if (isValid(l, r - 1, true)) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (chars[l + 1] == chars[r]) {
                    l++;
                    chanceUsed = true;
                } else if (chars[l] == chars[r - 1]) {
                    r--;
                    chanceUsed = true;
                } else {
                    return false;
                }
            } else {
                // chanceUsed=true
                return false;
            }
        }
        return true;
    }
}
