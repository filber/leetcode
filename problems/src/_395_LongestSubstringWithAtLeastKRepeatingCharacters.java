import java.util.HashMap;

// TOPICS:
// [Divide and Conquer], [String]

// TIPS:
// Split the string by D&Q
// Expanding the gap as big as possible.
public class _395_LongestSubstringWithAtLeastKRepeatingCharacters {

    public static int longestSubstring(String s, int k) {
        return longestSubstring(s, k, 0, s.length() - 1);
    }

    public static int longestSubstring(String s, int k, int start, int end) {
        if (start > end) {
            return 0;
        }
        int[] chCnt = new int[26];
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            chCnt[ch - 'a']++;
        }

        for (int i = start; i <= end; i++) {
            if (chCnt[s.charAt(i) - 'a'] < k) {
                // this string is not valid
                int leftLongest = longestSubstring(s,k,start,i-1);
                int j = i + 1;
                while (j < s.length() && chCnt[s.charAt(j) - 'a'] < k) j++;

                int rightLongest = longestSubstring(s, k, j, end);
                return Math.max(leftLongest, rightLongest);
            }
        }

        // this string is valid
        return end - start + 1;
    }

    public static void main(String[] args) {
        int l1 = longestSubstring("aaabb",3); //3

        int l2 = longestSubstring("ababbc",2); //5

        int l3 = longestSubstring("aaabbbccaaaaabbbbb",3); //10
    }
}
