package bit_manip;

import java.util.BitSet;

// https://leetcode.com/problems/merge-intervals/
//[Bit Manipulation]
// TIPS: Using bit set to handle overlapping numbers
public class _56_MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0] * 2;
            int end = intervals[i][1] * 2 + 1;
            bitSet.set(start, end);
        }

        int start = 0;
        int end = 0;
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

    public static void main(String[] args) {
        int[][] m6 = new int[][]{{1, 4}, {0, 4}};
        m6 = merge(m6);

        int[][] m1 = new int[][]{{1, 2}};
        m1 = merge(m1);

        int[][] m2 = new int[][]{{1, 3}, {4, 5}};
        m2 = merge(m2);

        int[][] m3 = new int[][]{{1, 4}, {4, 5}};
        m3 = merge(m3);

        int[][] m4 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        m4 = merge(m4);

        int[][] m5 = new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        m5 = merge(m5);
    }
}
