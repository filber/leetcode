package tree;

//https://leetcode.com/problems/falling-squares/

import java.util.*;

public class _699_FallingSquares {

    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ans = new ArrayList<>(n);

        // 1. Store all starts and ends into segments
        int[] segments = new int[2 * n];
        for (int i = 0; i < n; i++) {
            int[] pos = positions[i];
            segments[2 * i] = pos[0];
            segments[2 * i + 1] = pos[0] + pos[1];
        }

        // 2. Sort segments
        Arrays.sort(segments);

        // Slots store max heights of each position
        int[] slots = new int[segments.length - 1];
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            int[] pos = positions[i];
            int start = pos[0];
            int len = pos[1];
            int end = start + len;
            int at = Arrays.binarySearch(segments, start);
            int rangeMax = 0;
            // Scan the max height of [start,end)
            for (int j = at; segments[j] < end; j++) {
                if (rangeMax < slots[j]) {
                    rangeMax = slots[j];
                }
            }

            // Update the max height of [start,end)
            int height = rangeMax + len;
            for (int j = at; segments[j] < end; j++) {
                slots[j] = height;
            }

            // Update maxHeight of all range
            if (height > maxHeight) {
                maxHeight = height;
            }
            ans.add(maxHeight);
        }

        return ans;
    }
}
