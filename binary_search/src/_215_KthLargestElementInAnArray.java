import java.util.Comparator;
import java.util.PriorityQueue;

public class _215_KthLargestElementInAnArray {

    public static class ElementComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return Integer.compare(second,first);
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new ElementComparator());
        for (int num : nums) {
            priorityQueue.add(num);
        }
        int result = 0;

        for (int i = 0; i < k; i++) {
            result = priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
//        Input: nums = [3,2,1,5,6,4], k = 2
//        Output: 5
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

//        Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//        Output: 4
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

    }
}
