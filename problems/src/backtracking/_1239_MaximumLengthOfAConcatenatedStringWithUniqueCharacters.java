package backtracking;

// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters

import java.util.*;

public class _1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    int maxLen = 0;
    List<String> arr;
    int n;
    boolean[] occur;

    public int maxLength(List<String> arr) {
        occur = new boolean[26];
        // filter arr
        this.arr = new ArrayList<>();
        for(String str: arr) {
            char[] chars = str.toCharArray();
            Set<Character> set = new HashSet<>();
            boolean valid = true;
            for(char ch: chars) {
                if(set.contains(ch)) {
                    valid = false;
                    break;
                }
                set.add(ch);
            }
            if(valid) {
                this.arr.add(str);
            }
        }
        n = this.arr.size();

        backtracking(0,0);
        return maxLen;
    }

    private void backtracking(int length, int i) {
        if(i==n) {
            maxLen = Math.max(maxLen,length);
            return;
        }
        String curStr = arr.get(i);
        char[] chars = curStr.toCharArray();
        boolean couldAppend = true;
        for(char ch : chars) {
            if(occur[ch-'a']) {
                couldAppend = false;
                break;
            }
        }

        // append curStr
        if(couldAppend) {
            // update states
            for(char ch : chars) {
                occur[ch-'a'] = true;
            }

            backtracking(length + chars.length,i+1);

            // revert states
            for(char ch : chars) {
                occur[ch-'a'] = false;
            }
        }

        // skip curStr
        backtracking(length,i+1);
    }
}
