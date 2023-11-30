package bs;
// https://leetcode.com/problems/3sum/

import java.util.*;

public class _15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
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
                if (sum == 0) {
                    list.add(Arrays.asList(a, b, c));
                    while (l < r && nums[l] == b) {
                        l++;
                    }
                } else if (sum < 0) {
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
        return list;
    }
}
