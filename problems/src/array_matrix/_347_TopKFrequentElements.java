package array_matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/
public class _347_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] pair = new int[2];
            pair[0] = entry.getKey();
            pair[1] = entry.getValue();
            queue.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
