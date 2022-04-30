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

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int distinctCnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                distinctCnt++;
            } else {
                priorityQueue.add(entry.getValue());
            }
        }

        while (!priorityQueue.isEmpty() && k > 0) {
            int peek = priorityQueue.poll();
            if (peek == k + 1) {
                k = 0;
                distinctCnt++;
            } else if (k < peek) {
                k = 0;
            } else {
                k -= (peek - 1);
                distinctCnt++;
            }
        }

        return distinctCnt - k;
    }
}
