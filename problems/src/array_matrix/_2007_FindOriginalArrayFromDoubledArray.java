package array_matrix;

//https://leetcode.com/problems/find-original-array-from-doubled-array/

import java.util.Arrays;

public class _2007_FindOriginalArrayFromDoubledArray {

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) {
            return new int[0];
        }
        Arrays.sort(changed);
        int[] map = new int[100001];
        for (int val : changed) {
            map[val] += 1;
        }

        int m = n / 2;
        int[] ans = new int[m];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int val = changed[i];
            if (map[val] > 0) {
                map[val] -= 1;
                if (map[2 * val] > 0) {
                    map[2 * val] -= 1;
                    ans[len++] = val;
                } else {
                    return new int[0];
                }
            }
            if (len == m) {
                break;
            }
        }

        return ans;
    }
}
