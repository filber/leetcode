package array_matrix;

// https://leetcode.com/problems/reduce-array-size-to-the-half/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1338_ReduceArraySizeToTheHalf {

    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            int cnt = map.getOrDefault(val, 0);
            map.put(val, cnt + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(map.values());
        int size = 0;
        int deletions = 0;
        while (deletions < n / 2 && !queue.isEmpty()) {
            int cnt = queue.poll();
            size += 1;
            deletions += cnt;
        }
        return size;
    }
}
