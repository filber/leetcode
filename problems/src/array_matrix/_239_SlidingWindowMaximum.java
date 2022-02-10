package array_matrix;

//https://leetcode.com/problems/sliding-window-maximum/

import java.util.Deque;
import java.util.LinkedList;

public class _239_SlidingWindowMaximum {

    // You can only see the k numbers in the window.
    // Return the max sliding window.
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> idxDeque = new LinkedList();

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

    private static void updateDeque(Deque<Integer> idxDeque,int[] nums, int i, int j) {
        if (idxDeque.isEmpty() || nums[j] >= nums[idxDeque.getFirst()]) {
            idxDeque.addFirst(j);
        } else if (nums[j] <= nums[idxDeque.getLast()]){
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
        //
        int[] m4 = maxSlidingWindow(new int[]{7,2,4}, 2);
    }
}
