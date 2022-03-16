package array_matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2122_RecoverTheOriginalArray {
    public int[] recoverArray(int[] nums) {
        int n = nums.length / 2;
        Arrays.sort(nums);
        int min = nums[0];
        int validK = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (int i = 1; i < nums.length; i++) {
            int doubleK = nums[i] - min;
            if (doubleK == 0 || doubleK % 2 == 1) {
                continue;
            }
            int k = doubleK / 2;

            Map<Integer, Integer> cntMap = new HashMap<>(map);
            boolean valid = true;
            for (int val : nums) {
                if (!cntMap.containsKey(val)) {
                    continue;
                }
                int cnt = cntMap.get(val);
                int pairVal = val + k + k;
                Integer pairCnt = cntMap.get(pairVal);
                if (pairCnt == null || pairCnt < cnt) {
                    valid = false;
                    break;
                } else {
                    cntMap.remove(val);
                    if (pairCnt == cnt) {
                        cntMap.remove(pairVal);
                    } else {
                        cntMap.put(pairVal, pairCnt - cnt);
                    }
                }
            }

            if (valid) {
                // using k to recover array
                validK = k;
                break;
            }
        }

        int[] ans = new int[n];
        int len = 0;
        for (int val : nums) {
            int cnt = map.getOrDefault(val, 0);
            if (cnt == 0) {
                continue;
            }
            ans[len++] = val + validK;
            if (len == n) {
                break;
            }
            map.put(val, map.getOrDefault(val, 1) - 1);
            int nextVal = val + validK + validK;
            map.put(nextVal, map.getOrDefault(nextVal, 1) - 1);
        }
        return ans;
    }
}
