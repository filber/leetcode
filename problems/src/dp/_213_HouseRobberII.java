package dp;

//https://leetcode.com/problems/house-robber-ii/

public class _213_HouseRobberII {
    public static int rob(int[] nums) {
        int n =nums.length;
        if (n==1) {
            return nums[0];
        }

        int[] dpWithFirst = new int[n + 1];
        dpWithFirst[0] = 0;
        dpWithFirst[1] = nums[0];
        for (int i = 1; i < n-1; i++) {
            dpWithFirst[i + 1] = Math.max(dpWithFirst[i], dpWithFirst[i - 1] + nums[i]);
        }

        int[] dpWithLast = new int[n + 1];
        dpWithLast[0] = 0;
        dpWithLast[1] = nums[1]; // without first
        for (int i = 2; i < n; i++) {
            dpWithLast[i] = Math.max(dpWithLast[i - 1], dpWithLast[i - 2] + nums[i]);
        }

        int max = Math.max(dpWithFirst[n-1],dpWithLast[n-1]);
        return max;
    }

    public static void main(String[] args) {
        int r1 = rob(new int[]{2, 3, 2}); // 3
        int r2 = rob(new int[]{1, 2, 3, 1}); //4
        int r3 = rob(new int[]{1, 2, 3}); //3

    }
}
