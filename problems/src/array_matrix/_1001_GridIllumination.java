package array_matrix;

//https://leetcode.com/problems/grid-illumination/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1001_GridIllumination {

    private Map<Integer, Set<Integer>> lampsPos = new HashMap<>();
    private Map<Integer, Integer> row = new HashMap<>(); // i
    private Map<Integer, Integer> col = new HashMap<>(); // j
    private Map<Integer, Integer> slash = new HashMap<>(); // i+j
    private Map<Integer, Integer> backslash = new HashMap<>(); // j-i

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        for (int i = 0; i < lamps.length; i++) {
            int[] lamp = lamps[i];
            int R = lamp[0];
            int C = lamp[1];
            Set<Integer> set = lampsPos.get(R);
            if (set == null) {
                set = new HashSet<>();
                lampsPos.put(R, set);
            }

            // skip duplicate lamps
            if (!set.contains(C)) {
                set.add(C);
                row.put(R, row.getOrDefault(R, 0) + 1);
                col.put(C, col.getOrDefault(C, 0) + 1);
                slash.put(R + C, slash.getOrDefault(R + C, 0) + 1);
                backslash.put(C - R, backslash.getOrDefault(C - R, 0) + 1);
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int R = query[0];
            int C = query[1];
            if (row.getOrDefault(R, 0) > 0 ||
                    col.getOrDefault(C, 0) > 0 ||
                    slash.getOrDefault(R + C, 0) > 0 ||
                    backslash.getOrDefault(C - R, 0) > 0) {
                ans[i] = 1;
            }

            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    int nR = R + j;
                    int nC = C + k;
                    Set<Integer> set = lampsPos.get(nR);
                    if (set != null && set.contains(nC)) {
                        // found lamp!
                        set.remove(nC); // remove lamp
                        row.put(nR, row.getOrDefault(nR, 1) - 1);
                        col.put(nC, col.getOrDefault(nC, 1) - 1);
                        slash.put(nR + nC, slash.getOrDefault(nR + nC, 1) - 1);
                        backslash.put(nC - nR, backslash.getOrDefault(nC - nR, 1) - 1);
                    }
                }
            }
        }

        return ans;
    }
}
