package tree;

//https://leetcode.com/problems/my-calendar-iii/

public class _732_MyCalendarIII {

    static class MyCalendarThree {

        int k = 0;
        SegmentTree root = null;

        public int book(int L, int R) {
            root = addRange(root, L, R);
            return k;
        }

        private SegmentTree addRange(SegmentTree node, int L, int R) {
            if (L >= R) {
                return node;
            } else if (node == null) {
                node = new SegmentTree(L, R);
            } else if (node.end <= L) {
                node.right = addRange(node.right, L, R);
            } else if (R <= node.begin) {
                node.left = addRange(node.left, L, R);
            } else {
                node.left = addRange(node.left, L, node.begin);
                node.right = addRange(node.right, node.end, R);

                if (L <= node.begin && node.end <= R) {
                    node.cnt++;
                } else if (L <= node.begin) {
                    // L <= node.begin < R < node.end
                    SegmentTree leftRange = new SegmentTree(node.begin, R, node.cnt + 1);
                    k = Math.max(k, leftRange.cnt);

                    leftRange.left = node.left;
                    node.left = leftRange;
                    node.begin = R;
                } else if (node.end <= R) {
                    // node.begin < L < node.end <= R
                    SegmentTree rightRange = new SegmentTree(L, node.end, node.cnt + 1);
                    k = Math.max(k, rightRange.cnt);

                    rightRange.right = node.right;
                    node.right = rightRange;
                    node.end = L;
                } else {
                    // node.begin < L < R < node.end
                    SegmentTree leftRange = new SegmentTree(node.begin, L, node.cnt);
                    leftRange.left = node.left;
                    node.left = leftRange;
                    node.begin = L;

                    SegmentTree rightRange = new SegmentTree(R, node.end, node.cnt);
                    rightRange.right = node.right;
                    node.right = rightRange;
                    node.end = R;

                    node.cnt++;
                }
            }

            k = Math.max(k, node.cnt);
            return node;
        }

        class SegmentTree {
            int begin;
            int end;
            int cnt;
            SegmentTree left;
            SegmentTree right;

            public SegmentTree(int begin, int end) {
                this.begin = begin;
                this.end = end;
                left = null;
                right = null;
                cnt = 1;
            }

            public SegmentTree(int begin, int end, int cnt) {
                this(begin, end);
                this.cnt = cnt;
            }
        }
    }
}
