package bs;
// https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

public class _16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = Integer.MAX_VALUE;
        for (int pos = 0; pos < n - 2; pos++) {
            while (pos > 0 && pos < n - 2 && nums[pos] == nums[pos - 1]) {
                pos++;
            }
            int a = nums[pos];
            int l = pos + 1;
            int r = n - 1;
            while (l < r) {
                int b = nums[l];
                int c = nums[r];
                int sum = a + b + c;
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    while (l < r && nums[l] == b) {
                        l++;
                    }
                } else {
                    while (l < r && nums[r] == c) {
                        r--;
                    }
                }
            }
        }
        return closest;
    }
}
