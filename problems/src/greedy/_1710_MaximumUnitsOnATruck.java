package greedy;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-units-on-a-truck/

public class _1710_MaximumUnitsOnATruck {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int n = boxTypes.length;
        int max = 0;
        int remain = truckSize;
        for (int i = 0; i < n && remain > 0; i++) {
            if (boxTypes[i][0] <= remain) {
                max += boxTypes[i][0] * boxTypes[i][1];
                remain -= boxTypes[i][0];
            } else {
                max += boxTypes[i][1] * remain;
                remain = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // 1*[3] + 2*[2] + 1*[1]
        // 8
        int m1 = maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4);

        // 5*[10] + 3*[9] + 2*[7]
        // 91
        int m2 = maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10);

    }
}
