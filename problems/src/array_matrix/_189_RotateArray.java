package array_matrix;

// https://leetcode.com/problems/rotate-array/
public class _189_RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] n1 = {1, 2, 3, 4, 5, 6, 7};
        rotate(n1, 3);

        int[] n2 = {-1, -100, 3, 99};
        rotate(n2, 2);

        int[] n3 = {1, 2, 3, 4, 5, 6};
        rotate(n3, 4);
    }
}
