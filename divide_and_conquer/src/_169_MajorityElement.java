public class _169_MajorityElement {

    public static int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count==0) {
                result = nums[i];
                count++;
                continue;
            }
            if (nums[i] == result) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 3
        System.out.println(majorityElement(new int[]{3, 2, 3}));

        // 2
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
