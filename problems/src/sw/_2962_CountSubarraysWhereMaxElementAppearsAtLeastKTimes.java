package sw;

//https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times

public class _2962_CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    public long countSubarrays(int[] nums, int k) {
        int target = Integer.MIN_VALUE;
        for (int num : nums) {
            target = Math.max(target, num);
        }

        int l = 0;
        int count = 0;
        long total = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == target) {
                count++;
            }

            while (count > k) {
                // move l until count <=k
                if (nums[l] == target) {
                    count--;
                }
                l++;
            }

            while (l < r && nums[l] != target) {
                // move l until nums[l] == target
                l++;
            }
            if (count == k) {
                // include other target + [Valid Window] + exclude other target
                total += l + 1;
            }
        }
        return total;
    }
}
