package array_matrix;

// https://leetcode.com/problems/valid-mountain-array/

public class _941_ValidMountainArray {

    //    Constraints:
//            1 <= arr.length <= 104
//            0 <= arr[i] <= 104
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }

        // 0 - Start
        // 1 - UpHill
        // 2 - DownHill
        int status = 0;
        for (int i = 0; i < n; i++) {
            if (status == 0) {
                // Start
                if (arr[0] >= arr[1]) {
                    return false;
                } else {
                    status = 1;
                }
            } else if (status == 1) {
                // UpHill
                if (arr[i - 1] == arr[i]) {
                    return false;
                } else if (arr[i - 1] > arr[i]) {
                    status = 2;
                }
            } else if (status == 2) {
                // DownHill
                if (arr[i - 1] <= arr[i]) {
                    return false;
                }
            }
        }
        return status == 2;
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
