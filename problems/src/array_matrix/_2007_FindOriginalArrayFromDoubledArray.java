package array_matrix;

//https://leetcode.com/problems/find-original-array-from-doubled-array/

import java.util.Arrays;

public class _2007_FindOriginalArrayFromDoubledArray {

    public int[] findOriginalArray(int[] changed) {
        if (changed == null || changed.length % 2 == 1)
            return new int[0];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : changed) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int[] count = new int[max - min + 1];
        for (int i : changed) {
            count[i - min]++;
        }
        int[] result = new int[changed.length / 2];
        int index = 0;

        if (min == 0) {
            if (count[0] % 2 == 1) {
                return new int[0];
            } else {
                Arrays.fill(result, index, index + count[0] / 2, 0);
                index += count[0] / 2;
                count[0] = 0;
            }
        }

        for (int i = min; i <= max; i++) {
            int cnt = count[i - min];
            if (cnt > 0) {
                if ((2 * i) > max || count[2 * i - min] == 0 || count[2 * i - min] < cnt) {
                    return new int[0];
                }
                Arrays.fill(result, index, index + cnt, i);
                index += cnt;
                count[2 * i - min] -= cnt;
                count[i - min] = 0;
            }
        }
        return result;
    }
}
