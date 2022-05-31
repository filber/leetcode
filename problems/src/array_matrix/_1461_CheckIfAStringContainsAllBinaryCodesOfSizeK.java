package array_matrix;

//https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

public class _1461_CheckIfAStringContainsAllBinaryCodesOfSizeK {

    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        boolean[] has = new boolean[(int) Math.pow(2, k)];
        char[] chars = s.toCharArray();
        int n = chars.length;
        int value = 0;
        for (int i = 0; i < k; i++) {
            value <<= 1;
            value += chars[i] - '0';
        }
        has[value] = true;
        int count = 1;

        for (int i = 1; i + k - 1 < n; i++) {
            int preValue = chars[i - 1] - '0';
            value -= preValue << (k - 1);
            value <<= 1;
            int curValue = chars[i + k - 1] - '0';
            value += curValue;
            if (!has[value]) {
                has[value] = true;
                count++;
                if (count == has.length) {
                    return true;
                }
            }
        }

        return false;
    }
}
