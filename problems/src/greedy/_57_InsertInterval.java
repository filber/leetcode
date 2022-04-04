package greedy;

//https://leetcode.com/problems/insert-interval/

import list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _57_InsertInterval {

    int[][] intervals;

    public int[][] insertDQ(int[][] intervals, int[] newInterval) {
        this.intervals = intervals;
        int n = intervals.length;
        if (n == 0) {
            return new int[][]{newInterval};
        }
        int[] firstR = intervals[0];
        int[] lastR = intervals[n - 1];
        int S = newInterval[0], E = newInterval[1];
        int[][] ans = null;
        if (E < firstR[0]) {
            ans = new int[n + 1][2];
            ans[0][0] = S;
            ans[0][1] = E;
            fill(ans, 1, intervals, 0, n);
        } else if (lastR[1] < S) {
            ans = new int[n + 1][2];
            fill(ans, 0, intervals, 0, n);
            ans[n][0] = S;
            ans[n][1] = E;
        } else if (S <= firstR[0] && lastR[1] <= E) {
            ans = new int[][]{{S, E}};
        } else if (S <= firstR[0]) {
            int[] interval = search(E, 0, n - 1);
            int L = interval[0];

            ans = new int[n - L][2];
            fill(ans, 1, intervals, L + 1, n - L - 1);
            ans[0][0] = S;
            ans[0][1] = Math.max(intervals[L][1], E);
        } else if (lastR[1] <= E) {
            int[] interval = search(S, 0, n - 1);
            int R = interval[1];
            ans = new int[R + 1][2];
            fill(ans, 0, intervals, 0, R);
            ans[R][0] = Math.min(S, intervals[R][0]);
            ans[R][1] = E;
        } else {
            int[] sInter = search(S, 0, n - 1);
            int rS = sInter[1];
            int[] eInter = search(E, 0, n - 1);
            int lE = eInter[0];

            ans = new int[rS + n - lE][2];
            fill(ans, 0, intervals, 0, rS);
            ans[rS][0] = Math.min(S, intervals[rS][0]);
            ans[rS][1] = Math.max(E, intervals[lE][1]);
            fill(ans, rS + 1, intervals, lE + 1, n - lE - 1);
        }
        return ans;
    }

    private void fill(int[][] target, int tS, int[][] from, int fS, int len) {
        for (int i = 0; i < len; i++) {
            target[tS + i] = from[fS + i];
        }
    }

    public int[] search(int val, int l, int r) {
        if (l == r) {
            int[] range = intervals[l];
            if (range[0] <= val && val <= range[1]) {
                return new int[]{l, l};
            } else if (val < range[0]) {
                return new int[]{l - 1, l};
            } else {
                return new int[]{l, l + 1};
            }
        } else {
            int m = (l + r) / 2;
            int[] range = intervals[m];
            if (range[0] <= val && val <= range[1]) {
                return new int[]{m, m};
            } else if (val < range[0]) {
                return search(val, Math.min(l, m - 1), m - 1);
            } else {
                return search(val, m + 1, Math.max(r, m + 1));
            }
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        int S = newInterval[0], E = newInterval[1];
        while (i < n && intervals[i][1] < S) {
            list.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= E) {
            S = Math.min(S, intervals[i][0]);
            E = Math.max(E, intervals[i][1]);
            i++;
        }
        list.add(new int[]{S, E});

        while (i < n) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][2]);
    }
}
