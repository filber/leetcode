// TOPICS:
// [Bit Manipulation], [Array]
public class _1720_DecodeXORedArray {

    public static int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 0; i < arr.length-1; i++) {
            arr[i + 1] = arr[i] ^ encoded[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a1 = decode(new int[]{1,0}, 1);
        int[] a2 = decode(new int[]{1, 2, 3}, 1);
        int[] a3 = decode(new int[]{6, 2, 7, 3}, 4);
    }
}
