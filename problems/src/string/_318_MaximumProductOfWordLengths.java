package string;

//https://leetcode.com/problems/maximum-product-of-word-lengths/

public class _318_MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] wordMask = new int[n];
        int[] wordLen = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            wordLen[i] = word.length();
            int mask = 0;
            for (char ch : word.toCharArray()) {
                int offset = (int) ch - 'a';
                mask |= 1 << offset;
            }
            wordMask[i] = mask;
        }

        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            int m1 = wordMask[i];
            for (int j = i + 1; j < n; j++) {
                int m2 = wordMask[j];
                if ((m1&m2) == 0) {
                    maxProduct = Math.max(maxProduct, wordLen[i] * wordLen[j]);
                }
            }
        }
        return maxProduct;
    }
}
