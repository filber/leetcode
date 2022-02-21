package string;
//https://leetcode.com/problems/substring-with-concatenation-of-all-words/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30_SubstringWithConcatenationOfAllWords {

    int w;
    int k;
    int totalLen;
    int n;
    List<Integer> ans = new ArrayList<>();
    Map<String, Integer> wordCount = new HashMap<>();
    String s;

    public List<Integer> findSubstring(String s, String[] words) {
        this.s = s;
        w = words[0].length();
        k = words.length;
        totalLen = w * k;
        n = s.length();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < w; i++) {
            traverse(i);
        }

        return ans;
    }

    private void traverse(int left) {
        Map<String, Integer> wordFind = new HashMap<>();
        boolean excess = false;
        int wordsUsed = 0;

        for (int right = left; right + w <= n; right += w) {
            String rightWord = s.substring(right, right + w);
            if (!wordCount.containsKey(rightWord)) {
                // reset window states
                wordFind.clear();
                wordsUsed = 0;
                excess = false;
                left = right + w;
            } else {
                while (right - left == totalLen || excess) {
                    String leftWord = s.substring(left, left + w);
                    if (wordFind.get(leftWord) <= wordCount.get(leftWord)) {
                        // we still need leftWord in the window
                        wordsUsed--;
                    } else {
                        // we don't need leftWord
                        excess = false;
                    }
                    wordFind.put(leftWord, wordFind.get(leftWord) - 1);
                    left += w;
                }

                wordFind.put(rightWord, wordFind.getOrDefault(rightWord, 0) + 1);
                if (wordFind.get(rightWord) > wordCount.get(rightWord)) {
                    excess = true;
                } else {
                    wordsUsed++;
                }
                if (wordsUsed == k && !excess) {
                    ans.add(left);
                }
            }
        }
    }
}
