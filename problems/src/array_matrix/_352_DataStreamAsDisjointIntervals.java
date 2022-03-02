package array_matrix;

//https://leetcode.com/problems/data-stream-as-disjoint-intervals/

import java.util.*;

public class _352_DataStreamAsDisjointIntervals {

    public static class SummaryRanges {
        TreeSet<int[]> treeSet;

        public SummaryRanges() {
            treeSet = new TreeSet<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
                }
            });
        }

        public void addNum(int val) {
            int[] range = new int[]{val, val};
            int[] floor = treeSet.floor(range);
            int[] ceil = treeSet.ceiling(range);
            if (floor == null && ceil == null) {
                addRange(range);
            } else if (floor == null) {
                if (touchCeil(ceil, range)) {
                    mergeToCeil(ceil, range);
                } else {
                    addRange(range);
                }
            } else if (ceil == null) {
                if (touchFloor(floor, range)) {
                    mergeToFloor(floor, range);
                } else {
                    addRange(range);
                }
            } else {
                if (floor[1] == (range[0] - 1) && range[1] == (ceil[0] - 1)) {
                    treeSet.remove(ceil); // fill the hole
                    floor[1] = ceil[1];
                } else if (!touchFloor(floor, range) && !touchCeil(ceil, range)) {
                    addRange(range);
                } else if (!touchFloor(floor, range)) {
                    mergeToCeil(ceil, range);
                } else {
                    //!touchCeil(ceil, range)
                    mergeToFloor(floor, range);
                }
            }
        }

        private void addRange(int[] range) {
            treeSet.add(range);
        }

        private boolean touchFloor(int[] floor, int[] range) {
            return floor[1] >= (range[0] - 1);
        }

        private void mergeToFloor(int[] floor, int[] range) {
            floor[1] = Math.max(floor[1], range[1]);//merge
        }

        private boolean touchCeil(int[] ceil, int[] range) {
            return range[1] >= (ceil[0] - 1);
        }

        private void mergeToCeil(int[] ceil, int[] range) {
            ceil[0] = Math.min(ceil[0], range[0]);//merge
        }

        public int[][] getIntervals() {
            int[][] ans = treeSet.toArray(new int[0][]);
            return ans;
        }
    }

    public static class SummaryRangesBitSet {
        BitSet bitSet;

        public SummaryRangesBitSet() {
            bitSet = new BitSet();
        }

        public void addNum(int val) {
            bitSet.set(val, val + 1);
        }

        public int[][] getIntervals() {
            List<int[]> list = new ArrayList<>();

            int begin = bitSet.nextSetBit(0);
            while (begin >= 0) {
                int end = bitSet.nextClearBit(begin);
                list.add(new int[]{begin, end - 1});
                begin = bitSet.nextSetBit(end);
            }

            int[][] ans = new int[list.size()][];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
}
