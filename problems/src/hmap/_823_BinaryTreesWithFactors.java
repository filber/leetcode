package hmap;

//https://leetcode.com/problems/binary-trees-with-factors/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _823_BinaryTreesWithFactors {

    private final int modulo = (int) 1e9 + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : arr) {
            map.put(k, 1);
        }
        for (int i = 1; i < arr.length; i++) {
            int root = arr[i];
            for (int j = 0; j < i; j++) {
                int left = arr[j];
                int right = root / left;
                if (root % left == 0 && map.containsKey(right)) {
                    int cnt = map.get(root);
                    long leftCnt = map.get(left);
                    long rightCnt = map.get(right);
                    cnt = ((int) ((leftCnt * rightCnt) % modulo) + cnt) % modulo;
                    map.put(root, cnt);
                }
            }
        }
        int result = 0;
        for (int cnt : map.values()) {
            result = (result + cnt) % modulo;
        }
        return result;
    }
}
