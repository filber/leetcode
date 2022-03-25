package array_matrix;

//https://leetcode.com/problems/find-original-array-from-doubled-array/

import java.util.Arrays;

public class _2007_FindOriginalArrayFromDoubledArray {

    public int[] findOriginalArray(int[] changed) {
        int[] EMPTY = new int[0];
        // 0. Guard condition
        if (changed.length % 2 == 1) {
            return EMPTY;
        }
        int[] ans = new int[changed.length / 2];
        int len = 0;
        // 1. Find min&max
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int c : changed) {
            if (c < min) {
                min = c;
            }
            if (c > max) {
                max = c;
            }
        }

        // 2. Bucket Sort
        int[] bucket = new int[max - min + 1];
        for (int c : changed) {
            bucket[c - min]++;
        }

        // 3. Handle 0
        if (min == 0) {
            if (bucket[0] % 2 == 1) {
                return EMPTY;
            }
            int cnt = bucket[0] / 2;
            Arrays.fill(ans, len, len + cnt, 0);
            len += cnt;
            bucket[0] = 0;
        }

        for (int i = min; i <= max; i++) {
            int idx = i - min;
            int cnt = bucket[idx];
            if (cnt != 0) {
                int dIdx = 2 * i - min;
                if (dIdx >= bucket.length || bucket[dIdx] < cnt) {
                    return EMPTY;
                } else {
                    Arrays.fill(ans, len, len + cnt, i);
                    len += cnt;
                    bucket[idx] = 0;
                    bucket[dIdx] -= cnt;
                }
            }
        }

        return ans;
    }
}
