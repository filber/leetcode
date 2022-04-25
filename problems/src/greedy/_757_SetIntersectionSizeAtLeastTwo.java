package greedy;

import java.util.*;

//https://leetcode.com/problems/set-intersection-size-at-least-two/
public class _757_SetIntersectionSizeAtLeastTwo {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int[] firstInter = intervals[0];
        int b = firstInter[firstInter.length - 1];
        int a = b - 1;
        int cnt = 2;
        for (int i = 1; i < intervals.length; i++) {
            int[] inter = intervals[i];
            int start = inter[0];
            if (b < start) {
                // no intersections
                cnt += 2;
                b = inter[inter.length - 1];
                a = b - 1;
            } else if (a < start && start <= b) {
                cnt += 1;
                a = b;
                b = inter[inter.length - 1];
            }
//            else {
//                >= 2 intersections
//                start<=a
//            }
        }
        return cnt;
    }
}
