package string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/

public class _438_FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        int[] sCnt = new int[26];
        char[] sChars = s.toCharArray();
        int m = sChars.length;

        int[] pCnt = new int[26];
        char[] pChars = p.toCharArray();
        int n = pChars.length;
        for (int i = 0; i < n; i++) {
            pCnt[pChars[i] - 'a']++;
        }


        List<Integer> ans = new ArrayList<>();


        for (int i = 0; (i + n - 1) < m; i++) {
            int end = i + n - 1;
            // 1. Refresh pCnt and sCnt
            if (i == 0) {
                for (int j = 0; j <= end; j++) {
                    sCnt[sChars[j] - 'a']++;
                }
            } else {
                sCnt[sChars[i - 1] - 'a']--;
                sCnt[sChars[end] - 'a']++;
            }

            // 2. Compare pCnt and sCnt
            boolean same = true;
            for (int k = 0; k < 26; k++) {
                if (sCnt[k] != pCnt[k]) {
                    same = false;
                    break;
                }
            }
            if (same) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // [0,6]
        List<Integer> l1 = findAnagrams("cbaebabacd", "abc");

        // [0,1,2]
        List<Integer> l2 = findAnagrams("abab", "ab");
    }
}
