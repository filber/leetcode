package sort;

public class QuickSort extends AbstractSort {

    // unstable
    // extra space: worst - O(n), best - O(log(n))
    // time complexity: worst - O(n^2), when pivot is smallest or largest.
    // best - O(n*log(n))
    public int[] sort(int[] array) {
        quickSort(array, 0, array.length);
        return array;
    }

    private void quickSort(int[] array, int start, int end) {
        if ((end - start) < 2) {
            return;
        }
        int pivot = array[start];
        int i = start;
        int j = end - 1;
        while (i < j) {
            while (array[j] > pivot && i < j) {
                j --;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            while (array[i] < pivot && i < j) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = pivot;
        quickSort(array, start, i);
        quickSort(array, i + 1, end);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {4, 5, 2, 1, 8, 0};
        quickSort.print(quickSort.sort(array));
    }
}
