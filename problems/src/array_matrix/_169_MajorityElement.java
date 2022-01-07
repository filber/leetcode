package array_matrix;

//https://leetcode.com/problems/find-peak-element/
public class _169_MajorityElement {

    public static int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count++;
            } else {
                if (nums[i] == majority) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int m1 = majorityElement(new int[]{3, 2, 3});
        int m2 = majorityElement(new int[]{3});
        int m3 = majorityElement(new int[]{3, 2, 2});
        int m4 = majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        int m5 = majorityElement(new int[]{2, 2, 2, 1, 1});
    }
}
