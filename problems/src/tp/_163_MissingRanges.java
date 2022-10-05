package tp;

import java.util.ArrayList;
import java.util.List;

public class _163_MissingRanges {

    // Given a sorted integer array where the range of elements are in the inclusive range [lower, upper],
    // return its missing ranges.
    // For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return [“2”, “4->49”, “51->74”, “76->99”].

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        int l = lower;
        int r = 0;
        while (r < n) {
            if (l + 1 < nums[r]) {
                list.add(l + "->" + (nums[r] - 1));
                l = nums[r];
            } else if (l < nums[r]) {
                list.add(String.valueOf(l));
                l = nums[r];
            } else if (l == nums[r]) {
                l++;
                r++;
            } else {
                // l > nums[r]
                r++;
            }
        }

        if (nums[n - 1] < upper) {
            if (l == upper) {
                list.add(String.valueOf(l));
            } else {
                list.add(l + "->" + upper);
            }
        }
        return list;
    }
}
