package array_matrix;

//https://leetcode.com/problems/find-median-from-data-stream/

import java.util.Collections;
import java.util.PriorityQueue;

public class _295_FindMedianFromDataStream {

    public static class MedianFinder {

        private PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
        private PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

        public MedianFinder() {
        }

        public void addNum(int num) {
            if (leftQueue.size() == rightQueue.size()) {
                rightQueue.add(num);
                leftQueue.add(rightQueue.poll());
            } else {
                leftQueue.add(num);
                rightQueue.add(leftQueue.poll());
            }
        }

        public double findMedian() {
            if (leftQueue.size() == rightQueue.size()) {
                return ((double) leftQueue.peek() + rightQueue.peek()) / 2.0;
            } else {
                return (double) leftQueue.peek();
            }
        }
    }
}
