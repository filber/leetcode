package pq;

//https://leetcode.com/problems/jump-game-vi/

import java.util.PriorityQueue;

public class _1696_JumpGameVI {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.add(new int[]{n - 1, dp[n - 1]});
        for (int i = n - 2; i >= 0; i--) {
            while (!pq.isEmpty() && pq.peek()[0] - i > k) {
                pq.poll();
            }
            int max = 0;
            if (!pq.isEmpty()) {
                max = pq.peek()[1];
            }
            dp[i] = max + nums[i];
            pq.add(new int[]{i, dp[i]});
        }
        return dp[0];
    }
}
