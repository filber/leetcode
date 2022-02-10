package array_matrix;

//https://leetcode.com/problems/sliding-window-maximum/

import java.util.ArrayDeque;
import java.util.Deque;

public class _239_SlidingWindowMaximum {

    // You can only see the k numbers in the window.
    // Return the max sliding window.

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = Math.max(nums[i], leftMax[i - 1]);
            }

            int j = n - 1 - i;
            if (j % k == 0) {
                rightMax[j] = nums[j];
            } else {
                rightMax[j] = Math.max(nums[j], rightMax[j + 1]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i + k - 1 < n; i++) {
            ans[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }
        return ans;
    }

    public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> idxDeque = new ArrayDeque<>();

        for (int i = 0; i + k - 1 < n; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    updateDeque(idxDeque, nums, i, j);
                }
            } else {
                int j = i + k - 1;
                updateDeque(idxDeque, nums, i, j);
            }

            while (!idxDeque.isEmpty() && idxDeque.getFirst() < i) {
                idxDeque.pollFirst();
            }

            ans[i] = nums[idxDeque.getFirst()];
        }
        return ans;
    }

    private static void updateDeque(Deque<Integer> idxDeque, int[] nums, int i, int j) {
        if (idxDeque.isEmpty() || nums[j] >= nums[idxDeque.getFirst()]) {
            idxDeque.addFirst(j);
        } else if (nums[j] <= nums[idxDeque.getLast()]) {
            idxDeque.addLast(j);
        } else {
            // Nj > Tail
            while (!idxDeque.isEmpty() && (idxDeque.getLast() < i || nums[j] > nums[idxDeque.getLast()])) {
                idxDeque.pollLast();
            }
            idxDeque.addLast(j);
        }
    }

    public static void main(String[] args) {
        // 3,3,5,5,6,7
        int[] m1 = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        // 3,3,0,5,5,6,7
        int[] m2 = maxSlidingWindow(new int[]{1, 3, -1, 0, -2, 5, 3, 6, 7}, 3);
        // 1
        int[] m3 = maxSlidingWindow(new int[]{1}, 1);
        // 7,4
        int[] m4 = maxSlidingWindow(new int[]{7, 2, 4}, 2);
    }


}
