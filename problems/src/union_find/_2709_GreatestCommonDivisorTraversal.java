package union_find;

import java.util.*;

//https://leetcode.com/problems/greatest-common-divisor-traversal/

public class _2709_GreatestCommonDivisorTraversal {
    int[] idx;
    int[] size;

    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int max = 0;
        for(int num:nums) {
            if (num == 1) {
                return false;
            }
            max = Math.max(max,num);
        }
        int n = nums.length;
        idx = new int[max + 1];
        size = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            idx[i] = i;
            size[i] = 1;
        }
        boolean[] existed = new boolean[max + 1];
        for(int num:nums) {
            existed[num] = true;
        }
        boolean[] visited = new boolean[max+1];

        for (int i = 2; i * 2 <= max; i++) {
            if (visited[i]) continue;
            for (int j = 2; j * i <= max; j++) {
                int num = i * j;
                visited[num] = true;
                if (existed[num]) {
                    // num is divisible by i
                    union(i, num);
                }
            }
        }

        int root = find(nums[0]);
        for (int i = 1; i < n; i++) {
            if (find(nums[i]) != root) {
                return false;
            }
        }
        return true;
    }

    private int find(int i) {
        while(i!=idx[i]) {
            idx[i] = idx[idx[i]];
            i = idx[i];
        }
        return i;
    }
    private void union(int p,int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot) {
            return;
        }
        int pSize = size[pRoot];
        int qSize = size[qRoot];
        if(pSize> qSize) {
            idx[qRoot] = pRoot;
            size[pRoot] += qSize;
        } else {
            idx[pRoot] = qRoot;
            size[qRoot] += pSize;
        }
    }
}
