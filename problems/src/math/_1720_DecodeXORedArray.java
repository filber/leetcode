package math;

// https://leetcode.com/problems/decode-xored-array/

public class _1720_DecodeXORedArray {

    public static int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] a1 = decode(new int[]{1, 0}, 1);
        int[] a2 = decode(new int[]{1, 2, 3}, 1);
        int[] a3 = decode(new int[]{6, 2, 7, 3}, 4);
    }
}
