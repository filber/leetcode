package string;

//https://leetcode.com/problems/palindrome-permutation/

public class _266_PalindromePermutation {

    // Given a string, determine if a permutation of the string could form a palindrome.
    public boolean canPermutePalindrome(String s) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        int oddCnt = 0;
        for (int c : cnt) {
            if (c % 2 != 0) {
                oddCnt++;
            }
        }

        if (oddCnt > 1) {
            return false;
        } else {
            return true;
        }
    }
}
