package dp;

//https://leetcode.com/problems/delete-and-earn/

public class _740_DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] map = new int[10001];
        for (int num : nums) {
            map[num] += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] dp = new int[max - min + 2];
        dp[0] = 0;
        dp[1] = map[min];
        for (int i = 2; i < dp.length; i++) {
            int num = min + i - 1;
            int sum = map[num];
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum);
        }
        return dp[dp.length - 1];
    }
}
