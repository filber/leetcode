package greedy;

//https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;

public class _435_NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int E = intervals[0][1];
        int deletions = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] inter = intervals[i];
            if (E <= inter[0]) {
                E = inter[1];
            } else {
                deletions++;
                E = Math.min(E, inter[1]);
            }
        }
        return deletions;
    }
}
