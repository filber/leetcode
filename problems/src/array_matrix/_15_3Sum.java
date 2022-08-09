package array_matrix;
// https://leetcode.com/problems/3sum/

import java.util.*;

public class _15_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int pos = 0; pos < n; pos++) {
            if (pos > 0 && nums[pos] == nums[pos - 1]) {
                continue;
            }
            int a = nums[pos];
            int r = n - 1;
            int l = pos + 1;
            while (l < r) {
                int b = nums[l];
                int c = nums[r];
                int sum = a + b + c;
                if (sum == 0) {
                    ans.add(List.of(a, b, c));
                    while (nums[l] == b && l < r) {
                        l++;
                    }
                } else if (sum < 0) {
                    while (nums[l] == b && l < r) {
                        l++;
                    }
                } else {
                    while (nums[r] == c && l < r) {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
