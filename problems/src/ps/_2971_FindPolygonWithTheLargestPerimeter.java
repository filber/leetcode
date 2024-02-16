package ps;

//https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/

import java.util.Arrays;

public class _2971_FindPolygonWithTheLargestPerimeter {

    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long ps = nums[0] + nums[1];
        long max = -1;
        for (int i = 2; i < n; i++) {
            // use nums[i-1] as the longest side
            // if the sum of all other sides > nums[i-1], that makes a polygon
            // otherwise, can't use nums[i-1] together with any previous sides to form a polygon
            if (ps > nums[i]) {
                max = Math.max(max, ps + nums[i]);
            }
            ps += nums[i];
        }

        return max;
    }
}
