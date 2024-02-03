package dp;

//https://leetcode.com/problems/wiggle-subsequence/

import java.util.ArrayList;
import java.util.List;

public class _376_WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                // last pair makes a contribution to up
                up = down + 1;
            } else if (nums[i - 1] > nums[i]) {
                // last pair makes a contribution to down
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public int wiggleMaxLengthGreedy(int[] nums) {
        List<Integer> diff = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int delta = nums[i] - nums[i - 1];
            if (delta != 0) {
                diff.add(delta);
            }
        }
        if (diff.isEmpty()) {
            return 1;
        }

        int len = 2;
        for (int i = 1; i < diff.size(); i++) {
            int prevDiff = diff.get(i - 1);
            int curDiff = diff.get(i);
            if ((prevDiff > 0 && curDiff < 0) ||
                    (prevDiff < 0 && curDiff > 0)
            ) {
                len++;
            }
        }
        return len;
    }

}
