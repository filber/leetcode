package pq;

//https://leetcode.com/problems/find-median-from-data-stream/

import java.util.Collections;
import java.util.PriorityQueue;

public class _295_FindMedianFromDataStream {

    public static class MedianFinder {
        PriorityQueue<Integer> first = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> second = new PriorityQueue<>();

        public MedianFinder() {
        }

        public void addNum(int num) {
            first.add(num);
            second.add(first.poll());
            if (first.size() < second.size() - 1) {
                first.add(second.poll());
            }
        }

        public double findMedian() {
            if (first.size() == second.size()) {
                return (first.peek() + second.peek()) / 2.0;
            } else {
                return second.peek();
            }
        }
    }
}
