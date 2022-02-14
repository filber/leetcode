package dp;

import java.util.*;

//https://leetcode.com/problems/frog-jump/
public class _403_FrogJump {

    // Constraints:
//            2 <= stones.length <= 2000
//            0 <= stones[i] <= 2^31 - 1
//            stones[0] == 0
//            stones is sorted in a strictly increasing order.
    private int[] stones;
    private int n;
    private Map<Integer, Integer> stonesMap;
    private Set<Integer>[] mem;

    public boolean canCross(int[] stones) {
        this.stones = stones;
        n = stones.length;
        stonesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            stonesMap.put(stones[i], i);
        }
        mem = new Set[n];
        for (int i = 0; i < n; i++) {
            mem[i] = new HashSet<>();
            mem[i].add(0);
        }

        boolean res = dfs(1, 1);
        return res;
    }

    private boolean dfs(int i, int k) {
        if (i == stones[n - 1]) {
            // reach the target
            return true;
        }
        Integer idx = stonesMap.get(i);
        if (idx == null) {
            // stone i doesn't exist, can not jump to this position
            return false;
        } else if (mem[idx].contains(k)) {
            // already tried this position&k
            return false;
        }

        for (int diff = -1; diff <= 1; diff++) {
            int nextK = k + diff;
            int nextPos = i + nextK;
            if (dfs(nextPos, nextK)) {
                return true;
            }
        }

        mem[idx].add(k);
        return false;
    }
}
