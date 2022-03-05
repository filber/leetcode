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

        int len = max - min + 1;
        if (len == 1) {
            return map[min];
        } else if (len == 2) {
            return Math.max(map[min], map[max]);
        }
        int dpPrePre = map[min];
        int dpPre = Math.max(dpPrePre, map[min + 1]);
        int dp = 0;
        for (int i = 2; i < len; i++) {
            dp = Math.max(dpPre, dpPrePre + map[min + i]);
            dpPrePre = dpPre;
            dpPre = dp;
        }
        return dp;
    }
}
