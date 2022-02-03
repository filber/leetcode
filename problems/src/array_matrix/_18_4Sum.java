package array_matrix;

//https://leetcode.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i < n - 3) {
            int a = nums[i];
            int j = i + 1;
            while (j < n - 2) {
                int b = nums[j];
                int left = j + 1;
                int right = n - 1;
                int targetVal = target - a - b;
                while (left < right) {
                    int c = nums[left];
                    int d = nums[right];
                    int sum = c + d;
                    if (sum == targetVal) {
                        ans.add(Arrays.asList(a, b, c, d));
                        while (left < n && nums[left] == c) {
                            left++;
                        }
                        while (right >= 0 && nums[right] == d) {
                            right--;
                        }
                    } else if (sum > targetVal) {
                        while (right >= 0 && nums[right] == d) {
                            right--;
                        }
                    } else {
                        while (left < n && nums[left] == c) {
                            left++;
                        }
                    }
                }

                while (j < n && nums[j] == b) {
                    j++;
                }
            }
            while (i < n && nums[i] == a) {
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        List<List<Integer>> l1 = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        // [[2,2,2,2]]
        List<List<Integer>> l2 = fourSum(new int[]{2, 2, 2, 2, 2}, 8);
    }
}
