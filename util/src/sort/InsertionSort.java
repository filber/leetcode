package sort;

public class InsertionSort extends AbstractSort {

    // extra space O(1)
    // time complexity: worst - O(n^2), best - O(n)
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                } else {
                    // stop moving to left
                    break;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {4, 5, 2, 1, 8, 0};
        insertionSort.print(insertionSort.sort(array));
    }
}
