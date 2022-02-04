package array_matrix;

//https://leetcode.com/problems/contiguous-array/

import java.util.HashMap;
import java.util.Map;

public class _525_ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                prefixSum += 1;
            } else {
                prefixSum -= 1;
            }

            if (map.containsKey(prefixSum)) {
                int j = map.get(prefixSum);
                maxLen = Math.max(maxLen, i - j);
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // 2
        int m1 = findMaxLength(new int[]{0, 1});
        // 2
        int m2 = findMaxLength(new int[]{0, 1, 0});
        // 0
        int m3 = findMaxLength(new int[]{1, 1});
        // 0
        int m4 = findMaxLength(new int[]{0, 0});
        // 8
        int m5 = findMaxLength(new int[]{0, 1, 1, 1, 0, 0, 0, 1, 1});
        // 4
        int m6 = findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0});
    }
}
