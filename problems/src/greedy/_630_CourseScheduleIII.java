package greedy;

//https://leetcode.com/problems/course-schedule-iii/

import java.util.*;

public class _630_CourseScheduleIII {

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        int count = 0;
        for (int i = 0; i < courses.length; i++) {
            int duration = courses[i][0];
            int deadline = courses[i][1];
            if (time + duration <= deadline) {
                count ++;
                pq.add(duration);
                time += duration;
            } else {
                if (!pq.isEmpty() && duration < pq.peek()
//                        && (time - pq.peek() + duration) <= deadline
                ) {
                    // replace peek
                    int peekDuration = pq.poll();
                    time = time - peekDuration + duration;
                    pq.offer(duration);
                }
            }
        }

        return count;
    }
}
