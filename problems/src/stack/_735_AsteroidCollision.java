package stack;

// https://leetcode.com/problems/asteroid-collision/
import java.util.Stack;

public class _735_AsteroidCollision {

    public static int[] asteroidCollision(int[] ast) {
        int n = ast.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if (stack.isEmpty()) {
                stack.push(ast[i]);
                i++;
            } else {
                int peek = stack.peek();
                int pAbs = Math.abs(peek);
                int aAbs = Math.abs(ast[i]);
                if ((peek > 0 && ast[i] > 0) || (peek < 0 && ast[i] < 0) ||
                        (peek < 0 && ast[i] > 0)) {
                    // same signal
                    stack.push(ast[i]);
                    i++;
                } else if (pAbs == aAbs) {
                    // different signal, destroy each other
                    stack.pop();
                    i++;
                } else if (pAbs > aAbs) {
                    // stack peek is larger
                    i++;
                } else {
                    // stack peek is smaller
                    stack.pop();
                }
            }
        }

        int[] ans = new int[stack.size()];
        for (int j = 0; j < stack.size(); j++) {
            ans[j] = stack.elementAt(j);
        }
        return ans;
    }

    public static void main(String[] args) {
        // [5, 10]
        int[] a1 = asteroidCollision(new int[]{5, 10, -5});

        // []
        int[] a2 = asteroidCollision(new int[]{8, -8});

        // [10]
        int[] a3 = asteroidCollision(new int[]{10, 2, -5});

        // [-20,-1]
        int[] a4 = asteroidCollision(new int[]{10, 2, -5, -20, -1});

        // [-2,-1,1,2]
        int[] a5 = asteroidCollision(new int[]{-2, -1, 1, 2});
    }
}
