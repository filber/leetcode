package array_matrix;

// https://leetcode.com/problems/maximum-product-of-three-numbers/
//[Array]
public class _628_MaximumProductOfThreeNumbers {
    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n>max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n>max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n<min1) {
                min2 = min1;
                min1 = n;
            } else if (n<min2) {
                min2 = n;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

//    Constraints:
//            3 <= nums.length <= 10^4
//            -1000 <= nums[i] <= 1000
    public static void main(String[] args) {
        int p1 = new _628_MaximumProductOfThreeNumbers().maximumProduct(new int[]{1,2,3}); // 6
        int p2 = new _628_MaximumProductOfThreeNumbers().maximumProduct(new int[]{1,2,3,4}); // 24
        int p3 = new _628_MaximumProductOfThreeNumbers().maximumProduct(new int[]{-1,-2,-3}); // -6
        int p4 = new _628_MaximumProductOfThreeNumbers().maximumProduct(new int[]{-1000,-1000,-1000});

        int p5 = new _628_MaximumProductOfThreeNumbers().maximumProduct(new int[]{-100,-101,-1,2,3,4});
    }
}
