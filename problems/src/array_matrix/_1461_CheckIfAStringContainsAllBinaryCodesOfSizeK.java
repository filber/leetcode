package array_matrix;

//https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

import java.util.HashSet;
import java.util.Set;

public class _1461_CheckIfAStringContainsAllBinaryCodesOfSizeK {

    public boolean hasAllCodes(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (k >= n) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int winVal = 0;
        for (int i = 0; i < k; i++) {
            winVal <<= 1;
            winVal += chars[i] - '0';
        }
        set.add(winVal);

        int MAX_SIZE = 1 << k;
        for (int r = k; r < n; r++) {
            if (set.size() == MAX_SIZE) {
                return true;
            }
            int lVal = chars[r - k] - '0';
            int rVal = chars[r] - '0';
            winVal = ((winVal - (lVal << (k - 1))) << 1) + rVal;
            set.add(winVal);
        }

        return set.size() == MAX_SIZE;
    }
}
