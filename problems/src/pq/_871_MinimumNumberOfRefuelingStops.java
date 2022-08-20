package pq;

//https://leetcode.com/problems/minimum-number-of-refueling-stops/

import java.util.Collections;
import java.util.PriorityQueue;

public class _871_MinimumNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            if (startFuel >= target) {
                return 0;
            } else {
                return -1;
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int stops = 0;
        int fuel = startFuel;
        for (int i = 0; i < stations.length; i++) {
            int position = stations[i][0];
            while (fuel < position) {
                Integer refuel = queue.poll();
                if (refuel == null) {
                    return -1;
                }
                fuel += refuel;
                stops++;
            }
            queue.add(stations[i][1]);
        }

        while (fuel < target) {
            Integer refuel = queue.poll();
            if (refuel == null) {
                return -1;
            }
            fuel += refuel;
            stops++;
        }
        return stops;
    }
}
