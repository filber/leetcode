package bs;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

public class _1011_CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        while (l < r) {
            int capacity = l + (r - l) / 2;
            int cnt = count(weights, capacity);
            if (cnt <= days) {
                r = capacity;
            } else {
                l = capacity + 1;
            }
        }
        return l;
    }

    private int count(int[] weights, int capacity) {
        int days = 0;
        int load = 0;
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            if (load + w == capacity) {
                load = 0;
                days++;
            } else if (load + w < capacity) {
                load += w;
            } else {
                load = w;
                days++;
            }
        }
        if (load > 0) {
            days++;
        }
        return days;
    }
}
