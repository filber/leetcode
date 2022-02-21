package array_matrix;

//https://leetcode.com/problems/find-peak-element/
public class _169_MajorityElement {

    public static int majorityElement(int[] nums) {
        int majority = 0;
        int cnt = 0;
        for (int num:nums) {
            if (cnt == 0) {
                majority = num;
                cnt = 1;
            } else if (num == majority) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return majority;
    }

}
