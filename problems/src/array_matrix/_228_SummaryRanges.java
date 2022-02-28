package array_matrix;

//https://leetcode.com/problems/summary-ranges/

import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges {

    private List<String> ans = new ArrayList<>();

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return ans;
        }

        StringBuffer sb = new StringBuffer();
        for (int end = 0; end < n; end++) {
            sb.setLength(0); // clear string buffer
            int start = end;

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
        }

        return ans;
    }
}
