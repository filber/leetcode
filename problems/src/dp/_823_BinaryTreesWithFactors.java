package dp;

//https://leetcode.com/problems/binary-trees-with-factors/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _823_BinaryTreesWithFactors {

    private final int modulo = (int) 1e9 + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        for (int val : arr) {
            map.put(val, 1);
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int iVal = arr[i];
            for (int j = 0; j < i; j++) {
                int jVal = arr[j];
                if (iVal % jVal == 0 && map.containsKey(iVal / jVal)) {
                    long leftCnt = map.get(iVal / jVal);
                    long rightCnt = map.get(jVal);
                    int delta = (int) ((leftCnt * rightCnt) % modulo);
                    int cnt = map.get(iVal);
                    map.put(iVal, (cnt + delta) % modulo);
                }
            }
        }

        int rst = 0;
        for (int cnt : map.values()) {
            rst = (rst + cnt) % modulo;
        }
        return rst;
    }
}
