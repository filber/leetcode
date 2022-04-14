package math;

//https://leetcode.com/problems/single-number-ii/

public class _137_SingleNumberII {

    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three;
        for (int num : nums) {
            two |= one & num;
            one ^= num;
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }

    public int singleNumberBits(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32 && num != 0; i++) {
                bits[i] += num & 1;
                num >>>= 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res | ((bits[i] % 3) << i);
        }
        return res;
    }
}
