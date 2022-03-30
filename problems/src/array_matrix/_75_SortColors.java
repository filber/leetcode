package array_matrix;

public class _75_SortColors {

    public void sortColors(int[] nums) {
        int n = nums.length - 1;
        int zeroCnt = 0, oneCnt = 0, twoCnt = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCnt++;
            } else if (num == 1) {
                oneCnt++;
            } else {
                twoCnt++;
            }
        }
        int idx = 0;
        while (zeroCnt > 0) {
            nums[idx++] = 0;
            zeroCnt--;
        }
        while (oneCnt > 0) {
            nums[idx++] = 1;
            oneCnt--;
        }
        while (twoCnt > 0) {
            nums[idx++] = 2;
            twoCnt--;
        }
    }
}
