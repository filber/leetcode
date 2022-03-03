package tree;

//https://leetcode.com/problems/range-module/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _715_RangeModule {

    public abstract static class RangeModule {

        public abstract void addRange(int left, int right);

        public abstract boolean queryRange(int left, int right);

        public abstract void removeRange(int left, int right);

        public abstract int[][] ranges();
    }

    public static class STRangeModule extends RangeModule {

        SegmentTree root = null;

        public void addRange(int L, int R) {
            root = addRange(root, L, R);
        }

        private SegmentTree addRange(SegmentTree node, int L, int R) {
            if (L >= R) {
                return node;
            } else if (node == null) {
                node = new SegmentTree(L, R);
                return node;
            } else if (node.begin <= L && R <= node.end) {
                return node;
            } else if (R <= node.begin) {
                node.left = addRange(node.left, L, R);
                return node;
            } else if (node.end <= L) {
                node.right = addRange(node.right, L, R);
                return node;
            } else {
                node.left = addRange(node.left, L, node.begin);
                node.right = addRange(node.right, node.end, R);
                return node;
            }
        }

        public boolean queryRange(int left, int right) {
            return queryRange(root, left, right);
        }

        private boolean queryRange(SegmentTree node, int L, int R) {
            if (L >= R) {
                return true;
            } else if (node == null) {
                return false;
            } else if (node.begin <= L && R <= node.end) {
                return true;
            } else if (R <= node.begin) {
                return queryRange(node.left, L, R);
            } else if (node.end <= L) {
                return queryRange(node.right, L, R);
            } else {
                return queryRange(node.left, L, node.begin)
                        && queryRange(node.right, node.end, R);
            }
        }

        public void removeRange(int L, int R) {
            root = removeRange(root, L, R);
        }

        private SegmentTree removeRange(SegmentTree node, int L, int R) {
            if (L >= R) {
                return node;
            } else if (node == null) {
                return null;
            } else if (R <= node.begin) {
                node.left = removeRange(node.left, L, R);
            } else if (node.end <= L) {
                node.right = removeRange(node.right, L, R);
            } else {
                node.left = removeRange(node.left, L, node.begin);
                node.right = removeRange(node.right, node.end, R);
                node.left = addRange(node.left, node.begin, L);
                node.right = addRange(node.right, R, node.end);
                node = remove(node);
            }
            return node;
        }

        private SegmentTree remove(SegmentTree node) {
            if (node == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else {
                SegmentTree leftLargest = getLargest(node.left, node);
                leftLargest.left = node.left;
                leftLargest.right = node.right;
                return leftLargest;
            }
        }

        private SegmentTree getLargest(SegmentTree node, SegmentTree parent) {
            while (node.right != null) {
                parent = node;
                node = node.right;
            }

            if (node == parent.left) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
            node.left = null;
            return node;
        }

        public int[][] ranges() {
            List<int[]> list = new ArrayList<>();
            middleOrderTraverse(list, root);
            int[][] ranges = list.toArray(new int[0][]);
            return ranges;
        }

        private void middleOrderTraverse(List<int[]> list, SegmentTree node) {
            if (node == null) {
                return;
            }
            middleOrderTraverse(list, node.left);
            list.add(new int[]{node.begin, node.end});
            middleOrderTraverse(list, node.right);
        }


        public class SegmentTree {
            int begin;
            int end;
            SegmentTree left;
            SegmentTree right;

            SegmentTree(int begin, int end) {
                this.begin = begin;
                this.end = end;
                left = null;
                right = null;
            }
        }
    }

    public static class TMRangeModule extends RangeModule {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        private void removeEntry(Map.Entry<Integer, Integer> entry) {
            treeMap.remove(entry.getKey());
        }

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> preEntry = treeMap.floorEntry(left);
            if (preEntry != null) {
                if (preEntry.getValue() < left) {
                    // no overlapping
                } else if (preEntry.getValue() < right) {
                    removeEntry(preEntry);
                    left = preEntry.getKey();// merge
                } else {
                    return; // no need to add
                }
            }

            Map.Entry<Integer, Integer> postEntry = treeMap.ceilingEntry(left);
            while (postEntry != null && postEntry.getKey() <= right) {
                removeEntry(postEntry);
                right = Math.max(right, postEntry.getValue());
                postEntry = treeMap.ceilingEntry(left);
            }

            treeMap.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> preEntry = treeMap.floorEntry(left);
            return preEntry != null && right <= preEntry.getValue();
        }

        private void add(int L, int R) {
            if (L < R) {
                treeMap.put(L, R);
            }
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> preEntry = treeMap.floorEntry(left);
            if (preEntry != null) {
                if (preEntry.getValue() <= left) {
                    // no overlapping
                } else if (preEntry.getValue() < right) {
                    removeEntry(preEntry);
                    add(preEntry.getKey(), left);
                } else {
                    removeEntry(preEntry);
                    add(preEntry.getKey(), left);
                    add(right, preEntry.getValue());
                }
            }

            Map.Entry<Integer, Integer> postEntry = treeMap.ceilingEntry(left);
            while (postEntry != null && postEntry.getKey() < right) {
                removeEntry(postEntry);
                add(right, postEntry.getValue());
                postEntry = treeMap.ceilingEntry(left);
            }
        }

        public int[][] ranges() {
            int[][] ans = new int[treeMap.size()][2];

            Map.Entry<Integer, Integer> cur = treeMap.firstEntry();
            for (int i = 0; i < ans.length; i++) {
                ans[i][0] = cur.getKey();
                ans[i][1] = cur.getValue();
                cur = treeMap.higherEntry(cur.getKey());
            }

            return ans;
        }
    }
}
