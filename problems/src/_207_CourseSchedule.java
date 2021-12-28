import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _207_CourseSchedule {
    public enum Status {
        NotLearned,
        TryToLearn,
        Learned
    }

    // store all courses' status
    HashMap<Integer,Status> courseStatus = new HashMap<>();
    // just store courses which have prerequisites
    HashMap<Integer, LinkedList<Integer>> coursePrerequisites = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 1. Construct Graph
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];

            // 1.1. Add courses' status
            if (!courseStatus.containsKey(course)) {
                courseStatus.put(course,Status.NotLearned);
            }
            if (!courseStatus.containsKey(preCourse)) {
                courseStatus.put(preCourse,Status.NotLearned);
            }

            // 1.1. Add prerequisite to graph
            if (!coursePrerequisites.containsKey(course)) {
                LinkedList<Integer> preCourses = new LinkedList<>();
                preCourses.add(preCourse);
                coursePrerequisites.put(course,preCourses);
            } else {
                LinkedList<Integer> preCourses = coursePrerequisites.get(course);
                preCourses.add(preCourse);
            }
        }

        // 2. Iterate all courses
        for (int course : courseStatus.keySet()) {
            if (!learnCourse(course)) {
                // failed to learn
                return false;
            }
        }

        // All courses have been learned
        return true;
    }

    private boolean learnCourse(int course) {
        Status status = courseStatus.get(course);
        // 2.1. Already learned
        if (Status.Learned.equals(status)) {
            return true;
        }
        // 2.2. The course has already been marked as TryToLearn
        else if (Status.TryToLearn.equals(status)) {
            // A circle has been detected and return false.
            return false;
        }
        // 2.2. Learn this course
        else {
            // The course has prerequisites
            if (coursePrerequisites.containsKey(course)) {
                // Mark the course as TryToLearn, then iterate all it's prerequisites
                courseStatus.put(course,Status.TryToLearn);
                for (int pre : coursePrerequisites.get(course)) {
                    // failed to learn pre
                    if (!learnCourse(pre)) {
                        return false;
                    }
                }
            }
            // Mark the course as Learned
            courseStatus.put(course,Status.Learned);
            return true;
        }
    }

    public static void main(String[] args) {
        _207_CourseSchedule s1 = new _207_CourseSchedule();
        boolean f1 = s1.canFinish(2, new int[][]{{1, 0}});

        _207_CourseSchedule s2 = new _207_CourseSchedule();
        boolean f2 = s2.canFinish(2, new int[][]{{1, 0}, {0, 1}});

        _207_CourseSchedule s3 = new _207_CourseSchedule();
        boolean f3 = s3.canFinish(2, new int[][]{});

        _207_CourseSchedule s4 = new _207_CourseSchedule();
        boolean f4 = s4.canFinish(2, new int[][]{
                {1,0},
                {1,4},
                {0,3},
                {4,3},
        });

        _207_CourseSchedule s5 = new _207_CourseSchedule();
        boolean f5 = s5.canFinish(2, new int[][]{
                {1,0},
                {1,4},
                {0,3},
                {4,3},
                {3,1},
        });
    }
}
