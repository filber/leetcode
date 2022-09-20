package stack;

// https://leetcode.com/problems/asteroid-collision/

import java.util.Arrays;

public class _735_AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;
        int i = 0;
        while (i < asteroids.length) {
            int ast = asteroids[i];
            if (top == -1) {
                stack[++top] = ast;
                i++;
            } else if (stack[top] > 0 && ast > 0 ||
                    stack[top] < 0) {
                stack[++top] = ast;
                i++;
            } else if (stack[top] > -ast) {
                // do nothing
                i++;
            } else if (stack[top] == -ast) {
                top--;
                i++;
            } else {
                top--;
            }
        }

        return Arrays.copyOf(stack, top + 1);
    }
}
