package array_matrix;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/majority-element-ii/
public class _229_MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {
        // Moore Voting
        int x = Integer.MIN_VALUE, y = Integer.MAX_VALUE, cx = 0, cy = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] == x || cx == 0) && nums[i] != y) {
                x = nums[i];
                cx ++;
            } else if (nums[i] == y || cy == 0) {
                y = nums[i];
                cy ++;
            } else {
                cx --;
                cy --;
            }
        }
        cx = 0;
        cy = 0;
        List<Integer> result = new LinkedList<>();
        for (int num: nums) {
            if (num == x) {
                cx ++;
            } else if (num==y) {
                cy ++;
            }
        }
        if (cx > (nums.length / 3)) {
            result.add(x);
        }
        if (cy > (nums.length / 3)) {
            result.add(y);
        }

        return result;
    }

    public static void main(String[] args) {
        // 3
        List one = majorityElement(new int[]{3, 2, 3});
        // 1
        List two = majorityElement(new int[]{1});
        // 1, 2
        List three = majorityElement(new int[]{1, 2});
    }
}
