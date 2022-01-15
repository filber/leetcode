package dfs;

// https://leetcode.com/problems/jump-game-iii/
public class _1306_JumpGameIII {

    public static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, visited, start);
    }

    private static boolean dfs(int[] arr, boolean[] visited, int start) {
        // 0. Guard condition
        if (start < 0 || start >= arr.length) {
            return false;
        }
        if (visited[start] == true) {
            return false;
        }

        // 1. Termination
        if (arr[start] == 0) {
            return true;
        }

        visited[start] = true;

        // try left
        boolean visitLeft = dfs(arr, visited, start - arr[start]);
        if (visitLeft) {
            return true;
        }
        // try right
        boolean visitRight = dfs(arr, visited, start + arr[start]);
        if (visitRight) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b1 = canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5); // true
        boolean b2 = canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0); // true
        boolean b3 = canReach(new int[]{3, 0, 2, 1, 2}, 2); // false
        boolean b4 = canReach(new int[]{0}, 0); // true
        boolean b5 = canReach(new int[]{1}, 0); // false
    }
}
