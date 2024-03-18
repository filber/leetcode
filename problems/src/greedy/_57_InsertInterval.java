package greedy;

//https://leetcode.com/problems/insert-interval/

import java.util.Arrays;

public class _57_InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        int[][] arr = new int[intervals.length + 1][0];
        int j = 0;
        boolean discard = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] inter = intervals[i];
            if (discard) {
                arr[j++] = inter;
                continue;
            }

            if (inter[0] < start) {
                /**
                 s       e
                 i[0]i[1]        append<i>, process <s,e> later
                 i[0].   i[1]    s' = i[0], e' = e
                 i[0].       i[1].     s' = i[0], e' = e
                 i[0].            i[1] s' = i[0], e' = e
                 i[0].                i[1], append<i[0],i[1]>, discard <s,e>
                 */
                if (inter[1] < start) {
                    arr[j++] = inter;
                } else if (inter[1] == start) {
                    start = inter[0];
                } else if (start < inter[1] && inter[1] < end) {
                    start = inter[0];
                } else if (end == inter[1]) {
                    start = inter[0];
                } else {
                    arr[j++] = inter;
                    discard = true;
                }
            } else if (inter[0] == start) {
                /**
                 s       e
                 i[0]i[1]          ignore i
                 i[0].  i[1]       ignore i
                 i[0].      i[1]   append<s,i[1]>, discard <s,e>
                 */
                if (end < inter[1]) {
                    arr[j++] = inter;
                    discard = true;
                }
            } else if (start < inter[0] && inter[0] < end) {
                /**
                 s          e
                 i[0]i[1]        ignore i
                 i[0].  i[1]     ignore i
                 i[0].       i[1]  e' = i[1]
                 */
                end = Math.max(end, inter[1]);
            } else if (inter[0] == end) {
                /**
                 s       e
                 i[0]i[1]    e' = [1]
                 */
                end = Math.max(end, inter[1]);
            } else if (end < inter[0]) {
                /**
                 s       e
                 i[0]i[1] append<s,e> append<i>
                 discard <s,e>
                 */
                arr[j++] = new int[]{start, end};
                arr[j++] = inter;
                discard = true;
            }
        }

        // if <s,e> was not discarded, append <s,e>
        if (!discard) {
            arr[j++] = new int[]{start, end};
        }
        return Arrays.copyOf(arr, j);
    }
}
