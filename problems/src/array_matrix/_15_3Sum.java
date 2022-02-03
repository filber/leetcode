package array_matrix;
// https://leetcode.com/problems/3sum/

import java.util.*;

public class _15_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int pos = 0;
        while (pos < n) {
            int left = pos + 1;
            int right = n - 1;
            int a = nums[pos];
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;
                if (sum == 0) {
                    ans.add(Arrays.asList(a, b, c));
                    while (left < n && nums[left] == b) {
                        left++;
                    }
                    while (right >= 0 && nums[right] == c) {
                        right--;
                    }
                } else if (sum > 0) {
                    while (right >= 0 && nums[right] == c) {
                        right--;
                    }
                } else {
                    while (left < n && nums[left] == b) {
                        left++;
                    }
                }
            }
            while (pos < n && nums[pos] == a) {
                pos++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // [[-1,-1,2],[-1,0,1]]
        List<List<Integer>> l1 = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        // []
        List<List<Integer>> l2 = threeSum(new int[]{});
        // []
        List<List<Integer>> l3 = threeSum(new int[]{0});
        // [[-1,0,1]]
        List<List<Integer>> l4 = threeSum(new int[]{1, -1, -1, 0});
    }
}
