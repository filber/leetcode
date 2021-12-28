public class _1539_KthMissingPositiveNumber {
//    Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//    Find the kth positive integer that is missing from this array.
//    Constraints:
//    1 <= arr.length <= 1000
//    1 <= arr[i] <= 1000
//    1 <= k <= 1000
//    arr[i] < arr[j] for 1 <= i < j <= arr.length

    public static int findKthPositive(int[] arr, int k) {
        int supposed = 1;
        int pointer = 0;
        while (pointer < arr.length && k > 0) {
            if (arr[pointer] != supposed) {
                // missing
                k--;
            } else {
                pointer++;
            }
            if (k == 0) {
                return supposed;
            } else {
                supposed++;
            }
        }
        return arr[arr.length - 1] + k;
    }

    public static void main(String[] args) {
//        Input: arr = [2,3,4,7,11], k = 5
//        Output: 9
//        The missing positive integers are [1,5,6,8,9,10,12,13,...].
//        The 5th missing positive integer is 9.
        System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
//        Input: arr = [1,2,3,4], k = 2
//        Output: 6
//        The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
        System.out.println(findKthPositive(new int[]{1,2,3,4}, 2));
    }
}
