package greedy;

//https://www.geeksforgeeks.org/maximum-distinct-elements-removing-k-elements/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _EX_MaximumDistinctElementsAfterRemovingKElements {

    public int maxDistinctNum(int arr[], int k) {
        if (arr.length == k) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        int distinctCnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                distinctCnt++;
            } else {
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        while (!priorityQueue.isEmpty() && k > 0) {
            int[] peek = priorityQueue.poll();
            k--;
            peek[1]--;
            if (peek[1] == 1) {
                distinctCnt++;
            } else {
                priorityQueue.add(peek);
            }
        }

        if (priorityQueue.isEmpty()) {
            distinctCnt -= k;
        }
        return distinctCnt;
    }
}
