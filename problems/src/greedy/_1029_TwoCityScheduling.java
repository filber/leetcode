package greedy;

import java.util.Arrays;

public class _1029_TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[0] - a[1] - b[0] + b[1]);
        int cost = 0;
        final int n = costs.length;
        final int threshold = n / 2;
        for (int i = 0; i < n; i++) {
            if (i < threshold) {
                cost += costs[i][0];
            } else {
                cost += costs[i][1];
            }
        }
        return cost;
    }
}
