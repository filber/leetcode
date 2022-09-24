package array_matrix;

//https://leetcode.com/problems/sliding-window-maximum/

import java.util.Deque;
import java.util.LinkedList;

public class _239_SlidingWindowMaximum {

    // You can only see the k numbers in the window.
    // Return the max sliding window.

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] rst = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        if (!deque.isEmpty()) {
            rst[0] = nums[deque.peekFirst()];
        }
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && (i - deque.peekFirst()) >= k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (!deque.isEmpty()) {
                rst[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return rst;
    }
}
