package array_matrix;

//https://leetcode.com/problems/minimize-deviation-in-array/

public class _1675_MinimizeDeviationInArray {

    // Constraints:
    //    n == nums.length
    //    2 <= n <= 10^5
    //    1 <= nums[i] <= 10^9
    public int minimumDeviation(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] *= 2;
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int deviation = max - min;
        while (max % 2 == 0) {
            int tmin = Integer.MAX_VALUE;
            int tmax = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (nums[i] == max || (nums[i] % 2 == 0 && min <= nums[i] / 2)) {
                    nums[i] /= 2;
                }
                if (nums[i] < tmin) {
                    tmin = nums[i];
                }
                tmin = Math.min(tmin, nums[i]);
                if (nums[i] > tmax) {
                    tmax = nums[i];
                }
            }
            if ((tmax - tmin) < deviation) {
                deviation = tmax - tmin;
            }
            max = tmax;
            min = tmin;
        }
        return deviation;
    }
}
