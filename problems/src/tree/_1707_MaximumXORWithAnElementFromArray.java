package tree;

// https://leetcode.com/problems/maximum-xor-with-an-element-from-array/

import java.util.Arrays;

public class _1707_MaximumXORWithAnElementFromArray {
    public static class Trie {
        Trie left = null;
        Trie right = null;
        int min = Integer.MAX_VALUE;
    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Trie root = new Trie();

        // 1. Construct Trie
        for (int num : nums) {
            Trie cur = root;
            for (int i = 31; i >= 1; i--) {
                cur.min = Math.min(cur.min, num);
                int bit = num >>> (i - 1) & 1;
                if (bit == 0) {
                    if (cur.left == null) {
                        cur.left = new Trie();
                        cur.left.min = num;
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = new Trie();
                        cur.right.min = num;
                    }
                    cur = cur.right;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int q = queries[i][0];
            int limit = queries[i][1];
            if (limit < root.min) {
                // 2.1. No available number
                ans[i] = -1;
            } else if (limit == root.min) {
                // 2.2. Only min is available
                ans[i] = q ^ root.min;
            } else {
                // 2.3. find maximum of XOR
                int sum = 0;
                Trie cur = root;
                for (int j = 31; j >= 1; j--) {
                    int qBit = q >>> (j - 1) & 1;
                    Trie next = qBit == 0 ? cur.right : cur.left;
                    Trie other = qBit == 0 ? cur.left : cur.right;
                    if (next!=null && next.min<=limit) {
                        sum += 1 << (j - 1);
                        cur = next;
                    } else {
                        // cur.min must LE limit,
                        // if cur.children[1]>limit, then cur.children[0] must exits
                        cur = other;
                    }
                }
                ans[i] = sum;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // 3[0^3], 3[1^2], 7[5^2]
        int[] a1 = maximizeXor(
                new int[]{0, 1, 2, 3, 4},
                new int[][]{{3, 1}, {1, 3}, {5, 6}});

        // 15,-1,5
        int[] a2 = maximizeXor(
                new int[]{5, 2, 4, 6, 6, 3},
                new int[][]{{12, 4}, {8, 1}, {6, 3}});

        // [1050219420,844498962,540190212,539622516,330170208]
        int[] a3 = maximizeXor(
                new int[]{536870912, 0, 534710168, 330218644, 142254206},
                new int[][]{{558240772, 1000000000},
                        {307628050, 1000000000},
                        {3319300, 1000000000},
                        {2751604, 683297522},
                        {214004, 404207941}});
    }
}
