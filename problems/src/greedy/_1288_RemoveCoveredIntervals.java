package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class _1288_RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int cnt = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0]==b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        int maxRight = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] <= maxRight) {
                cnt--;
            } else {
                maxRight = intervals[i][1];
            }
        }
        return cnt;
    }
}
