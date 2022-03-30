package array_matrix;

//https://leetcode.com/problems/squares-of-a-sorted-array/

public class _977_SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];
        int idx = n - 1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int leftAbs = nums[l] >= 0 ? nums[l] : -nums[l];
            int rightAbs = nums[r] >= 0 ? nums[r] : -nums[r];
            if (leftAbs >= rightAbs) {
                squares[idx--] = leftAbs * leftAbs;
                l++;
            } else {
                squares[idx--] = rightAbs * rightAbs;
                r--;
            }
        }

        return squares;
    }
}
