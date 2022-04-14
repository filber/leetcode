package math;

//https://leetcode.com/problems/single-number-iii/

public class _260_SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int bit = 1;
        // find the most right 1 bit (they differ at this bit)
        while ((xor & 1) == 0) {
            xor >>= 1;
            bit <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((bit & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
