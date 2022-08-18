package dp;

//https://leetcode.com/problems/longest-string-chain/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1048_LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();
        int length = 0;
        for (String word : words) {
            int wLen = word.length();
            int preLen = 0;
            for (int i = 0; i < wLen; i++) {
                String subStr = word.substring(0, i) + word.substring(i + 1);
                Integer len = map.get(subStr);
                if (len != null) {
                    preLen = Math.max(preLen, len);
                }
            }
            map.put(word, preLen + 1);
            length = Math.max(length, preLen + 1);
        }
        return length;
    }

}
