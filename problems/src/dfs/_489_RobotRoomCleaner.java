package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _489_RobotRoomCleaner {

    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();

        void turnRight();

        // Clean the current cell.
        void clean();
    }

    private static final int[][] DIR = {
            {0, -1}, {-1, 0}, {0, 1}, {1, 0}
    };

    public void cleanRoom(Robot robot) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        dfs(robot, visited, 0, 0, 0);
    }

    private void dfs(Robot robot, Map<Integer, Set<Integer>> visited, int i, int j, int arrow) {
        Set<Integer> set = visited.computeIfAbsent(i, (k) -> new HashSet<>());
        if (set.contains(j)) {
            // visited this position before, no need to proceed
            return;
        }
        set.add(j);

        for (int k = 0; k < DIR.length; k++) {
            // get next position by referencing arrow
            int nextI = i + DIR[arrow][0];
            int nextJ = j + DIR[arrow][1];
            // move forward, position will change
            if (robot.move()) {
                dfs(robot, visited, nextI, nextJ, arrow);
                // the assumption is when recursion finished, robot will be next position with same arrow
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight(); // try next direction
            arrow = (arrow + 1) % DIR.length;
        }
    }
}
