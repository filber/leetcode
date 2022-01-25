package array_matrix;

// https://leetcode.com/problems/valid-mountain-array/

public class _941_ValidMountainArray {

    //    Constraints:
//            1 <= arr.length <= 104
//            0 <= arr[i] <= 104
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3 || arr[0] >= arr[1]) {
            return false;
        }

        boolean findPeak = false;
        for (int i = 2; i < n; i++) {
            if (!findPeak) {
                if (arr[i - 1] > arr[i]) {
                    findPeak = true;
                } else if (arr[i - 1] == arr[i]) {
                    return false;
                }
            } else {
                if (arr[i - 1] <= arr[i]) {
                    return false;
                }
            }
        }

        return findPeak;
    }

    public static void main(String[] args) {
        // false
        boolean b1 = validMountainArray(new int[]{2, 1});
        // false
        boolean b2 = validMountainArray(new int[]{3, 5, 5});
        // true
        boolean b3 = validMountainArray(new int[]{0, 3, 2, 1});
        // true
        boolean b4 = validMountainArray(new int[]{0, 2, 3, 4, 5, 2, 1, 0});
        // false, no peak!
        boolean b5 = validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
