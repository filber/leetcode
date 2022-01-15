package dp;

// https://leetcode.com/problems/jump-game-ii/

public class _45_JumpGameII {

    // greedy
    public static int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int[] curFarthest = new int[n];
        // current end position
        int curEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest[i] = Math.max(
                    i == 0 ? 0 : curFarthest[i - 1],
                    i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest[i];

                // jump out early
                if (curEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }

    public static int jumpBS(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
        }

        int cnt = 0;
        int l = 0, r = n - 2;
        int target = n - 1;
        while (l < r) {

            while (l < r) {
                int mid = (l + r) / 2;
                int midVal = dp[mid];
                if (midVal < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }

            }
            target = l;
            l = 0;
            r -= 1;
            if (r>=0) {
                cnt++;
            }
        }

        return cnt + 1;
    }

    public static void main(String[] args) {
        int j1 = jump(new int[]{2,3,1,1,4}); // 2
        int j2 = jump(new int[]{2,3,0,1,4}); // 2
        int j3 = jump(new int[]{2, 0, 0}); // 1
        int j4 = jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}); // 3
        int j5 = jump(new int[]{1}); // 0
    }
}
