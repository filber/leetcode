package array_matrix;

//https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/

import java.util.ArrayList;
import java.util.List;

public class _2147_NumberOfWaysToDivideALongCorridor {

    public int numberOfWays(String corridor) {
        char[] chars = corridor.toCharArray();
        int n = chars.length;

        List<Integer> list = new ArrayList<>();
        int preSeat = -1;
        int seatCnt = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'S') {
                seatCnt++;
                if (seatCnt % 2 == 1 && preSeat != -1) {
                    int plants = i - preSeat - 1;
                    if (plants != 0) {
                        list.add(plants);
                    }
                } else {
                    preSeat = i;
                }
            }
        }

        if (seatCnt % 2 == 1 || seatCnt == 0) {
            return 0;
        }

        int modulo = (int) (1e9 + 7);
        long ans = 1;
        for (int plants : list) {
            ans = (ans * (plants + 1)) % modulo;
        }

        return (int) ans;
    }
}
