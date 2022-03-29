package string;

//https://leetcode.com/problems/longest-repeating-character-replacement/

public class _424_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] charCnt = new int[26];
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = 0;
        int len = 0;
        char majCh = chars[0];

        while (r < n) {
            char rCh = chars[r];
            int winLen = r - l;
            int replace = winLen - charCnt[majCh - 'A'];
            if (charCnt[majCh - 'A'] == charCnt[rCh - 'A'] || replace < k) {
                // safe to expand window
                charCnt[rCh - 'A']++;
                r++;
                if (charCnt[rCh - 'A'] > charCnt[majCh - 'A']) {
                    majCh = rCh;
                }
            } else {
                // replacement used up
                char lCh = chars[l];
                charCnt[lCh - 'A']--;
                l++;
                if (lCh == majCh) {
                    // majority char might change
                    int majCnt = charCnt[majCh - 'A'];
                    for (int i = 0; i < 26; i++) {
                        if (charCnt[i] > majCnt) {
                            majCnt = charCnt[i];
                            majCh = (char) ('A' + i);
                        }
                    }
                }
            }

            len = Math.max(len, r - l);
        }

        return len;
    }
}
