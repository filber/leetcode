package sw;

//https://leetcode.com/problems/binary-subarrays-with-sum/

public class _930_BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums, goal) - count(nums, goal - 1);
    }

    // how many sub-arrays whose sum <= goal
    private int count(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int sum = 0;
        int count = 0;
        int n = nums.length;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            // it's guaranteed that sum<=goal
            // for all sub-arrays ending at R, total count would be Window Size
            count += r - l + 1;
        }
        return count;
    }
}
