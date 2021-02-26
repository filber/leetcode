import java.util.Comparator;
import java.util.PriorityQueue;

public class _215_KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.poll();
    }
}
