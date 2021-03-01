import java.util.Arrays;

public class _312_BurstBalloons {

//    Constraints:
//        n == nums.length
//        1 <= n <= 500
//        0 <= nums[i] <= 100

    public static int maxCoinsV1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                int[] subNums = Arrays.copyOfRange(nums, 1, nums.length);
                max = Math.max(max, maxCoins(subNums) + nums[0] * nums[1]);
            } else if (i == nums.length - 1) {
                int[] subNums = Arrays.copyOfRange(nums, 0, nums.length - 1);
                max = Math.max(max, maxCoins(subNums) + nums[nums.length - 1] * nums[nums.length - 2]);
            } else {
                int[] subNums = new int[nums.length - 1];
                for (int j = 0; j < i; j++) {
                    subNums[j] = nums[j];
                }
                for (int j = i + 1; j < nums.length; j++) {
                    subNums[j - 1] = nums[j];
                }
                max = Math.max(max,
                        maxCoins(subNums) +
                                nums[i - 1] * nums[i] * nums[i + 1]);
            }
        }
        return max;
    }

    public static int maxCoinsV2(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        int[] copy = new int[nums.length + 2];
        copy[0] = 1;
        copy[copy.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            copy[i + 1] = nums[i];
        }
        return recursive(copy, 1, nums.length, dp);
    }

    // burst all ballons from i to j (inclusive)
    public static int recursive(int[] nums, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        for (int k = i; k <= j; k++) {
            // 注意：k=i和k=j时，只点爆了一侧，另一侧递归返回0了
            int left = recursive(nums, i, k - 1, dp);
            int right = recursive(nums, k + 1, j, dp);
            // k是最后一个被引爆点，此时i~j之内其他气球都引爆了，
            // 只能引爆nums[i - 1]与nums[j + 1]
            int current = nums[k] * nums[i - 1] * nums[j + 1];
            dp[i][j] = Math.max(dp[i][j], left + right + current);
        }

        return dp[i][j];
    }

    public static int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] copy = new int[nums.length + 2];
        copy[0] = 1;
        copy[copy.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            copy[i + 1] = nums[i];
        }

        for (int len = 1; len <= nums.length; len++) {
            for (int i = 1; i <= (nums.length - len + 1); i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] +
                            copy[i - 1] * copy[k] * copy[j + 1]
                    );
                }
            }
        }
        return dp[1][nums.length];
    }

    public static void main(String[] args) {
//        Input: nums = [3,1,5,8]
//        Output: 167
//        Explanation:
//        nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//        coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
        int max = maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(max);

//        Input: nums = [1,5]
//        Output: 10
        max = maxCoins(new int[]{1, 5});
        System.out.println(max);
    }
}
