package array_matrix;

//https://leetcode.com/problems/count-of-smaller-numbers-after-self/

import java.util.ArrayList;
import java.util.List;

public class _315_CountOfSmallerNumbersAfterSelf {

    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        helper(nums, 0, nums.length - 1);

        List<Integer> list = new ArrayList<>();
        for (int val : count) {
            list.add(val);
        }
        return list;
    }

    private int[] helper(int[] nums, int start, int end) {
        if (start == end) {
            return new int[]{nums[start]};
        }
        int mid = (start + end) / 2;
        int[] leftSorted = helper(nums, start, mid);
        int[] rightSorted = helper(nums, mid + 1, end);
        for (int i = start; i <= mid; i++) {
            int cnt = findSmallerCount(nums[i], rightSorted);
            count[i] += cnt;
        }

        int l = 0, r = 0;
        int[] sorted = new int[end - start + 1];
        int idx = 0;
        while (l < leftSorted.length && r < rightSorted.length) {
            if (leftSorted[l] <= rightSorted[r]) {
                sorted[idx++] = leftSorted[l++];
            } else {
                sorted[idx++] = rightSorted[r++];
            }
        }
        while (l < leftSorted.length) {
            sorted[idx++] = leftSorted[l++];
        }
        while (r < rightSorted.length) {
            sorted[idx++] = rightSorted[r++];
        }
        return sorted;
    }


    private int findSmallerCount(int target, int[] sorted) {
        int l = 0, r = sorted.length - 1;
        // find the lower bound >= target
        while (l < r) {
            int mid = (l + r) / 2;
            if (sorted[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // count of numbers < target
        if (sorted[l] < target) {
            return l + 1;
        } else {
            return l;
        }
    }
}
