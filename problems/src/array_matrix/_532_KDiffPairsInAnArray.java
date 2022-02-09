package array_matrix;

// https://leetcode.com/problems/k-diff-pairs-in-an-array/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _532_KDiffPairsInAnArray {

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int cnt = 0;
        int n = nums.length;
        while (j < n) {
            // move j until N[j] - N[i] == k
            while (j < n && nums[j] - nums[i] < k) {
                j++;
            }
            if (j < n && nums[j] - nums[i] == k) {
                cnt++;
            }

            // move i to skip duplicates
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
            j = i + 1;
        }

        return cnt;
    }

    public static int findPairsMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int n : nums) {
            if (map.containsKey(n)) {
                if (k == 0 && map.get(n) == 1) {
                    cnt++;
                    map.put(n, 2);
                }
            } else {
                if (map.containsKey(n - k)) {
                    cnt++;
                }
                if (map.containsKey(n + k)) {
                    cnt++;
                }
                map.put(n, 1);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int p1 = findPairs(new int[]{3, 1, 4, 1, 5}, 2);
        int p2 = findPairs(new int[]{1, 2, 3, 4, 5}, 1);
        int p3 = findPairs(new int[]{1, 3, 1, 5, 4}, 0);
    }

}
