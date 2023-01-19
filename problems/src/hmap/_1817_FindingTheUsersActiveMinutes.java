package hmap;

//https://leetcode.com/problems/finding-the-users-active-minutes/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1817_FindingTheUsersActiveMinutes {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userMap = new HashMap<>();
        Map<Integer, Integer> activeMap = new HashMap<>();
        int[] uam = new int[k];
        for (int[] log : logs) {
            int user = log[0];
            int minute = log[1];
            Set<Integer> set = userMap.computeIfAbsent(user, (K) -> new HashSet<>());
            set.add(minute);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : userMap.entrySet()) {
            int sz = entry.getValue().size();
            int count = activeMap.getOrDefault(sz, 0);
            activeMap.put(sz, count + 1);
        }
        for (int i = 1; i <= k; i++) {
            uam[i - 1] = activeMap.getOrDefault(i, 0);
        }
        return uam;
    }
}
