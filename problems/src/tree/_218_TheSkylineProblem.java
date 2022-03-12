package tree;

//https://leetcode.com/problems/the-skyline-problem/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _218_TheSkylineProblem {

    SegmentTree root = null;

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        // 1. Add the range of all buildings to SegmentTree
        for (int i = 0; i < n; i++) {
            int[] building = buildings[i];
            root = addRange(root, building[0], building[1], building[2]);
        }

        // 2. Middle-Order traverse the SegmentTree for silhouette
        List<SegmentTree> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        traverse(list, ans, root);

        // 3. Append sentry value of the last node
        SegmentTree lastNode = list.get(list.size() - 1);
        ans.add(Arrays.asList(lastNode.end, 0));

        return ans;
    }

    private void traverse(List<SegmentTree> list, List<List<Integer>> ans, SegmentTree node) {
        // 0. Guard condition
        if (node == null) {
            return;
        }

        // 1. Traverse left
        traverse(list, ans, node.left);

        // 2. Handle current node
        if (list.isEmpty()) {
            list.add(node);
            ans.add(Arrays.asList(node.begin, node.height));
        } else {
            SegmentTree lastNode = list.get(list.size() - 1);
            if (lastNode.end == node.begin) {
                // consecutive
                if (lastNode.height == node.height) {
                    // same height
                    lastNode.end = node.end;
                } else {
                    // different height
                    list.add(node);
                    ans.add(Arrays.asList(node.begin, node.height));
                }
            } else {
                // not consecutive
                list.add(new SegmentTree(lastNode.end, lastNode.end, 0));
                ans.add(Arrays.asList(lastNode.end, 0));

                list.add(node);
                ans.add(Arrays.asList(node.begin, node.height));
            }
        }

        // 3. Traverse right
        traverse(list, ans, node.right);
    }

    private SegmentTree addRange(SegmentTree node, int L, int R, int H) {
        // 0. Guard condition
        if (L >= R) {
            return node;
        } else if (node == null) {
            return new SegmentTree(L, R, H);
        } else if (node.begin <= L && R <= node.end && H <= node.height) {
            return node; // won't change the skyline
        } else if (node.begin == L && R == node.end) {
            // H > node.height
            node.height = H;
        } else if (node.begin < L && R < node.end) {
            // Split the node
            SegmentTree leftTree = new SegmentTree(node.begin, L, node.height);
            leftTree.left = node.left;
            node.left = leftTree;

            SegmentTree rightTree = new SegmentTree(R, node.end, node.height);
            rightTree.right = node.right;
            node.right = rightTree;

            node.height = H;
            node.begin = L;
            node.end = R;
        } else if (R <= node.begin) {
            node.left = addRange(node.left, L, R, H);
        } else if (node.end <= L) {
            node.right = addRange(node.right, L, R, H);
        } else {
            node.left = addRange(node.left, L, node.begin, H);
            node.right = addRange(node.right, node.end, R, H);
            if (L <= node.begin && node.end <= R && node.height < H) {
                node.height = H;
            } else if (L <= node.begin && node.height < H) {
                // L <= node.begin < R < node.end
                SegmentTree leftTree = new SegmentTree(node.begin, R, H);
                leftTree.left = node.left;
                node.left = leftTree;
                node.begin = R;
            } else if (node.end <= R && node.height < H) {
                // node.begin < L < R <= node.end
                SegmentTree rightTree = new SegmentTree(L, node.end, H);
                rightTree.right = node.right;
                node.right = rightTree;
                node.end = L;
            }
        }
        return node;
    }

    public class SegmentTree {
        int begin;
        int end;
        int height;
        SegmentTree left;
        SegmentTree right;

        public SegmentTree(int begin, int end, int height) {
            this.begin = begin;
            this.end = end;
            this.height = height;
            left = null;
            right = null;
        }
    }
}
