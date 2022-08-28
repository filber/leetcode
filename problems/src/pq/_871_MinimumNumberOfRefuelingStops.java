package pq;

//https://leetcode.com/problems/minimum-number-of-refueling-stops/

import java.util.Collections;
import java.util.PriorityQueue;

public class _871_MinimumNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Guard condition
        if (stations.length == 0) {
            if (startFuel >= target) {
                return 0;
            } else {
                return -1;
            }
        }

        int fuel = startFuel;
        int stops = 0;
        PriorityQueue<Integer> F = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stations.length; i++) {
            int distance = stations[i][0];
            int refuel = stations[i][1];
            while (fuel < distance) {
                if (F.isEmpty()) {
                    return -1;
                } else {
                    stops++;
                    fuel += F.poll();
                }
            }
            F.add(refuel);
        }

        while (fuel < target) {
            if (F.isEmpty()) {
                return -1;
            } else {
                stops++;
                fuel += F.poll();
            }
        }
        return stops;
    }
}
