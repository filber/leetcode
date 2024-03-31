package sw;

import java.util.LinkedList;
import java.util.Queue;

public class _2444_CountSubarraysWithFixedBounds {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0L;
        for (int startIdx = 0; startIdx < nums.length; startIdx++) {
            if (nums[startIdx] < minK || nums[startIdx] > maxK) {
                continue;
            }
            int r = startIdx;
            int prevMin = Integer.MIN_VALUE;
            int prevMax = Integer.MIN_VALUE;
            for (; r < nums.length && nums[r] >= minK && nums[r] <= maxK; r++) {
                if (nums[r] == minK) {
                    prevMin = Math.max(prevMin, r);
                }
                if (nums[r] == maxK) {
                    prevMax = Math.max(prevMax, r);
                }
                if (prevMin != Integer.MIN_VALUE && prevMax != Integer.MIN_VALUE) {
                    int l = Math.min(prevMin, prevMax);
                    count += l - startIdx + 1;
                }
            }
            startIdx = r - 1;
        }

        return count;
    }
}
