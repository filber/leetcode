public class _169_MajorityElement {

    // solve the problem in linear time and in O(1) space
    public static int majorityElement(int[] nums) {
        int item = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counter==0) {
                item = nums[i];
                counter++;
            } else {
                if (nums[i] == item) {
                    counter++;
                } else {
                    counter--;
                }
            }
        }
        return item;
    }

    public static void main(String[] args) {
//        Input: nums = [3,2,3]
//        Output: 3
//        int[] array1 = new int[]{3, 2, 3};
//        majorityElement(array1);

//        Input: nums = [2,2,1,1,1,2,2]
//        Output: 2
        int[] array2 = new int[]{2, 2, 1, 1, 1, 2, 2};
        majorityElement(array2);
    }
}
