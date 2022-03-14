package dp;

//https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/

import java.util.ArrayList;
import java.util.List;

public class _2147_NumberOfWaysToDivideALongCorridor {

    public int numberOfWays(String corridor) {
        int modulo = (int) (1e9 + 7);
        char[] chars = corridor.toCharArray();
        int n = chars.length;
        int preSeat = -1;
        int seatCnt = 0;
        List<Integer> plantsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch == 'P') continue;

            seatCnt++;
            if (seatCnt % 2 == 0) {
                preSeat = i;
            } else if (preSeat != -1) {
                int plants = i - preSeat - 1;
                if (plants != 0) {
                    plantsList.add(plants);
                }
            }
        }

        if (seatCnt % 2 == 1 || seatCnt == 0) {
            return 0;
        } else if (plantsList.isEmpty()) {
            return 1;
        }

        Integer[] plants = plantsList.toArray(new Integer[0]);
        long[] dp = new long[plants.length + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int p = plants[i - 1] + 1;
            dp[i] = (p * dp[i - 1]) % modulo;
        }

        return (int) dp[dp.length - 1];
    }
}
