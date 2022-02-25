package array_matrix;

//https://leetcode.com/problems/grid-illumination/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1001_GridIllumination {

    Map<Integer, Set<Integer>> lampsMap = new HashMap<>();
    Map<Integer, Integer> row = new HashMap<>();
    Map<Integer, Integer> col = new HashMap<>();
    Map<Integer, Integer> slash = new HashMap<>();
    Map<Integer, Integer> backslash = new HashMap<>();

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        for (int i = 0; i < lamps.length; i++) {
            // store to lamps map
            int r = lamps[i][0];
            int c = lamps[i][1];
            Set<Integer> colSet = lampsMap.get(r);
            if (colSet == null) {
                colSet = new HashSet<>();
                lampsMap.put(r, colSet);
            }

            if (!colSet.contains(c)) {
                colSet.add(c);

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
            if (row.containsKey(r) ||
                    col.containsKey(c) ||
                    slash.containsKey(r + c) ||
                    backslash.containsKey(c - r)
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
                    Set<Integer> set = lampsMap.get(lightR);
                    if (set != null && set.contains(lightC)) {
                        // turn off lights
                        decMap(row, lightR);
                        decMap(col, lightC);
                        decMap(slash, lightR + lightC);
                        decMap(backslash, lightC - lightR);
                        // remove lamps
                        set.remove(lightC);
                    }
                }
            }
        }

        return ans;
    }

    private void decMap(Map<Integer, Integer> map, int key) {
        Integer cnt = map.get(key);
        if (cnt != null && cnt.equals(1)) {
            map.remove(key);
        } else if (cnt != null) {
            map.put(key, cnt - 1);
        }
    }
}
