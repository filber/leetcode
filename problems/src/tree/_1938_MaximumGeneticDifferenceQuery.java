package tree;

// https://leetcode.com/problems/maximum-genetic-difference-query/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1938_MaximumGeneticDifferenceQuery {
    public static class Trie {
        Trie left = null;
        int leftCnt = 0;
        Trie right = null;
        int rightCnt = 0;
    }

    public static int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int[] ans = new int[queries.length];

        // 1. Construct TreeNode
        List<Integer>[] treeList = new List[parents.length];
        int root = -1;

        for (int i = 0; i < parents.length; i++) {
            treeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < parents.length; i++) {
            int parent = parents[i];
            if (parent == -1) {
                root = i; // root node
            } else {
                List<Integer> pList = treeList[parent];
                pList.add(i);
            }
        }

        // 2. Assemble Query map
        Map<Integer, List<int[]>> queryMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i]; // [node,val]
            List<int[]> pairs = queryMap.get(query[0]);
            if (pairs == null) {
                pairs = new ArrayList<>();
                queryMap.put(query[0], pairs);
            }
            // [val,query_id]
            pairs.add(new int[]{query[1], i});
        }

        // 3. DFS for all answers
        Trie trie = new Trie();
        dfs(trie, ans, queryMap, treeList, root);

        return ans;
    }

    private static void dfs(Trie trie, int[] ans, Map<Integer, List<int[]>> queryMap, List<Integer>[] treeList, int root) {

        // set states: add root.val to trie
        addNumber(trie, root, 1);

        if (queryMap.containsKey(root)) {
            List<int[]> queries = queryMap.get(root);
            for (int[] query : queries) {
                // [val,query_id]
                int res = search(trie, query[0]);
                ans[query[1]] = res;
            }
        }

        for (int child : treeList[root]) {
            dfs(trie, ans, queryMap, treeList, child);
        }

        // reverse states: delete root.val from trie
        addNumber(trie, root, -1);
    }

    private static int search(Trie node, int val) {
        int res = 0;
        for (int i = MAX_DIGIT; i >= 1; i--) {
            int bit = val >>> (i - 1) & 1;
            if (bit == 0) {
                if (node.right != null && node.rightCnt > 0) {
                    res += 1 << (i - 1);
                    node = node.right;
                } else if (node.left != null && node.leftCnt > 0) {
                    node = node.left;
                } else {
                    return -1;
                }
            } else {
                if (node.left != null && node.leftCnt > 0) {
                    res += 1 << (i - 1);
                    node = node.left;
                } else if (node.right != null && node.rightCnt > 0) {
                    node = node.right;
                } else {
                    return -1;
                }
            }
        }
        return res;
    }

    private static void addNumber(Trie node, int val, int dir) {
        for (int i = MAX_DIGIT; i >= 1; i--) {
            int bit = val >>> (i - 1) & 1;
            if (bit == 0) {
                if (node.left == null) {
                    node.left = new Trie();
                }
                node.leftCnt += dir;
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new Trie();
                }
                node.rightCnt += dir;
                node = node.right;
            }
        }
    }

    private static final int MAX_DIGIT = 31;

    public static void main(String[] args) {
        // 2[2^0], 3[2^1], 7[5^2]
        int[] a1 = maxGeneticDifference(
                new int[]{-1, 0, 1, 1},
                new int[][]{{0, 2}, {3, 2}, {2, 5}});

        // 6[6^0], 14[15^1], 7[5^2]
        int[] a2 = maxGeneticDifference(
                new int[]{3, 7, -1, 2, 0, 7, 0, 2},
                new int[][]{{4, 6}, {1, 15}, {0, 5}});
    }
}
