package math;

//https://leetcode.com/problems/single-number/

public class _136_SingleNumber {

    public int singleNumber(int[] nums) {
        int num = 0;
        for (int val : nums) {
            num ^= val;
        }
        return num;
    }
}
