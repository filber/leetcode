package greedy;

//https://leetcode.com/problems/course-schedule-iii/

import java.util.*;

public class _630_CourseScheduleIII {

    public static int scheduleCourse(int[][] courses) {
        int currentTime = 0;
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int[] cur : courses) {
            if (currentTime + cur[0] <= cur[1]) {
                pq.offer(cur[0]);
                currentTime += cur[0];
            } else if (!pq.isEmpty() && pq.peek() > cur[0]) {
                currentTime -= pq.poll();
                currentTime += cur[0];
                pq.offer(cur[0]);
            }
        }

        return pq.size();
    }

    public static void main(String[] args) {
        // 3
        int c1 = scheduleCourse(new int[][]{
                {2000, 3200}, {1000, 1250}, {100, 200}, {200, 1300},
        });

        // 4
        int c2 = scheduleCourse(new int[][]{
                {2, 5}, {2, 19}, {1, 8}, {1, 3},
        });

        // 1
        int c3 = scheduleCourse(new int[][]{
                {1, 2}
        });

        // 0
        int c4 = scheduleCourse(new int[][]{
                {3, 2}, {4, 3}
        });
    }
}
