package tree;

//https://leetcode.com/problems/range-sum-query-mutable/

public class _307_RangeSumQueryMutable {

    static class NumArray {

        int[] nums;
        int n;
        int[] tree;

        public NumArray(int[] nums) {
            n = nums.length;
            tree = new int[n + 1];
            this.nums = nums;
            buildTree();
        }

        public void buildTree() {
            for (int i = 1; i <= n; i++) {
                addVal(i, nums[i - 1]);
            }
        }

        private void addVal(int idx, int val) {
            while (idx <= n) {
                tree[idx] += val;
                idx = idx + (idx & (-idx));
            }
        }

        public void update(int i, int val) {
            int delta = val - nums[i];
            nums[i] = val;
            addVal(i + 1, delta);
        }

        public int sum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i = i - (i & (-i));
            }
            return sum;
        }

        public int sumRange(int i, int j) {
            int leftSum = sum(i);
            int rightSum = sum(j + 1);
            return rightSum - leftSum;
        }
    }


    static class NumArraySegmentTree {

        static class SegmentTree {
            int begin;
            int end;
            int val;
            SegmentTree left;
            SegmentTree right;

            SegmentTree(int begin, int end) {
                this.begin = begin;
                this.end = end;
            }
        }

        SegmentTree root;
        int[] nums;

        public NumArraySegmentTree(int[] nums) {
            this.nums = nums;
            root = new SegmentTree(0, nums.length - 1);
            populate(root);
        }

        private void populate(SegmentTree node) {
            if (node.begin == node.end) {
                node.val = nums[node.begin];
                return;
            }
            int mid = (node.begin + node.end) / 2;
            SegmentTree left = new SegmentTree(node.begin, mid);
            populate(left);
            node.left = left;
            SegmentTree right = new SegmentTree(mid + 1, node.end);
            populate(right);
            node.right = right;
            node.val = left.val + right.val;
        }

        public void update(int index, int val) {
            int delta = val - nums[index];
            nums[index] = val;
            update(root, index, delta);
        }

        private void update(SegmentTree node, int index, int delta) {
            if (node == null) {
                return;
            } else if (index < node.begin || node.end < index) {
                return;
            }
            node.val += delta;
            update(node.left, index, delta);
            update(node.right, index, delta);
        }

        public int sumRange(int left, int right) {
            return sum(root, left, right);
        }

        private int sum(SegmentTree node, int left, int right) {
            if (node == null) {
                return 0;
            } else if (left <= node.begin && node.end <= right) {
                return node.val;
            } else if (right < node.begin || node.end < left) {
                return 0;
            } else {
                int leftSum = sum(node.left, left, right);
                int rightSum = sum(node.right, left, right);
                return leftSum + rightSum;
            }
        }
    }
}
