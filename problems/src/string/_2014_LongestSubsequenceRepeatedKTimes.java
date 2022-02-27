package string;
//https://leetcode.com/problems/longest-subsequence-repeated-k-times/

import java.util.*;

public class _2014_LongestSubsequenceRepeatedKTimes {

    char[] chars;
    int n;
    int k;

    public String longestSubsequenceRepeatedK(String s, int k) {
        this.k = k;
        char[] originChars = s.toCharArray();
        int[] charCnt = new int[26];
        for (char ch : originChars) {
            charCnt[ch - 'a']++;
        }
        chars = new char[originChars.length];
        n = 0;
        for (char ch : originChars) {
            if (charCnt[ch - 'a'] >= k) {
                chars[n++] = ch;
            }
        }

        List<Character> letter = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < charCnt.length; i++) {
            if (charCnt[i] >= k) {
                char ch = (char) ('a' + i);
                letter.add(ch);
                queue.add(String.valueOf(ch));
            }
        }

        String ans = "";
        while (!queue.isEmpty()) {
            ans = queue.poll();
            char[] candidate = new char[ans.length() + 1];
            for (int i = 0; i < candidate.length - 1; i++) {
                candidate[i] = ans.charAt(i);
            }
            for (char ch : letter) {
                candidate[candidate.length - 1] = ch;
                if (count(candidate) >= k) {
                    queue.add(new String(candidate));
                }
            }
        }
        return ans;
    }

    private int count(char[] candidate) {
        int l = 0, r = 0;
        int cnt = 0;
        while (l < chars.length && r < candidate.length && cnt < k) {
            if (chars[l] == candidate[r]) {
                r++;
                if (r == candidate.length) {
                    r = 0;
                    cnt++;
                }
            }
            l++;
        }
        return cnt;
    }
}