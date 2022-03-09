package tree;

//https://leetcode.com/problems/falling-squares/

import java.util.ArrayList;
import java.util.List;

public class _699_FallingSquares {

    private int k = 0;
    private SegmentTree root = null;

    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ans = new ArrayList<>(n);
        for (int[] position : positions) {
            int max = searchMaxHeight(root, position[0], position[0] + position[1]);
            int h = max + position[1];
            root = addRange(root, position[0], position[0] + position[1], h);
            k = Math.max(k, h);
            ans.add(k);
        }

        return ans;
    }

    private int searchMaxHeight(SegmentTree node, int L, int R) {
        if (L >= R || node == null) {
            return 0;
        } else if (R <= node.begin) {
            return searchMaxHeight(node.left, L, R);
        } else if (node.end <= L) {
            return searchMaxHeight(node.right, L, R);
        } else if (node.begin <= L && R <= node.end) {
            return node.height;
        } else {
            int lmax = searchMaxHeight(node.left, L, node.begin);
            int rmax = searchMaxHeight(node.right, node.end, R);
            return Math.max(node.height, Math.max(lmax, rmax));
        }
    }

    private SegmentTree addRange(SegmentTree node, int L, int R, int H) {
        if (L >= R) {
            return node;
        } else if (node == null) {
            node = new SegmentTree(L, R, H);
        } else if (R <= node.begin) {
            node.left = addRange(node.left, L, R, H);
        } else if (node.end <= L) {
            node.right = addRange(node.right, L, R, H);
        } else if (node.begin <= L && R <= node.end) {
            if (node.begin < L) {
                SegmentTree leftTree = new SegmentTree(node.begin, L, node.height);
                leftTree.left = node.left;
                node.left = leftTree;
                node.begin = L;
            }

            if (R < node.end) {
                SegmentTree rightTree = new SegmentTree(R, node.end, node.height);
                rightTree.right = node.right;
                node.right = rightTree;
                node.end = R;
            }
            node.height = H;
        } else {
            node.left = addRange(node.left, L, node.begin, H);
            node.right = addRange(node.right, node.end, R, H);
            if (L <= node.begin && node.end <= R) {
                node.height = H;
            } else if (R < node.end) {
                SegmentTree leftTree = new SegmentTree(node.begin, R, H);
                leftTree.left = node.left;
                node.left = leftTree;
                node.begin = R;
            } else {
                // node.begin < L
                SegmentTree rightTree = new SegmentTree(L, node.end, H);
                rightTree.right = node.right;
                node.right = rightTree;
                node.end = L;
            }
        }

        return node;
    }

    class SegmentTree {
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
