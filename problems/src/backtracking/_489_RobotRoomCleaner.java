package backtracking;

//https://leetcode.com/problems/robot-room-cleaner/

import java.awt.*;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.HashSet;

public class _489_RobotRoomCleaner {

    // Use defined functions in interface, clean the whole room.

    public interface Robot {
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

    Robot robot;

    // LEFT, UP, RIGHT, DOWN
    final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    HashSet<Point> visited = new HashSet<>();

    private void backtracking(int x, int y, int dir) {
        robot.clean();
        visited.add(new Point(x, y));

        for (int i = 0; i < DIR.length; i++) {
            int nextX = x + DIR[dir][0];
            int nextY = y + DIR[dir][1];
            int nextDir = (dir + i) % 4;
            if (!visited.contains(new Point(nextX, nextY)) && robot.move()) {
                backtracking(nextX, nextY, nextDir);
                // go back
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtracking(0, 0, 0);
    }
}
