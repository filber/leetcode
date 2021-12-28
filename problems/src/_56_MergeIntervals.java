import java.util.*;

// TIPS: Using bit set to handle overlapping numbers
public class _56_MergeIntervals {
    public static class Tuple {
        int start;
        int end;
        public Tuple(int start,int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class TupleComparator implements Comparator<Tuple> {
        @Override
        public int compare(Tuple o1, Tuple o2) {
            if (o1.start == o2.start) {
                return Integer.compare(o1.end,o2.end);
            } else {
                return Integer.compare(o1.start,o2.start);
            }
        }
    }

    // Constraints:
    //        1 <= intervals.length <= 10^4
    //        intervals[i].length == 2
    //        0 <= starti <= endi <= 10^4
    public static int[][] mergeV1(int[][] intervals) {
        // 0. Guard conditions
        if (intervals.length == 1) {
            return intervals;
        }

        // 1. Sort tuple by start index
        Tuple[] tuples = new Tuple[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            tuples[i] = new Tuple(intervals[i][0], intervals[i][1]);
        }
        LinkedList<Tuple> tupleList = new LinkedList<>();
        Arrays.sort(tuples,new TupleComparator());
        for (Tuple tuple : tuples) {
            tupleList.add(tuple);
        }

        // 2. Merging tuples
        LinkedList<Tuple> merged = new LinkedList<>();
        while (!tupleList.isEmpty()) {
            if (tupleList.size()==1) {
                // one element left
                merged.add(tupleList.pollFirst());
            } else {
                Tuple first = tupleList.pollFirst();
                Tuple second = tupleList.pollFirst();
                if (second.start > first.end) {
                    // cannot be merged
                    merged.add(first);
                    tupleList.addFirst(second);
                } else {
                    if (second.end<=first.end) {
                        // the second can be merged into the first
                        tupleList.addFirst(first);
                    } else {
                        // using first's start and second's end
                        tupleList.addFirst(new Tuple(first.start,second.end));
                    }
                }
            }
        }

        // 3. Generating result array
        int[][] result = new int[merged.size()][2];
        int i = 0;
        for (Tuple tuple : merged) {
            result[i][0] = tuple.start;
            result[i][1] = tuple.end;
            i++;
        }
        return result;
    }

    public static int[][] merge(int[][] intervals) {
        BitSet bitSet = new BitSet();
        // 1. Add starts&ends to BitSet
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            // avoid start==end
            // [2,2]
            // and overlapping with next interval
            // [1,4],[5,6]
            bitSet.set(start * 2, end * 2 + 1);
        }

        // 2. Traverse BitSet
        int count = 0;
        int start = 0;
        int end = 0;
        for (int i = bitSet.nextSetBit(0);
             i > -1;
             i = bitSet.nextSetBit(end)) {
            start = i;
            end = bitSet.nextClearBit(i);
            intervals[count][0] = start/2;
            intervals[count][1] = (end-1)/2;
            count++;
        }

        // 3. Construct result
        int[][] result = new int[count][2];
        for (int i = 0; i < count; i++) {
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m6 = new int[][]{{1, 4}, {0, 4}};
        m6 = merge(m6);

        int[][] m1 = new int[][]{{1, 2}};
        m1 = merge(m1);

        int[][] m2 = new int[][]{{1, 3}, {4, 5}};
        m2 = merge(m2);

        int[][] m3 = new int[][]{{1, 4}, {4, 5}};
        m3 = merge(m3);

        int[][] m4 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        m4 = merge(m4);

        int[][] m5 = new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        m5 = merge(m5);
    }
}
