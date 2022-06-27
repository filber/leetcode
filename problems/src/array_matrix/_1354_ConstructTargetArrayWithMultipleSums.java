package array_matrix;

//https://leetcode.com/problems/construct-target-array-with-multiple-sums/

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1354_ConstructTargetArrayWithMultipleSums {

    public boolean isPossible(int[] A) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (long val : A) {
            sum += val;
            pq.add(val);
        }
        while (!pq.isEmpty()) {
            long max = pq.poll();
            long other = sum - max;
            if (other == 1 || max == 1) {
                return true;
            }
            if (max < other || other == 0 || max % other == 0) {
                return false;
            }
            long pre = max % other;
            pq.add(pre);
            sum = pre + other;
        }
        return true;
    }
}
