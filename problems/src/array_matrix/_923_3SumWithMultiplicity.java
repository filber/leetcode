package array_matrix;

//https://leetcode.com/problems/3sum-with-multiplicity/

import java.util.ArrayList;
import java.util.List;

public class _923_3SumWithMultiplicity {

    int modulo = (int) 1e9 + 7;

    public int threeSumMulti(int[] arr, int target) {
        int[] bucket = new int[101];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = 0;
        for (int num : arr) {
            if (bucket[num] == 0) {
                n++;
            }
            bucket[num]++;
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        long[][] count = new long[n][2];
        int idx = 0;
        for (int i = min; i <= max; i++) {
            if (bucket[i] != 0) {
                count[idx][0] = i;
                count[idx][1] = bucket[i];
                idx++;
            }
        }

        long ans = 0;
        int modulo = (int) 1e9 + 7;
        for (int i = 0; i < count.length; i++) {
            // choose 1 Ni
            ans = (ans + count[i][1] * search(count, i + 1, count.length - 1, target - count[i][0])) % modulo;

            if (count[i][1] >= 2) {
                int residue = (int) (target - 2 * count[i][0]);
                if (residue > count[i][0] && residue <= max) {
                    long cnt = (count[i][1] * (count[i][1] - 1) / 2) % modulo;
                    cnt = (cnt * bucket[residue]) % modulo;
                    ans = (cnt + ans) % modulo;
                }
            }

            if (count[i][1] >= 3 && count[i][0] * 3 == target) {
                long cnt = (count[i][1] * (count[i][1] - 1) / 2) % modulo;
                cnt = (cnt * (count[i][1] - 2) / 3) % modulo;
                ans = (ans + cnt) % modulo;
            }
        }

        return (int) ans;
    }

    private long search(long[][] count, int l, int r, long target) {
        if (l > r) {
            return 0;
        }
        long ans = 0;
        while (l < r) {
            long sum = count[l][0] + count[r][0];
            if (sum == target) {
                long cnt = (count[l][1] * count[r][1]) % modulo;
                ans = (ans + cnt) % modulo;
                l++;
                r--;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        if (l == r && 2 * count[l][0] == target) {
            long cnt = (count[l][1] * (count[l][1] - 1) / 2) % modulo;
            ans = (ans + cnt) % modulo;
        }

        return ans;
    }
}
