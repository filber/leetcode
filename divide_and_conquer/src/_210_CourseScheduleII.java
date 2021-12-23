import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class _210_CourseScheduleII {
    public enum Status {
        NotLearned,
        TryToLearn,
        Learned
    }
    private static final int[] EMPTY_ARRAY = {};

    Status[] courseStatus;
    HashMap<Integer, LinkedList<Integer>> coursePrerequisites = new HashMap<>();
    Stack<Integer> stack = new Stack<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. Construct Status & Graph
        courseStatus = new Status[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // set all status to NotLearned
            courseStatus[i] = Status.NotLearned;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            // add prerequisites
            if (!coursePrerequisites.containsKey(course)) {
                LinkedList<Integer> preCourses = new LinkedList<>();
                preCourses.add(pre);
                coursePrerequisites.put(course,preCourses);
            } else {
                coursePrerequisites.get(course).add(pre);
            }
        }

        // 2. Iterate all courses
        for (int i = 0; i < courseStatus.length; i++) {
            if (!learnCourse(i)) {
                // failed to learn the course
                return EMPTY_ARRAY;
            }
        }

        // 3. Reverse stack
        int[] sequence = new int[numCourses];
        for (int i = sequence.length-1; i >=0; i--) {
            sequence[i] = stack.pop();
        }
        return sequence;
    }


    public boolean learnCourse(int course) {
        Status status = courseStatus[course];
        if (Status.Learned.equals(status)) {
            // already learned
            return true;
        } else if (Status.TryToLearn.equals(status)) {
            // circle detected
            return false;
        } else {
            // not learned
            if (coursePrerequisites.containsKey(course)) {
                courseStatus[course] = Status.TryToLearn;
                // this course has prerequisites
                for (int pre : coursePrerequisites.get(course)) {
                    if (!learnCourse(pre)) {
                        // failed to learn
                        return false;
                    }
                }
            }
            // learn the course
            courseStatus[course] = Status.Learned;
            stack.push(course);
        }
        return true;
    }

    public static void main(String[] args) {
        _210_CourseScheduleII s1 = new _210_CourseScheduleII();
        int[] o1 = s1.findOrder(2, new int[][]{{1, 0}});

        _210_CourseScheduleII s2 = new _210_CourseScheduleII();
        int[] o2 = s2.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});

        _210_CourseScheduleII s3 = new _210_CourseScheduleII();
        int[] o3 = s1.findOrder(1, new int[][]{});

        _210_CourseScheduleII s4 = new _210_CourseScheduleII();
        int[] o4 = s4.findOrder(2, new int[][]{{1, 0},{0,1}});

        _210_CourseScheduleII s5 = new _210_CourseScheduleII();
        int[] o5 = s5.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {0, 3}});
    }
}
