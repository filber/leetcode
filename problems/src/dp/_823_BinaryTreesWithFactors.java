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
            for (int j = i; j < n; j++) {
                int product = arr[i] * arr[j];
                Integer val = map.get(product);
                if (val != null) {
                    int increment = (map.get(arr[i]) * map.get(arr[j])) % modulo;
                    if (i == j) {
                        map.put(product, (val + increment) % modulo);
                    } else {
                        map.put(product, (val + 2 * increment) % modulo);
                    }
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
