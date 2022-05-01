package bs;

//https://leetcode.com/problems/find-k-th-smallest-pair-distance/

import java.util.Arrays;

public class _719_FindKThSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = count(nums, mid);
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int count(int[] nums, int distance) {
        int count = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > distance) {
                l++;
            }
            count += r - l;
        }
        return count;
    }

}
