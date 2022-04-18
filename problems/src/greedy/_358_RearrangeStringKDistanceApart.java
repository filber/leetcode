package greedy;

//https://leetcode.com/problems/rearrange-string-k-distance-apart/

import java.util.PriorityQueue;

public class _358_RearrangeStringKDistanceApart {

//    Given a non-empty string s and an integer k,
//    rearrange the string such that the same characters are
//    at least distance k from each other.
//    All input strings are given in lowercase letters.
//    If it is not possible to rearrange the string, return an empty string "".

    public String rearrangeString(String str, int k) {
        int[] cnt = new int[26];
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            cnt[ch - 'a']++;
        }

        int maxFreq = 0;
        int maxFreqCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == maxFreq) {
                maxFreqCnt++;
            } else if (cnt[i] > maxFreq) {
                maxFreq = cnt[i];
                maxFreqCnt = 1;
            }
        }

        if ((maxFreq - 1) * k + maxFreqCnt > chars.length) {
            return "";
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                pq.add(new int[]{i, cnt[i]});
            }
        }

        int idx = 0;
        int[][] charCnt = new int[k][];
        while (!pq.isEmpty()) {
            int sz = Math.min(pq.size(), k);
            for (int i = 0; i < sz; i++) {
                int[] ch = pq.poll();
                chars[idx++] = (char) (ch[0] + 'a');
                ch[1]--;
                charCnt[i] = ch;
            }

            for (int i = 0; i < sz; i++) {
                if (charCnt[i][1] > 0) {
                    pq.add(charCnt[i]);
                }
            }
        }
        return new String(chars);
    }
}
