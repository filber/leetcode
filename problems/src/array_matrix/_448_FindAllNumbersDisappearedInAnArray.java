package array_matrix;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class _448_FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == nums[i] - 1) {
                continue;
            }

            // cycle sort
            int to = nums[i];
            while (to != (nums[to - 1])) {
                // swap to and nums[to]
                int tmp = nums[to - 1];
                nums[to - 1] = to;
                to = tmp;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i + 1 != nums[i]) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
