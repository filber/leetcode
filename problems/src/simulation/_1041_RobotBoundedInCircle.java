package simulation;

//https://leetcode.com/problems/robot-bounded-in-circle/
public class _1041_RobotBoundedInCircle {
    public static boolean isRobotBounded(String instructions) {
        // north--0
        // west--1
        // south--2
        // east--3
        // Turn Left: direction = (direction + 1) % 4
        // Turn Right: direction = (direction - 1 + 4) % 4
        // facing north(0) at (0,0)
        int[][] dVec = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int[] vector = new int[]{0, 0, 0};
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            switch (ch) {
                case 'G':
                    int[] move = dVec[vector[2]];
                    vector[0] += move[0];
                    vector[1] += move[1];
                    break;
                case 'L':
                    vector[2] = (vector[2] + 1) % 4;
                    break;
                case 'R':
                    vector[2] = (vector[2] + 3) % 4;
                    break;
            }
        }

        if (vector[0]==0&&vector[1]==0) {
            return true;
        } else if (vector[2] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean i1 = isRobotBounded("GGLLGG");
        boolean i2 = isRobotBounded("GG");
        boolean i3 = isRobotBounded("GL");
    }

}
