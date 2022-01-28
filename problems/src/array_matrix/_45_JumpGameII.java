package array_matrix;

// https://leetcode.com/problems/jump-game-ii/

import java.util.LinkedList;
import java.util.Queue;

public class _45_JumpGameII {

    // two pointers
    public static int jump(int[] nums) {
        int l = 0, r = 0, max = 0, count = 0;
        while (r < nums.length -1 ) {
            for (int i = l; i <= r; i++) {
                if (nums[i] + i > max) {
                    max = nums[i] + i;
                }
            }
            l = r + 1;
            r = max;
            count++;
        }
        return count;
    }

    // greedy
    public static int jumpGreedy(int[] nums) {

        int n = nums.length;
        int jumps = 0;
        int mostRightPos = 0;
        // current end position of last jump
        int curEnd = 0;

        for (int i = 0; i < n - 1; i++) {
            mostRightPos = Math.max(mostRightPos, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = mostRightPos;
                // jump out early
                if (curEnd >= nums.length - 1) {
                    return jumps;
                }
            }
        }
        return jumps;
    }

    public static int jumpBFS(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        boolean[] mem = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int jumpCnt = 1;
        int levelCnt = 1;
        int tmpCnt = 0;

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            levelCnt--;
            for (int i = nums[pos]; i >= 1; i--) {
                int targetPos = pos + i;
                if (targetPos >= n - 1) {
                    return jumpCnt;
                }
                if (targetPos < n && !mem[targetPos]) {
                    mem[targetPos] = true;
                    queue.add(targetPos);
                    tmpCnt++;
                }
            }
            if (levelCnt == 0) {
                levelCnt = tmpCnt;
                tmpCnt = 0;
                jumpCnt++;
            }
        }

        return jumpCnt;
    }

    public static void main(String[] args) {
        // 2[0-->1-->4]
        int j1 = jump(new int[]{2, 3, 1, 1, 4});
        // 2[0-->1-->4]
        int j2 = jump(new int[]{2, 3, 0, 1, 4});
        // 1[0-->2]
        int j3 = jump(new int[]{2, 0, 0});
        // 3[0-->1-->8-->11]
        int j4 = jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
        // 0
        int j5 = jump(new int[]{1});
        // 2 []
        int j6 = jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3});
    }
}
