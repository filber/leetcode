package string;

//https://leetcode.com/problems/minimum-window-substring/

public class _76_MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        int[] counter = new int[128];
        int cnt = t.length();
        for (char c : t.toCharArray()) {
            counter[c]++;
        }
        int minLen = Integer.MAX_VALUE;
        int minIdx = 0;
        int l = 0;
        int r = 0;
        int n = s.length();
        char[] sChars = s.toCharArray();
        while (r < n) {
            if (counter[sChars[r]] > 0) {
                cnt --;
            }
            counter[sChars[r]]--;
            r++;
            while (cnt == 0) {
                int len = r - l;
                if (len < minLen) {
                    minLen = len;
                    minIdx = l;
                }
                counter[sChars[l]]++;
                if (counter[sChars[l]] > 0) {
                    cnt ++;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minIdx, minIdx + minLen);
    }

    public static void main(String[] args) {
        // BANC
        String m1 = minWindow("ADOBECODEBANC", "ABC");
        // a
        String m2 = minWindow("a", "a");
        // ""
        String m3 = minWindow("a", "aa");
        // ab
        String m4 = minWindow("abc", "ab");
        // ba
        String m5 = minWindow("bba", "ab");
    }
}
