package array_matrix;

// https://leetcode.com/problems/reduce-array-size-to-the-half/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1338_ReduceArraySizeToTheHalf {

    public static int minSetSize(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (int val : map.values()) {
            priorityQueue.add(val);
        }

        int n = arr.length;
        int deleteCnt = 0;
        int setSize = 0;
        while (deleteCnt < n / 2) {
            deleteCnt += priorityQueue.poll();
            setSize++;
        }
        return setSize;
    }

    public static void main(String[] args) {

        // Output: 1
        int m1 = minSetSize(new int[]{1000, 1000, 3, 7});

        // Output: 2
        int m2 = minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7});

        // Output: 1
        int m3 = minSetSize(new int[]{7, 7, 7, 7, 7, 7});

        // Output: 1
        int m4 = minSetSize(new int[]{1, 9});


        // Output: 5
        int m5 = minSetSize(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }
}
