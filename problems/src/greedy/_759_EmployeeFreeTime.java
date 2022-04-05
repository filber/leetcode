package greedy;

//https://leetcode.com/problems/employee-free-time/

import java.util.ArrayList;
import java.util.List;

public class _759_EmployeeFreeTime {

//    We are given a list schedule of employees, which represents the working time for each employee.
//    Each employee has a list of non-overlapping Intervals,
//    and these intervals are in sorted order.
//    Return the list of finite intervals representing common,
//    positive-length free time for all employees, also in sorted order.

//    Constraints:
//    schedule and schedule[i] are lists with lengths in range [1, 50].
//    0 <= schedule[i].start < schedule[i].end <= 10^8.

    int[][][] schedule;

    public int[][] employeeFreeTime(int[][][] schedule) {
        this.schedule = schedule;
        int[][] slots = merge(0, schedule.length - 1);
        int n = slots.length;

        List<int[]> ans = new ArrayList<>();
        int end = slots[0][1];
        for (int j = 1; j < n; j++) {
            if (end < slots[j][0]) {
                ans.add(new int[]{slots[j - 1][1], slots[j][0]});
            }
            end = Math.max(end, slots[j][1]);
        }
        return ans.toArray(new int[0][]);
    }

    private int[][] merge(int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return schedule[l];
        } else {
            int mid = (l + r) / 2;
            int[][] left = merge(l, mid);
            int[][] right = merge(mid + 1, r);
            int m = left.length, n = right.length;
            int i = 0, j = 0;
            int[][] ans = new int[m + n][];
            int idx = 0;
            while (i < m && j < n) {
                if (left[i][0] == right[j][0]) {
                    if (left[i][1] <= right[j][1]) {
                        ans[idx++] = left[i++];
                    } else {
                        ans[idx++] = right[j++];
                    }
                } else if (left[i][0] < right[j][0]) {
                    ans[idx++] = left[i++];
                } else {
                    ans[idx++] = right[j++];
                }
            }
            while (i < m) {
                ans[idx++] = left[i++];
            }

            while (j < n) {
                ans[idx++] = right[j++];
            }
            return ans;
        }
    }
}
