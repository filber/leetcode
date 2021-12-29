//TOPICS:
//[Math],[Two Pointers]

public class _1913_MaximumProductDifferenceBetweenTwoPairs {
    public static int maxProductDifference(int[] nums) {
        int max1 = nums[0], max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = nums[0];

        for (int n : nums) {
            if (max2 <= n) {
                max1 = max2;
                max2 = n;
            } else if (max1 <= n) {
                max1 = n;
            }

            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
        }
        return max2*max1 - min1*min2;
    }

    public static void main(String[] args) {
        int m1 = maxProductDifference(new int[]{5,6,2,7,4}); // 34
        int m2 = maxProductDifference(new int[]{4,2,5,9,7,4,8}); // 64
    }
}
