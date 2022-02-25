package array_matrix;

//https://leetcode.com/problems/grid-illumination/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1001_GridIllumination {

    Set<Integer> lampsSet = new HashSet<>();
    Map<Integer, Integer> row = new HashMap<>();
    Map<Integer, Integer> col = new HashMap<>();
    Map<Integer, Integer> slash = new HashMap<>();
    Map<Integer, Integer> backslash = new HashMap<>();

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        for (int i = 0; i < lamps.length; i++) {
            // store to lamps map
            int r = lamps[i][0];
            int c = lamps[i][1];

            int pos = r * n + c;
            if (!lampsSet.contains(pos)) {
                lampsSet.add(pos);

                // illuminate grid
                row.put(r, row.getOrDefault(r, 0) + 1);
                col.put(c, col.getOrDefault(c, 0) + 1);
                slash.put(r + c, slash.getOrDefault(r + c, 0) + 1);
                backslash.put(c - r, backslash.getOrDefault(c - r, 0) + 1);
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];
            // check if illuminated
            if (row.getOrDefault(r, 0) > 0 ||
                    col.getOrDefault(c, 0) > 0 ||
                    slash.getOrDefault(r + c, 0) > 0 ||
                    backslash.getOrDefault(c - r, 0) > 0
            ) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }

            // turn off lights
            for (int k = -1; k <= 1; k++) {
                for (int m = -1; m <= 1; m++) {
                    int lightR = r + k;
                    int lightC = c + m;
                    int pos = lightR * n + lightC;
                    if (lightR >= 0 && lightR < n && lightC >= 0 && lightC < n && lampsSet.contains(pos)) {
                        // turn off lights
                        row.put(lightR, row.getOrDefault(lightR, 1) - 1);
                        col.put(lightC, col.getOrDefault(lightC, 1) - 1);
                        slash.put(lightR + lightC, slash.getOrDefault(lightR + lightC, 1) - 1);
                        backslash.put(lightC - lightR, backslash.getOrDefault(lightC - lightR, 1) - 1);
                        // remove lamps
                        lampsSet.remove(pos);
                    }
                }
            }
        }

        return ans;
    }
}
