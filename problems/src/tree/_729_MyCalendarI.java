package tree;

//https://leetcode.com/problems/my-calendar-i/

import java.util.Comparator;
import java.util.TreeSet;

public class _729_MyCalendarI {

    public static abstract class MyCalendar {
        public abstract boolean book(int start, int end);
    }

    // Tree Map
    public static class TMCalendar extends MyCalendar {

        TreeSet<int[]> treeSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });

        public boolean book(int start, int end) {
            int[] range = {start, end};
            int[] floor = treeSet.floor(range);
            int[] ceil = treeSet.ceiling(range);
            if (touchCeil(range, ceil) || touchFloor(range, floor)) {
                return false;
            } else {
                treeSet.add(range);
                return true;
            }
        }

        private boolean touchFloor(int[] range, int[] floor) {
            return floor != null && range[0] < floor[1];
        }

        private boolean touchCeil(int[] range, int[] ceil) {
            return ceil != null && range[1] > ceil[0];
        }
    }

    // Segment Tree
    public static class SMCalendar extends MyCalendar {
        class SegmentTree {
            int start;
            int end;
            SegmentTree left;
            SegmentTree right;

            public SegmentTree(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        SegmentTree root = null;
        boolean conflict;

        public SegmentTree add(SegmentTree node, int L, int R) {
            if (node == null) {
                return new SegmentTree(L, R);
            } else if (R <= node.start) {
                node.left = add(node.left, L, R);
            } else if (node.end <= L) {
                node.right = add(node.right, L, R);
            } else {
                conflict = true;
            }

            return node;
        }

        public boolean book(int start, int end) {
            conflict = false;
            root = add(root, start, end);
            return !conflict;
        }
    }
}
