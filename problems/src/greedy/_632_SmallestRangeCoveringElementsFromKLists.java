package greedy;

//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

import java.util.List;
import java.util.PriorityQueue;

public class _632_SmallestRangeCoveringElementsFromKLists {

    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() == 1) {
            int val = nums.get(0).get(0);
            return new int[]{val, val};
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int R = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int[] elem = new int[]{nums.get(i).get(0), i, 0};
            pq.add(elem);
            R = Math.max(R, elem[0]);
        }
        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (!pq.isEmpty()) {
            int[] peek = pq.poll();
            int L = peek[0];
            if (R - L < minLen) {
                minLen = R - L;
                start = L;
                end = R;
            }
            peek[2]++;
            if (peek[2] == nums.get(peek[1]).size()) {
                break;
            } else {
                peek[0] = nums.get(peek[1]).get(peek[2]);
            }
            pq.add(peek);
            R = Math.max(R, peek[0]);
        }

        return new int[]{start, end};
    }
}
