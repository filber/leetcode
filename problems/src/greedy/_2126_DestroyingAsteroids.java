package greedy;

import java.util.Arrays;

// https://leetcode.com/problems/destroying-asteroids/
public class _2126_DestroyingAsteroids {

    public static boolean asteroidsDestroyed(int mass, int[] ast) {
        int n = ast.length;
        Arrays.sort(ast);
        for (int i = 0; i < n; i++) {
            if (mass<ast[i]) {
                return false;
            } else {
                mass += ast[i];
                if (mass < 0) {
                    // overflow
                    return true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b1 = asteroidsDestroyed(10, new int[]{3, 9, 19, 5, 21}); // true

        boolean b2 = asteroidsDestroyed(5, new int[]{4, 9, 23, 4}); // false
    }
}
