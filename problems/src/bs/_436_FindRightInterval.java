package bs;

//https://leetcode.com/problems/find-right-interval/

import java.util.Arrays;

public class _436_FindRightInterval {

    int[][] starts;

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = i;
            starts[i][1] = intervals[i][0];
        }

        Arrays.sort(starts, (a, b) -> a[1] - b[1]);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = starts[i][0];
            if (intervals[idx][0] == intervals[idx][1]) {
                ans[idx] = i;
            } else {
                ans[idx] = search(intervals[idx][1], i + 1, n - 1);
            }
        }
        return ans;
    }

    private int search(int val, int l, int r) {
        if (l > r) {
            return -1;
        } else if (l == r) {
            if (val <= starts[l][1]) {
                return starts[l][0];
            } else {
                return -1;
            }
        } else {
            int mid = (l + r) / 2;
            if (val <= starts[mid][1]) {
                return search(val, l, mid);
            } else {
                return search(val, mid + 1, r);
            }
        }
    }
}
