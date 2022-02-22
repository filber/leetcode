package bfs;

// https://leetcode.com/problems/jump-game-iv/

import java.util.*;

public class _1345_JumpGameIV {

    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        if (arr[0] == arr[n - 1] || arr.length == 2)
            return 1;
        if (arr[0] == arr[n - 2])
            return 2;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Boolean> valVisited = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.computeIfAbsent(arr[i], k -> new ArrayList<>());
            list.add(i);
        }

        queue.add(0);
        visited[0] = true;
        int curLevelCnt = 1;
        int nextLevelCnt = 0;
        int jumps = 0;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            if (idx == n - 1) {
                return jumps;
            }
            curLevelCnt--;

            int left = idx - 1;
            if (left >= 0 && !visited[left]) {
                queue.add(left);
                visited[left] = true;
                nextLevelCnt++;
            }
            int right = idx + 1;
            if (right < n && !visited[right]) {
                queue.add(right);
                visited[right] = true;
                nextLevelCnt++;
            }

            // search elements of the same value
            if (!valVisited.containsKey(arr[idx])) {
                List<Integer> list = map.get(arr[idx]);
                for (int i : list) {
                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                        nextLevelCnt++;
                    }
                }
                valVisited.put(arr[idx], true);
            }

            if (curLevelCnt == 0) {
                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
                jumps++;
            }
        }

        return jumps;
    }
}
