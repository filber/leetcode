package greedy;

// https://leetcode.com/problems/wiggle-sort/
// TIPS: traverse the whole array, swapping if necessary.
public class _280_WiggleSort {

    // Description:
    // Given an unsorted array nums,
    // reorder it in-place such that
    // nums[0] <= nums[1] >= nums[2] <= nums[3]....

//    Constraints:
//        1 <= nums.length <= 5 * 104
//        0 <= nums[i] <= 5000
//        It is guaranteed that there will be an answer for the given input nums.
    public static void wiggleSort(int[] nums) {
        if (nums.length<=1) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            boolean swap = false;
            if (i % 2 == 0) {
                if (nums[i]>nums[i+1]) {
                    swap = true;
                }
            } else {
                if (nums[i]<nums[i+1]) {
                    swap = true;
                }
            }

            if (swap) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{3, 5, 2, 1, 6, 4};
        wiggleSort(n1);

        int[] n2 = new int[]{1, 2, 3, 4, 5, 6};
        wiggleSort(n2);

        int[] n3 = new int[]{1};
        wiggleSort(n3);

        int[] n4 = new int[]{1,2};
        wiggleSort(n4);

        int[] n5 = new int[]{2,1};
        wiggleSort(n5);
    }
}
