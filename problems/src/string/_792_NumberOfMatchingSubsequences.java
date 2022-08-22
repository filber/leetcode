package string;

//https://leetcode.com/problems/number-of-matching-subsequences/

import java.util.ArrayList;
import java.util.List;

public class _792_NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] next = new int[n + 1][26];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                next[i][j] = next[i + 1][j];
            }
            char lCh = chars[i];
            next[i][lCh - 'a'] = i + 1;
        }

        int cnt = 0;
        for (String word : words) {
            if (word.length() > s.length()) {
                continue;
            }
            char[] wChars = word.toCharArray();
            int idx = 0;
            boolean found = true;
            for (int i = 0; i < wChars.length; i++) {
                char wCh = wChars[i];
                if (next[idx][wCh - 'a'] != 0) {
                    idx = next[idx][wCh - 'a'];
                } else {
                    found = false;
                    break;
                }
            }

            if (found) {
                cnt++;
            }
        }
        return cnt;
    }

    public int numMatchingSubseqBS(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            pos[ch - 'a'].add(i);
        }

        int count = 0;
        for (String word : words) {
            if (word.length() > chars.length) {
                continue;
            }
            char[] wChars = word.toCharArray();
            int p = 0;
            for (char ch : wChars) {
                List<Integer> list = pos[ch - 'a'];
                int lower = lowerBound(list, p);
                if (lower == -1) {
                    p = -1;
                    break;
                }
                p = lower + 1;
            }
            if (p != -1) {
                count++;
            }
        }
        return count;
    }

    // find the smallest value in list that >= target
    // if no value >= target, return -1
    private int lowerBound(List<Integer> list, int target) {
        if (list.isEmpty()) {
            return -1;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (list.get(l) >= target) {
            return list.get(l);
        } else {
            return -1;
        }
    }
}
