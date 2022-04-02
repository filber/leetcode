package array_matrix;

// https://leetcode.com/problems/sort-transformed-array/

public class _360_SortTransformedArray {
    // Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
    // The returned array must be in sorted order.
    // Expected time complexity: O(n)

    int a;
    int b;
    int c;

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        double center = -b / (2 * (double) a);
        int n = nums.length;
        int[] ans = new int[n];
        int i;
        int dir;
        if (a > 0) {
            i = n - 1;
            dir = -1;
        } else {
            i = 0;
            dir = 1;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            double dL = Math.abs(nums[l] - center);
            double dR = Math.abs(nums[r] - center);
            if (dL >= dR) {
                ans[i] = f(nums[l++]);
            } else {
                ans[i] = f(nums[r--]);
            }
            i += dir;
        }

        return ans;
    }

    public int f(int x) {
        return a * x * x + b * x + c;
    }
}
