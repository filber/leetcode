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
        int start = nums[0];
        int end;
        for (int i = 0; i < n; i++) {
            end = nums[i];
            if (i == n - 1) {
                addRange(start, end);
            } else if (nums[i] + 1 != nums[i + 1]) {
                addRange(start, end);
                start = nums[i + 1];
            }
        }

        return ans;
    }

    private void addRange(int start, int end) {
        if (start == end) {
            ans.add(String.valueOf(start));
        } else {
            ans.add(String.format("%d%s%d", start, "->", end));
        }
    }
}
