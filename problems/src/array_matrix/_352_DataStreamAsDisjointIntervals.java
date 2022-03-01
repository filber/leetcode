package array_matrix;

//https://leetcode.com/problems/data-stream-as-disjoint-intervals/

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class _352_DataStreamAsDisjointIntervals {

    public static class SummaryRanges {
        BitSet bitSet;

        public SummaryRanges() {
            bitSet = new BitSet();
        }

        public void addNum(int val) {
            bitSet.set(val * 2, val * 2 + 2);
        }

        public int[][] getIntervals() {
            List<int[]> list = new ArrayList<>();

            int begin = bitSet.nextSetBit(0);
            while (begin >= 0) {
                int end = bitSet.nextClearBit(begin);
                list.add(new int[]{begin >> 1, (end - 2) >> 1});
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
