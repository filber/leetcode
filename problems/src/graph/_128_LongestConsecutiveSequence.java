package graph;

//https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashMap;
import java.util.Map;

public class _128_LongestConsecutiveSequence {

    int[] idx;
    int[] sz;
    int maxSz = 1;

    public int longestConsecutive(int[] nums) {
        // deduplicate
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(nums[i], i);
        }

        idx = new int[n];
        sz = new int[n];
        // init union find data structure
        for (int i = 0; i < n; i++) {
            idx[i] = i;
            sz[i] = 1;
        }

        // union <V-1,V> <V,V+1>
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            int curIdx = idxMap.get(value);
            int preIdx = idxMap.getOrDefault(value - 1, -1);
            if (preIdx != -1) {
                union(preIdx, curIdx);
            }
            int nextIdx = idxMap.getOrDefault(value + 1, -1);
            if (nextIdx != -1) {
                union(nextIdx, curIdx);
            }
        }

        return maxSz;
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        int pSz = sz[pRoot];
        int qSz = sz[qRoot];
        if (pSz > qSz) {
            idx[qRoot] = pRoot;
            sz[pRoot] += qSz;
        } else {
            idx[pRoot] = qRoot;
            sz[qRoot] += pSz;
        }
        maxSz = Math.max(maxSz, Math.max(sz[pRoot], sz[qRoot]));
    }

    int find(int i) {
        while (idx[i] != i) {
            idx[i] = idx[idx[i]];
            i = idx[i];
        }
        return i;
    }
}
