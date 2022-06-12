package string;

//https://leetcode.com/problems/palindrome-permutation/

public class _266_PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (char ch : chars) {
            count[ch - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }
}
