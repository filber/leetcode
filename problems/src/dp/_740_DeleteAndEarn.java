package dp;

//https://leetcode.com/problems/delete-and-earn/

public class _740_DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] map = new int[10001];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            map[num] += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] dp = new int[max - min + 1];
        if (dp.length == 1) {
            return map[min];
        } else if (dp.length == 2) {
            return Math.max(map[min], map[max]);
        }
        dp[0] = map[min];
        dp[1] = Math.max(map[min], map[min + 1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + map[min + i]);
        }
        return dp[dp.length - 1];
    }
}
