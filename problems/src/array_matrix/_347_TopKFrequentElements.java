package array_matrix;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/
public class _347_TopKFrequentElements {
    public static class Tuple {
        int val;
        int cnt;

        Tuple(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    public static class TopKFComparator implements Comparator<Tuple> {
        @Override
        public int compare(Tuple o1, Tuple o2) {
            return Integer.compare(o2.cnt, o1.cnt);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // 1. Counting frequencies
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                int cnt = hashMap.get(nums[i]).intValue();
                hashMap.put(nums[i], cnt + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        // 2. Add tuples to PriorityQueue
        PriorityQueue<Tuple> priorityQueue =
                new PriorityQueue<>(hashMap.keySet().size(),
                        new TopKFComparator());
        for (int key : hashMap.keySet()) {
            int cnt = hashMap.get(key);
            priorityQueue.add(new Tuple(key, cnt));
        }

        // 3. Pop K elements from PQ
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Tuple top = priorityQueue.poll();
            result[i] = top.val;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] r1 = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);

        int[] r2 = topKFrequent(new int[]{1}, 1);

        int[] r3 = topKFrequent(new int[]{1, 1, 2, 2, 3}, 2);
    }
}
