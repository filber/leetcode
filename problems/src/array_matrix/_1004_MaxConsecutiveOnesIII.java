package array_matrix;

// https://leetcode.com/problems/max-consecutive-ones-iii/
// Use Sliding Window to calculate the longest ones
public class _1004_MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int max = 0;
        int winState = 0;
        while (r < nums.length) {
            if (nums[r]==1) {
                r++;
            } else {
                if (winState<k) {
                    r++;
                    winState++;
                } else {
                    if (nums[l]==0) {
                        winState--;
                    }
                    l++;
                }
            }
            max = Math.max(max, r - l);
        }
        return max;
    }

    public static void main(String[] args) {
        int l1 = longestOnes(new int[]{
                1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2); // 6
        int l2 = longestOnes(new int[]{
                0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1
        }, 3); // 10
        int l3 = longestOnes(new int[]{
                1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 0); // 4
        int l4 = longestOnes(new int[]{
                1}, 0); // 1
        int l5 = longestOnes(new int[]{
                0}, 0); // 0
        int l6 = longestOnes(new int[]{
                0}, 1); // 1
        int l7 = longestOnes(new int[]{
                0,1}, 1); // 2
        int l8 = longestOnes(new int[]{
                0,0}, 1); // 1

    }
}
