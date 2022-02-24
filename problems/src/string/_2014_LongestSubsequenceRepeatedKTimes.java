package string;
//https://leetcode.com/problems/longest-subsequence-repeated-k-times/

import java.util.*;

public class _2014_LongestSubsequenceRepeatedKTimes {

    String ans = "";
    int k;
    char[] chars;
    int n = 0;
    int[] charCnt = new int[26];

    public String longestSubsequenceRepeatedK(String s, int k) {
        this.k = k;
        char[] sChars = s.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            charCnt[sChars[i] - 'a']++;
        }
        chars = new char[sChars.length];
        // skip invalid chars
        for (int i = 0; i < sChars.length; i++) {
            if (charCnt[sChars[i] - 'a'] >= k) {
                chars[n++] = sChars[i];
            }
        }

        Queue<String> queue = new ArrayDeque<>();

        List<Character> alphaList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (charCnt[i] >= k) {
                char ch = (char) ('a' + i);
                alphaList.add(ch);
                queue.add(String.valueOf(ch));
            }
        }

        while (!queue.isEmpty()) {
            String p = queue.poll();
            ans = p;
            char[] candChars = new char[p.length() + 1];
            char[] pChars = p.toCharArray();
            for (int i = 0; i < pChars.length; i++) {
                candChars[i] = pChars[i];
            }
            for (char ch : alphaList) {
                candChars[candChars.length - 1] = ch;
                if (checkCount(candChars) == k) {
                    queue.add(new String(candChars));
                }
            }
        }

        return ans;
    }

    private int checkCount(char[] candidate) {
        int i = 0, j = 0, count = 0;
        while (j < n && count < k) {
            if (candidate[i] == chars[j]) {
                i++;
            }
            j++;
            if (i == candidate.length) {
                i = 0;
                count++;
            }
        }

        return count;
    }
}