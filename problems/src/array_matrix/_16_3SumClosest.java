package array_matrix;
// https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

public class _16_3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int pos = 0;
        int minDiff = Integer.MAX_VALUE;
        int sum = 0;
        while (pos < n) {
            int a = nums[pos];
            int left = pos + 1;
            int right = n - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int diff = a + b + c - target;
                if (Math.abs(diff) < minDiff) {
                    sum = a + b + c;
                    minDiff = Math.abs(diff);
                    if (diff == 0) {
                        return sum;
                    }
                }
                if (diff > 0) {
                    // move right
                    while (right >= 0 && nums[right] == c) {
                        right--;
                    }
                } else {
                    // move left
                    while (left < n && nums[left] == b) {
                        left++;
                    }
                }
            }
            // move pos
            while (pos < n && nums[pos] == a) {
                pos++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // 2
        int m1 = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        // 0
        int m2 = threeSumClosest(new int[]{0, 0, 0}, 1);
        // 0
        int m3 = threeSumClosest(new int[]{0, 2, 1, -3}, 1);
    }
}
