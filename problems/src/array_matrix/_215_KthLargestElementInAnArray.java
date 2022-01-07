package array_matrix;
//https://leetcode.com/problems/kth-largest-element-in-an-array/
import java.util.Comparator;
import java.util.PriorityQueue;

// TIPS: Using Priority Queue
public class _215_KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(-nums[i]);
        }

        int result = priorityQueue.peek();
        for (int i = 0; i < k; i++) {
            result = priorityQueue.poll();
        }
        return -result;
    }

    public static void main(String[] args) {
        // Input: nums = [3,2,1,5,6,4], k = 2
        // Output: 5
        int r1 = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);

        // Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
        // Output: 4
        int r2 = findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);

    }
}
