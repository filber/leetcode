package backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _489_RobotRoomCleanerTest {

    _489_RobotRoomCleaner target;

    @Before
    public void setUp() throws Exception {
        target = new _489_RobotRoomCleaner();
    }

    static class RobotImpl implements _489_RobotRoomCleaner.Robot {
        int[][] grid;
        int x;
        int y;
        int dir;

        // LEFT, UP, RIGHT, DOWN
        final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        RobotImpl(int[][] grid, int x, int y, int dir) {
            this.grid = grid;
        }

        @Override
        public boolean move() {
            int nextX = x + DIR[dir][0];
            int nextY = y + DIR[dir][1];
            if (nextX < 0 || nextX == grid.length || nextY < 0 || nextY == grid[0].length) {
                return false;
            }
            x = nextX;
            y = nextY;
            return true;
        }

        @Override
        public void turnLeft() {
            dir -= 1;
            dir = dir % 4;
        }

        @Override
        public void turnRight() {
            dir += 1;
            dir = dir % 4;
        }

        @Override
        public void clean() {
            grid[x][y] = 0;
        }
    }

    @Test
    public void testCleanRoom1() {
        int[][] grid = {
                {1, 1},
                {0, 1},
        };
        RobotImpl robot = new RobotImpl(grid, 0, 0, 2);
        target.cleanRoom(robot);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                assertEquals(0, grid[i][j]);
            }
        }
    }

    @Test
    public void testCleanRoom2() {
        int[][] grid = {
                {1, 1, 1, 1},
                {0, 1, 0, 0},
        };
        RobotImpl robot = new RobotImpl(grid, 1, 1, 2);
        target.cleanRoom(robot);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                assertEquals(0, grid[i][j]);
            }
        }
    }
}