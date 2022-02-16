package string;

// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

// TOPICS:
// [String]

// TIPS:
// Split the string by D&Q
// Expanding the gap as big as possible.
public class _395_LongestSubstringWithAtLeastKRepeatingCharacters {

    char[] chars;
    int n;
    int K;
    public int longestSubstring(String s, int k) {
        n = s.length();
        chars = s.toCharArray();
        this.K = k;

        int maxLen = longestSubstring(0, n - 1);
        return maxLen;
    }

    public int longestSubstring(int i, int j) {
        if (i > j) {
            return 0;
        }

        int[] charCnt = new int[26];
        for (int k = i; k <= j; k++) {
            charCnt[chars[k] - 'a']++;
        }

        int maxLen;
        for (int k = i; k <= j; k++) {
            if (charCnt[chars[k] - 'a'] < K) {
                int leftLen = longestSubstring(i, k - 1);
                int p = k;
                while (p <= j && charCnt[chars[p] - 'a'] < K) {
                    p++;
                }
                int rightLen = longestSubstring(p, j);
                maxLen = Math.max(leftLen, rightLen);
                return maxLen;
            }
        }

        // all characters are valid, return length of this substring
        return j - i + 1;
    }
}
