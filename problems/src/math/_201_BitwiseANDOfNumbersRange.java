package math;

//https://leetcode.com/problems/bitwise-and-of-numbers-range

public class _201_BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            int mask = 1 << i;
            int digit = mask & left;
            if (digit != 0) {
                int next = digit << 1;
                int base = digit + left % digit;
                int diff = next - base;
                if (right - left < diff) {
                    result = result | digit;
                }
            }
        }
        return result;
    }
}
