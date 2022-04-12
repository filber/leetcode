package array_matrix;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.PriorityQueue;

public class _703_KthLargestElementInAStream {

    public static class KthLargest {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                queue.add(num);
            }
            while (queue.size() > k) {
                queue.poll();
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.add(val);
            } else if (val <= queue.peek()) {
                // ignore val
            } else {
                queue.add(val);
                queue.poll();
            }
            return queue.peek();
        }
    }
}
