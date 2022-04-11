package math;

import java.util.Arrays;
import java.util.Random;

public class _384_ShuffleAnArray {

    int[] origin;
    int[] shuffled;
    int n;

    public void init(int[] nums) {
        this.origin = nums;
        n = nums.length;
        shuffled = Arrays.copyOf(nums, n);
    }

    public int[] reset() {
        return this.origin;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n);
            int tmp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = tmp;
        }
        return shuffled;
    }
}
