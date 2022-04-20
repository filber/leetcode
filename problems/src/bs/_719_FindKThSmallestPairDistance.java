package bs;

//https://leetcode.com/problems/find-k-th-smallest-pair-distance/

import java.util.Arrays;

public class _719_FindKThSmallestPairDistance {


    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = count(nums, mid);
            if (cnt < k) {
                // mid UP
                l = mid + 1;
            } else {
                // mid DOWN
                r = mid;
            }
        }

        return l;
    }

    // count of pairs LE distance
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
