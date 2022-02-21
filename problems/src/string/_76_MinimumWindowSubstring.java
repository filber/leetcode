package string;

//https://leetcode.com/problems/minimum-window-substring/

public class _76_MinimumWindowSubstring {

    int[] sCnt;
    int[] tCnt;

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        tCnt = new int[128];
        for (char ch : t.toCharArray()) {
            tCnt[ch]++;
        }

        sCnt = new int[128];
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int minL = 0, minR = 0;
        boolean equals = false;
        while (r < n || equals) {
            if (!equals) {
                sCnt[chars[r]]++;
                r++;
            } else {
                if ((r - l) < minLen) {
                    minLen = r - l;
                    minL = l;
                    minR = r;
                }
                sCnt[chars[l]]--;
                l++;
            }
            equals = compare();
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minL, minR);
        }
    }

    private boolean compare() {
        boolean equals = true;
        for (int i = 'a'; i <= 'z'; i++) {
            if (sCnt[i] < tCnt[i]) {
                equals = false;
                break;
            }
        }
        if (equals) {
            for (int i = 'A'; i <= 'Z'; i++) {
                if (sCnt[i] < tCnt[i]) {
                    equals = false;
                    break;
                }
            }
        }
        return equals;
    }
}
