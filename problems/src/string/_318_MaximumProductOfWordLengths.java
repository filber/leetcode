package string;

//https://leetcode.com/problems/maximum-product-of-word-lengths/

public class _318_MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        int[] vals = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            vals[i] = convert(words[i]);
        }
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((vals[i] & vals[j]) == 0) {
                    len = Math.max(len, words[i].length() * words[j].length());
                }
            }
        }
        return len;
    }

    private int convert(String word) {
        int val = 0;
        for (char ch : word.toCharArray()) {
            val |= 1 << (ch - 'a');
        }
        return val;
    }
}
