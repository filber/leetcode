package array_matrix;

//https://leetcode.com/problems/maximum-erasure-value/

public class _1695_MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        int l = 0, r = 0;
        int sum = 0;
        int maxSum = 0;
        int[] map = new int[10001];
        while (r < nums.length) {
            int lVal = nums[l];
            int rVal = nums[r];
            int rCnt = map[rVal];
            if (rCnt > 0) {
                map[lVal]--;
                l++;
                sum -= lVal;
            } else {
                sum += rVal;
                map[rVal] = 1;
                r++;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
