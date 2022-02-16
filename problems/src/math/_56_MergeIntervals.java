package math;

import java.util.Arrays;
import java.util.BitSet;

// https://leetcode.com/problems/merge-intervals/
// TIPS: Using bit set to handle overlapping numbers
public class _56_MergeIntervals {

    //    Constraints:
//        1 <= intervals.length <= 10^4
//        intervals[i].length == 2
//        0 <= starti <= endi <= 10^4
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        // sort by beginning
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0], end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int[] inter = intervals[i];
            if (inter[0] <= end) {
                // merge
                end = Math.max(end, inter[1]);
            } else {
                intervals[count-1][0] = start;
                intervals[count-1][1] = end;
                start = inter[0];
                end = inter[1];
                count++;
            }
        }

        intervals[count-1][0] = start;
        intervals[count-1][1] = end;

        int[][] ans = new int[count][2];
        for (int i = 0; i < count; i++) {
            ans[i] = intervals[i];
        }
        return ans;
    }

    public static int[][] mergeBitSet(int[][] intervals) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0] * 2;
            int end = intervals[i][1] * 2 + 1;
            bitSet.set(start, end);
        }

        int start;
        int end;
        int count = 0;
        for (start = bitSet.nextSetBit(0);
             start > -1;
             start = bitSet.nextSetBit(end)) {
            end = bitSet.nextClearBit(start);
            intervals[count][0] = start / 2;
            intervals[count][1] = (end - 1) / 2;
            count++;
        }

        int[][] result = new int[count][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = intervals[i];
        }
        return result;
    }

}
