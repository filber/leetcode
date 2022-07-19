package pq;

//https://leetcode.com/problems/furthest-building-you-can-reach/

import java.util.PriorityQueue;

public class _1642_FurthestBuildingYouCanReach {


    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (idx < heights.length - 1) {
            if (heights[idx] < heights[idx + 1]) {
                int diff = heights[idx + 1] - heights[idx];
                pq.add(diff);
                if (!pq.isEmpty() && pq.size() > ladders) {
                    bricks -= pq.poll();
                }
                if (bricks < 0) {
                    return idx;
                }
            }
            idx++;
        }
        return idx;
    }
}
