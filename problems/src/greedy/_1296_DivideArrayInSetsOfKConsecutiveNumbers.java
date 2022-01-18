package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
public class _1296_DivideArrayInSetsOfKConsecutiveNumbers {

    public static boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer cnt = map.get(nums[i]);
            if (cnt == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], cnt + 1);
            }
        }

        int[] distinct = new int[map.keySet().size()];
        int n = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            distinct[n++] = iterator.next();
        }
        Arrays.sort(distinct);

        int i = 0;
        while (i < n) {
            if (!map.containsKey(distinct[i])) {
                i++;
            } else {
                int val = distinct[i];
                for (int j = 0; j < k; j++) {
                    // decrease i ~ i+k-1
                    if (!dec(map, val + j)) {
                        return false;
                    }
                }
            }
        }

        return map.isEmpty();
    }

    private static boolean dec(Map<Integer, Integer> map,int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int cnt = map.get(val);
            if (cnt == 1) {
                map.remove(val);
            } else {
                map.put(val, cnt - 1);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        // [1,2,3,4],[3,4,5,6]
        boolean b1 = isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4);

        // [1,2,3,], [2,3,4], [3,4,5], [9,10,11]
        boolean b2 = isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3);
        // false
        boolean b3 = isPossibleDivide(new int[]{1, 2, 3, 4}, 3);
        // false
        boolean b4 = isPossibleDivide(new int[]{16,21,26,35}, 4);
    }
}
