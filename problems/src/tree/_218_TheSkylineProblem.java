package tree;

//https://leetcode.com/problems/the-skyline-problem/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _218_TheSkylineProblem {

    SegmentTree root = null;

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        for (int i = 0; i < n; i++) {
            int[] building = buildings[i];
            root = addRange(root, building[0], building[1], building[2]);
        }

        List<SegmentTree> list = new ArrayList<>();
        traverse(list, root);

        List<List<Integer>> ans = new ArrayList<>();
        for (SegmentTree tree : list) {
            ans.add(Arrays.asList(tree.begin,tree.height));
        }
        if (!list.isEmpty()) {
            SegmentTree last = list.get(list.size() - 1);
            ans.add(Arrays.asList(last.end, 0));
        }

        return ans;
    }

    private void traverse(List<SegmentTree> list, SegmentTree node) {
        if (node == null) {
            return;
        }
        traverse(list, node.left);

        if (!list.isEmpty()) {
            SegmentTree last = list.get(list.size() - 1);
            if (last.end == node.begin) {
                // consecutive
                if (last.height == node.height) {
                    // same height
                    last.end = node.end; // expand;
                } else {
                    // different height
                    list.add(node);
                }
            } else {
                list.add(new SegmentTree(last.end, last.end, 0));
                list.add(node);
            }
        } else {
            list.add(node);
        }

        traverse(list, node.right);
    }

    private SegmentTree addRange(SegmentTree node, int L, int R, int H) {
        if (L >= R) {
            return node;
        } else if (node == null) {
            return new SegmentTree(L, R, H);
        } else if (node.begin == L && R == node.end) {
            if (H > node.height) {
                node.height = H;
            }
            return node;
        }

        if (L <= node.begin && node.end <= R) {
            node.left = addRange(node.left, L, node.begin, H);
            node.right = addRange(node.right, node.end, R, H);
            if (H > node.height) {
                node.height = H;
            }
        } else if (R <= node.begin) {
            node.left = addRange(node.left, L, R, H);
        } else if (node.end <= L) {
            node.right = addRange(node.right, L, R, H);
        } else {
            // node.begin<R && L<node.end && (node.begin<L || R<node.end)
            node.left = addRange(node.left, L, node.begin, H);
            node.right = addRange(node.right, node.end, R, H);
            if (node.begin < L && R < node.end && node.height < H) {
                SegmentTree lTree = new SegmentTree(node.begin, L, node.height);
                lTree.left = node.left;
                node.left = lTree;

                SegmentTree rTree = new SegmentTree(R, node.end, node.height);
                rTree.right = node.right;
                node.right = rTree;

                node.begin = L;
                node.end = R;
                node.height = H;
            } else if (R < node.end && node.height < H) {
                SegmentTree lTree = new SegmentTree(node.begin, R, H);
                lTree.left = node.left;
                node.left = lTree;

                node.begin = R;
            } else if (node.begin < L && node.height < H) {
                SegmentTree rTree = new SegmentTree(L, node.end, H);
                rTree.right = node.right;
                node.right = rTree;

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
