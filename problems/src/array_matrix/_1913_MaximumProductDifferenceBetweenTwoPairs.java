package array_matrix;

// https://leetcode.com/problems/maximum-product-difference-between-two-pairs/

public class _1913_MaximumProductDifferenceBetweenTwoPairs {
    public static int maxProductDifference(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

        }
        return max1 * max2 - min1 * min2;
    }

    public static void main(String[] args) {
        int m1 = maxProductDifference(new int[]{5, 6, 2, 7, 4}); // 34
        int m2 = maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8}); // 64
    }
}
