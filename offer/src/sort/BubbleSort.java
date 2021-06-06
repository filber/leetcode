package sort;

public class BubbleSort extends AbstractSort {

    // extra space O(1)
    // time complexity O(n^2)
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    // swap
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {4, 5, 2, 1, 8, 0};
        bubbleSort.print(bubbleSort.sort(array));
    }
}
