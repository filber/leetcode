package math;

//https://leetcode.com/problems/single-number-ii/

public class _137_SingleNumberII {

    // Constraints:
    //    2 <= nums.length <= 3 * 10^4
    //    -2^31 <= nums[i] <= 2^31 - 1

    // trinary
    // 00->01->10->00
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            b = (b ^ x) & ~a;
            a = (a ^ x) & ~b;
        }
        return b;
    }
}
