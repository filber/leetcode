package array_matrix;

//https://leetcode.com/problems/remove-element/

public class _27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int l = 0,r=0;
        while(r<nums.length) {
            if(nums[r]!=val) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}
