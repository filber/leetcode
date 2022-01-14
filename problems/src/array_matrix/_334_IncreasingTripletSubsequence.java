package array_matrix;

public class _334_IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n<=min) {
                min = n;
            } else if (n>min && n <= max) {
                max = n;
            } else {
                // n > max
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b1 = increasingTriplet(new int[]{1, 2, 3, 4, 5});
        boolean b2 = increasingTriplet(new int[]{5, 4, 3, 2, 1});
        boolean b3 = increasingTriplet(new int[]{2, 1, 5, 0, 4, 6});
        boolean b4 = increasingTriplet(new int[]{2, 1, 5, 0, 6});
    }
}
