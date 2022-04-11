package array_matrix;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class _448_FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            int to = nums[i];
            while (to != nums[to - 1]) {
                int tmp = nums[to - 1];
                nums[to - 1] = to;
                to = tmp;
            }
            if (nums[i] != i + 1) {
                nums[i] = to;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
