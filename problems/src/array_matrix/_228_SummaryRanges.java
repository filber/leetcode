package array_matrix;

//https://leetcode.com/problems/summary-ranges/

import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int n = nums.length;
        for (int start = 0; start < n; start++) {
            sb.setLength(0);

            int end = start;
            while (end < n - 1 && nums[end] + 1 == nums[end + 1]) {
                end++;
            }
            if (start == end) {
                sb.append(nums[start]);
            } else {
                sb.append(nums[start]);
                sb.append("->");
                sb.append(nums[end]);
            }
            ans.add(sb.toString());

            start = end;
        }

        return ans;
    }
}
