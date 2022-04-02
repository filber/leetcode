package array_matrix;

//https://leetcode.com/problems/sort-colors/submissions/

import java.util.Arrays;

public class _75_SortColors {

    public void sortColors(int[] nums) {
        int zeroCnt = 0, oneCnt = 0, twoCnt = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    zeroCnt++;
                    break;
                case 1:
                    oneCnt++;
                    break;
                case 2:
                    twoCnt++;
            }
        }
        int i = 0;
        Arrays.fill(nums, 0, zeroCnt, 0);
        i += zeroCnt;
        Arrays.fill(nums, i, i + oneCnt, 1);
        i += oneCnt;
        Arrays.fill(nums, i, i + twoCnt, 2);
    }
}
