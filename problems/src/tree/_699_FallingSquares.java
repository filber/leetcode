package tree;

//https://leetcode.com/problems/falling-squares/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _699_FallingSquares {

    public List<Integer> fallingSquares(int[][] positions) {
        int[] segments = new int[2 * positions.length];
        for (int i = 0; i < positions.length; i++) {
            int[] pos = positions[i];
            int x = pos[0];
            int len = pos[1];
            segments[2 * i] = x;
            segments[2 * i + 1] = x + len;
        }

        Arrays.sort(segments);
        List<Integer> result = new ArrayList<>();

        int[] slots = new int[2 * positions.length - 1];

        int maxHeight = 0;

        for (int[] pos : positions) {
            int begin = pos[0];
            int len = pos[1];
            int end = begin + len;

            int at = Arrays.binarySearch(segments, begin);
            int max = 0;
            for (int i = at; i < slots.length && segments[i] < end; i++) {
                if (slots[i] > max) {
                    max = slots[i];
                }
            }

            int height = max + len;
            if (height > maxHeight) {
                maxHeight = height;
            }

            result.add(maxHeight);

            for (int i = at; i < slots.length && segments[i] < end; i++) {
                slots[i] = height;
            }
        }
        return result;
    }
}
