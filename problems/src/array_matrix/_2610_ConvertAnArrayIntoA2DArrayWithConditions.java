package array_matrix;

// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _2610_ConvertAnArrayIntoA2DArrayWithConditions {

    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[][] cnt = new int[n + 1][2];
        for (int num : nums) {
            cnt[num][0] = num;
            cnt[num][1]++;
        }
        Arrays.sort(cnt, Comparator.comparingInt(k -> -k[1]));

        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (cnt[i][1] != 0) {
            for (int j = 0; j < cnt[i][1]; j++) {
                if (result.size() <= j) {
                    result.add(new ArrayList<>());
                }
                result.get(j).add(cnt[i][0]);
            }
            i++;
        }

        return result;
    }
}
