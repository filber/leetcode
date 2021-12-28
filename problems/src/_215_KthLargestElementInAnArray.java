import java.util.Comparator;
import java.util.PriorityQueue;

// TIPS: Using Priority Queue
public class _215_KthLargestElementInAnArray {

    public static class KComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new KComparator());
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }

        int result = priorityQueue.peek();
        for (int i = 0; i < k; i++) {
            result = priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        // Input: nums = [3,2,1,5,6,4], k = 2
        // Output: 5
        int r1 = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);

        // Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
        // Output: 4
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

    }
}
