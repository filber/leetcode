package bs;

//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

public class _1658_MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < x) {
            return -1;
        } else if (sum == x) {
            return nums.length;
        }
        int target = sum - x;
        int l = 0;
        int ws = 0;
        int len = 0;
        for (int r = 0; r < nums.length; r++) {
            while (ws + nums[r] > target) {
                ws -= nums[l];
                l++;
            }
            ws += nums[r];
            if (ws == target) {
                len = Math.max(len, r - l + 1);
            }
        }

        if (len == 0) {
            return -1;
        } else {
            return nums.length - len;
        }
    }
}
