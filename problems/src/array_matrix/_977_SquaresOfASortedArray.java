package array_matrix;

//https://leetcode.com/problems/squares-of-a-sorted-array/

public class _977_SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int[] squares = new int[n];
        int i = n - 1;
        while (l <= r) {
            int lVal = Math.abs(nums[l]);
            int rVal = Math.abs(nums[r]);
            if (lVal >= rVal) {
                squares[i--] = lVal * lVal;
                l++;
            } else {
                squares[i--] = rVal * rVal;
                r--;
            }
        }
        return squares;
    }
}
