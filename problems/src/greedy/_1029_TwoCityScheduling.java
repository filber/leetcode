package greedy;

// https://leetcode.com/problems/two-city-scheduling/

import java.util.Arrays;

public class _1029_TwoCityScheduling {

  public static int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, (a, b) -> Integer.compare(a[0] - a[1], b[0] - b[1]));
    int n = costs.length/2;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += costs[i][0] + costs[i+n][1];
    }

    return sum;
  }

  public static void main(String[] args) {
//    A: 10 + 30 = 40
//    B: 50 + 20 = 70
//    Output: 110
    int c1 = twoCitySchedCost(new int[][] {{10, 20}, {30, 200}, {400, 50}, {30, 20}});

//    A: 184 + 259 + 577
//    B: 54 + 118 + 667
//    Output: 1859
    int c2 = twoCitySchedCost(new int[][] {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}});

//    A: 343 + 451 + 515 + 537
//    B: 42 + 60 + 359 + 779
//    Output: 3086
    int c3 = twoCitySchedCost(new int[][]{{515,563},{451,713},{537,709},{343,819},{855,779},{457,60},{650,359},{631,42}});
  }
}
