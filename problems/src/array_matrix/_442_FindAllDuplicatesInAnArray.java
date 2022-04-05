package array_matrix;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class _442_FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
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

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
