package greedy;

import java.util.Arrays;
import java.util.BitSet;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class _452_MinimumNumberOfArrowsToBurstBalloons {

    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        int axis = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > axis) {
                cnt++;
                axis = points[i][1];
            } else {
                //do nothing
                // this balloon can be shot by shooting axis
            }
        }
        return cnt;
    }

    public static int findMinArrowShotsBitSet(int[][] points) {
        BitSet bitSet = new BitSet();
        int cnt = 0;
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            int start = p[0] == Integer.MIN_VALUE ? p[0] : 2 * p[0];
            int end = p[1] == Integer.MAX_VALUE ? p[1] : 2 * p[1] + 1;
            if (!bitSet.get(start) && !bitSet.get(end)) {
                cnt++;
                bitSet.set(start, end);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int m1 = findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}); // 2
        int m2 = findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}); // 4
        int m3 = findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}); // 2
        int m4 = findMinArrowShots(new int[][]{{1, 2}}); // 1
        int m5 = findMinArrowShots(new int[][]{{2, 3}, {2, 3}}); // 1
        int m6 = findMinArrowShots(new int[][]{{1, 2147483647}}); // 1
        int m7 = findMinArrowShots(new int[][]{{1, 2}, {4, 5}, {1, 5}}); // 2
        int m8 = findMinArrowShots(new int[][]{{-2147483646,-2147483645}, {2147483646,2147483647}}); // 2
    }
}
