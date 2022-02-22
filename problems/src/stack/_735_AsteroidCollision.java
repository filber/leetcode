package stack;

// https://leetcode.com/problems/asteroid-collision/

import java.util.Stack;

public class _735_AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        while (idx < asteroids.length) {
            int ast = asteroids[idx];
            if (stack.isEmpty()) {
                stack.push(ast);
                idx++;
            } else if ((stack.peek() < 0 && ast < 0)
                    || (stack.peek() > 0 && ast > 0)
                    || (stack.peek() < 0 && ast > 0)) {
                stack.push(ast);
                idx++;
            } else if (stack.peek() + ast > 0) {
                idx++;
            } else if (stack.peek() + ast == 0) {
                stack.pop();
                idx++;
            } else {
                stack.pop();
            }
        }

        int[] ans = new int[stack.size()];
        idx = 0;
        for (int ast : stack) {
            ans[idx++] = ast;
        }
        return ans;
    }
}
