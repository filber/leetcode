package greedy;

import java.util.*;

// https://leetcode.com/problems/stone-game-vi/
public class _1686_StoneGameVI {

//  Constraints:
//  n == aliceValues.length == bobValues.length
//  1 <= n <= 105
//  1 <= aliceValues[i], bobValues[i] <= 100

//  If Alice wins, return 1.
//  If Bob wins, return -1.
//  If the game results in a draw, return 0.

    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] score = new int[n][3];
        for (int i = 0; i < n; i++) {
            score[i][0] = aliceValues[i];
            score[i][1] = bobValues[i];
            score[i][2] = aliceValues[i] + bobValues[i];
        }
        Arrays.sort(score, (a, b) -> Integer.compare(b[2], a[2]));

        int aliceScore = 0;
        int bobScore = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                aliceScore += score[i][0];
            } else {
                bobScore += score[i][1];
            }
        }
        if (aliceScore > bobScore) {
            return 1;
        } else if (aliceScore < bobScore) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        // 1
        int g1 = stoneGameVI(new int[]{1, 3}, new int[]{2, 1});

        // 0
        int g2 = stoneGameVI(new int[]{1, 2}, new int[]{3, 1});

        // -1
        int g3 = stoneGameVI(new int[]{2, 4, 3}, new int[]{1, 6, 7});

        // 1
        int g4 = stoneGameVI(new int[]{9, 8, 3, 8}, new int[]{10, 6, 9, 5});
    }
}
