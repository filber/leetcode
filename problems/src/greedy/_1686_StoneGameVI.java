package greedy;

import java.util.*;

// https://leetcode.com/problems/stone-game-vi/
public class _1686_StoneGameVI {

    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] stones = new int[n][3];
        for (int i = 0; i < n; i++) {
            stones[i][0] = aliceValues[i];
            stones[i][1] = bobValues[i];
            stones[i][2] = aliceValues[i] + bobValues[i];
        }
        Arrays.sort(stones, (a, b) -> b[2] - a[2]);
        int aliceScore = 0;
        int bobScore = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                aliceScore += stones[i][0];
            } else {
                bobScore += stones[i][1];
            }
        }

        return Integer.compare(aliceScore, bobScore);
    }
}
