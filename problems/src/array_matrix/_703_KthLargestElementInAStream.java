package array_matrix;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.Arrays;
import java.util.PriorityQueue;

public class _703_KthLargestElementInAStream {

    public static class KthLargest {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < k && i < n; i++) {
                queue.add(nums[n - 1 - i]);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.add(val);
                return queue.peek();
            }

            int peek = queue.peek();
            if (val <= peek) {
                return peek;
            } else {
                queue.poll();
                queue.add(val);
                return queue.peek();
            }
        }
    }
}
