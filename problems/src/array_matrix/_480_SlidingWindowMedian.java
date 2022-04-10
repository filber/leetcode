package array_matrix;

import java.util.TreeSet;

public class _480_SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        TreeSet<Integer> minHeap = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b);
        TreeSet<Integer> maxHeap = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[b], nums[a]) : b - a);
        for (int i = 0; i < k; i++) {
            maxHeap.add(i);
        }
        for (int i = 0; i < k / 2; i++) {
            minHeap.add(maxHeap.pollFirst());
        }
        result[0] = getMedian(nums, maxHeap, minHeap);
        for (int i = k; i < n; i++) {
            if (!minHeap.remove(i - k)) {
                maxHeap.remove(i - k);
            }
            minHeap.add(i);
            maxHeap.add(minHeap.pollFirst());
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.pollFirst());
            }
            result[i - k + 1] = getMedian(nums, maxHeap, minHeap);
        }
        return result;
    }

    private double getMedian(int[] nums, TreeSet<Integer> maxHeap, TreeSet<Integer> minHeap) {
        if (maxHeap.size() > minHeap.size()) {
            return (double) nums[maxHeap.first()];
        } else {
            return ((double) nums[maxHeap.first()] + nums[minHeap.first()]) / 2;
        }
    }
}
