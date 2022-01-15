package bfs;

// https://leetcode.com/problems/jump-game-iv/

import java.util.*;

//[Breadth-First Search]
public class _1345_JumpGameIV {

//    Given an array of integers arr, you are initially positioned at the first index of the array.
//    In one step you can jump from index i to index:
//            i + 1 where: i + 1 < arr.length.
//            i - 1 where: i - 1 >= 0.
//            j where: arr[i] == arr[j] and i != j.
//    Return the minimum number of steps to reach the last index of the array.

    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n==1) {
            return 0;
        }
        boolean[] visited = new boolean[n];
        Map<Integer, Boolean> valVisited = new HashMap<>();

        Map<Integer, Set<Integer>> valMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            Set<Integer> set = valMap.get(num);
            if (set == null) {
                set = new HashSet<>();
                valMap.put(num,set);
            }
            set.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int level = 0;
        int levelCnt = 1;
        int tempCnt = 0;

        while (!queue.isEmpty()) {
            int elem = queue.poll();
            if (elem == n-1) {
                break;
            }
            levelCnt--;
            visited[elem] = true;
            // search left
            if (elem > 0 && !visited[elem - 1]) {
                queue.add(elem - 1);
                visited[elem - 1] = true;
                tempCnt++;
            }
            // search right
            if (elem < n - 1 && !visited[elem + 1]) {
                queue.add(elem + 1);
                visited[elem + 1] = true;
                tempCnt++;
            }
            // search elements of the same value
            if (valVisited.get(arr[elem]) == null) {
                for (int neighbor : valMap.get(arr[elem])) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                        tempCnt++;
                    }
                }
                valVisited.put(arr[elem], true);
            }

            if (levelCnt == 0) {
                level++;
                levelCnt = tempCnt;
                tempCnt = 0;
            }
        }

        return level;
    }

    public static void main(String[] args) {
        // 0
        int m2 = minJumps(new int[]{7});

        // 1 - [0-->7]
        int m3 = minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7});

        // 3 - [0-->4-->3-->9]
        int m1 = minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});


        // 2 - [0-->n-2-->n-1]
        int m4 = minJumps(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 11});
    }
}
