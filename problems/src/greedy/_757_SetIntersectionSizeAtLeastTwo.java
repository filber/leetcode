package greedy;

import java.util.*;

//https://leetcode.com/problems/set-intersection-size-at-least-two/
public class _757_SetIntersectionSizeAtLeastTwo {

    public int intersectionSizeTwo(int[][] intervals) {
        // Sort by endings, if ending equals, handle short interval first.
        // If short interval can be covered, the long interval must be covered.
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

//        List<Integer> list = new ArrayList<>();
        int right = intervals[0][1];
        int left = right - 1;

        int count = 2;
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start <= left) {
                // cover this interval, do nothing
            }
            // one point intersects
            else if (start <= right) {
//                list.add(left);
                count++;
                left = right;
                right = end;
            }
            // no intersection
            else {
                //right < start
//                list.add(left);
//                list.add(right);
                count += 2;
                right = end;
                left = right - 1;
            }

        }

//        list.add(left);
//        list.add(right);

        return count;
    }
}
