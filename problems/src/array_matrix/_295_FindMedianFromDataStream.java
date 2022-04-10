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
                if (leftQueue.isEmpty() || num <= rightQueue.peek()) {
                    leftQueue.add(num);
                } else {
                    int rPeek = rightQueue.poll();
                    rightQueue.add(num);
                    leftQueue.add(rPeek);
                }
            } else {
                if (num <= leftQueue.peek()) {
                    int lPeek = leftQueue.poll();
                    leftQueue.add(num);
                    rightQueue.add(lPeek);
                } else {
                    rightQueue.add(num);
                }
            }
        }

        public double findMedian() {
            if (!leftQueue.isEmpty() && leftQueue.size() == rightQueue.size()) {
                int lPeek = leftQueue.peek();
                int rPeek = rightQueue.peek();
                return (lPeek + rPeek) / 2.0;
            } else {
                return leftQueue.peek();
            }
        }
    }
}
