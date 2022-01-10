package dp;

import java.util.*;

//https://leetcode.com/problems/frog-jump/
public class _403_FrogJump {

    public static boolean canCrossMap(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }

    public static boolean canCross(int[] stones) {
        if (stones.length == 1) {
            return true;
        }
        if (stones[1] - stones[0] != 1) {
            return false;
        }
        int len = stones.length;
        Map<Integer, Boolean>[] map = new Map[len];
        Arrays.setAll(map, ele -> new HashMap<>());

        return dfs(map, stones, len, 1, 1);
    }

    private static boolean dfs(Map<Integer, Boolean>[] map, int[] stones, int len, int idx, int k) {
        if (idx == len - 1) {
            return true;
        }
        if (idx >= len) {
            return false;
        }
        Map<Integer, Boolean> tmp = map[idx];
        Boolean res = tmp.get(k);
        // memory
        if (res != null) {
            return res;
        }
        for (int i = idx + 1; i < len; i++) {
            int dis = stones[i] - stones[idx];
            if (dis > k + 1) {
                // cannot jump through
                break;
            }
            if (dis == k - 1 || dis == k || dis == k + 1) {
                if (dfs(map, stones, len, i, dis)) {
                    // set memory
                    tmp.put(k, true);
                    return true;
                }
            }
        }
        // set memory
        tmp.put(k, false);
        return false;
    }

    public static void main(String[] args) {
        boolean c1 = canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
        boolean c2 = canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11});
        boolean c3 = canCross(new int[]{0, 1, 3, 4, 5, 7, 9, 10, 12});
        boolean c4 = canCross(new int[]{0, 2});
        boolean c5 = canCross(new int[]{0,1,2,5,6,9,10,12,13,14,17,19,20,21,26,27,28,29,30});
    }
}
