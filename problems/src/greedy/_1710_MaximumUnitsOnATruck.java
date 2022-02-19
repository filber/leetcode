package greedy;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-units-on-a-truck/

public class _1710_MaximumUnitsOnATruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int n = boxTypes.length;
        int units = 0;

        for (int i = 0; i < n && truckSize>0; i++) {
            if (boxTypes[i][0] >= truckSize) {
                units += boxTypes[i][1] * truckSize;
                truckSize = 0;
            } else {
                units += boxTypes[i][1] * boxTypes[i][0];
                truckSize -= boxTypes[i][0];
            }
        }

        return units;
    }
}
