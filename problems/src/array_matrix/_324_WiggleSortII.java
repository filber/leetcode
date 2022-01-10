package array_matrix;

import java.util.Arrays;

// https://leetcode.com/problems/wiggle-sort-ii/
public class _324_WiggleSortII {


//    Constraints:
//        1 <= nums.length <= 5 * 104
//        0 <= nums[i] <= 5000
//        It is guaranteed that there will be an answer for the given input nums.
    public static void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int[] copy  = Arrays.copyOf(nums,nums.length);
        Arrays.sort(copy);
        int leftIndex = nums.length/2 -1;
        if (nums.length % 2 != 0) {
            leftIndex++;
        }
        int rightIndex = nums.length -1;

        int i = 0;
        int count = nums.length/2;
        while (count > 0) {
            nums[i++] = copy[leftIndex--];
            nums[i++] = copy[rightIndex--];
            count--;
        }
        if (i == nums.length - 1) {
            nums[i] = copy[leftIndex];
        }
    }

    public static void main(String[] args) {
        int[] n1 = {1, 1, 1, 5, 6, 4};
        wiggleSort(n1);

        int[] n2 = {1, 3, 2, 2, 3, 1};
        wiggleSort(n2);

        int[] n3 = {1};
        wiggleSort(n3);

        int[] n4 = {1,2,3};
        wiggleSort(n4);

        int[] n5 = {1,2};
        wiggleSort(n5);

        int[] n6 = {2,1};
        wiggleSort(n6);

        int[] n7 = {5,5,5,4,4,4,4};
        wiggleSort(n7);

        int[] n8 = {1, 2, 4, 4,4, 6};
        wiggleSort(n8);

        int[] n9 = {2,4,2,4,1,3,1,3,1,3,1,3,3};
        wiggleSort(n9);
    }
}
