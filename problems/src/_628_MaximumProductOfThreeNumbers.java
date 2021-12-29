
//TOPICS:
//[Math]
public class _628_MaximumProductOfThreeNumbers {
    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int v : nums) {
            if (v > max1) {
                max3 = max2;
                max2 = max1;
                max1 = v;
            } else if (v > max2) {
                max3 = max2;
                max2 = v;
            } else if (v > max3) {
                max3 = v;
            }

            if (v < min1) {
                min2 = min1;
                min1 = v;
            } else if (v < min2) {
                min2 = v;
            }
        }
        int tmp1 = max1 * max2 * max3;
        int tmp2 = min1 * min2 * max1;
        return Math.max(tmp1, tmp2);
    }

//    Constraints:
//            3 <= nums.length <= 10^4
//            -1000 <= nums[i] <= 1000
    public static void main(String[] args) {
        int p1 = new _628_MaximumProductOfThreeNumbers().maximumProduct(new int[]{1,2,3}); // 6
        int p2 = new _628_MaximumProductOfThreeNumbers().maximumProduct(new int[]{1,2,3,4}); // 24
        int p3 = new _628_MaximumProductOfThreeNumbers().maximumProduct(new int[]{-1,-2,-3}); // -6
        int p4 = new _628_MaximumProductOfThreeNumbers().maximumProduct(new int[]{-1000,-1000,-1000});
    }
}
