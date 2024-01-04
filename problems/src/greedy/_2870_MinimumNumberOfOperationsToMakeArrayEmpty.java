package greedy;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/

import java.util.HashMap;
import java.util.Map;

public class _2870_MinimumNumberOfOperationsToMakeArrayEmpty {

    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0);
            cnt++;
            map.put(num,cnt);
        }
        int operations = 0;
        for (int cnt : map.values()) {
            if (cnt == 1) {
                return -1;
            }
            if (cnt % 3 == 0) { // 3,6
                operations += cnt / 3;
            } else if (cnt % 3 == 2) { // 2,5
                operations += (cnt / 3) + 1;
            } else {
                // cnt % 3 == 1
                // 4,7,10,13,16
                operations += (cnt - 4) / 3 + 2;
            }
        }
        return operations;
    }
}
