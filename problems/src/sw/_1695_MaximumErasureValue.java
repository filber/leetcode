package sw;

//https://leetcode.com/problems/maximum-erasure-value/

import java.util.HashSet;
import java.util.Set;

public class _1695_MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int l = 0;
        Set<Integer> set = new HashSet<>();
        int maxScore = 0;
        int winScore = 0;
        for (int r = 0; r < n; r++) {
            int rVal = nums[r];
            while (set.contains(rVal)) {
                set.remove(nums[l]);
                winScore -= nums[l];
                l++;
            }
            set.add(rVal);
            winScore += rVal;
            maxScore = Math.max(maxScore, winScore);
        }
        return maxScore;
    }
}
