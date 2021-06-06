package sort;

public class MergeSort extends AbstractSort {

    // extra space O(n)
    // time complexity: worst - O(n*log(n)), best - O(n*log(n))
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] temp = new int[array.length];
        sort(array, 0, array.length, temp);
        return array;
    }

    private void sort(int[] array, int start, int end, int[] temp) {
        if ((end - start) > 1) {
            int mid = (start + end) / 2;
            sort(array, start, mid, temp);
            sort(array, mid, end, temp);
            merge(array, start, mid, end, temp);
        }
    }

    private void merge(int[] array, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid;
        int tempIndex = 0;
        while (i < mid && j < end) {
            if (array[i]<array[j]) {
                temp[tempIndex] = array[i];
                i++;
            }else {
                temp[tempIndex] = array[j];
                j++;
            }
            tempIndex++;
        }
        while (i<mid) {
            temp[tempIndex] = array[i];
            i++;
            tempIndex++;
        }
        while (j<end) {
            temp[tempIndex] = array[j];
            j++;
            tempIndex++;
        }
        tempIndex=0;
        for (int k = start; k < end; k++) {
            array[k] = temp[tempIndex];
            tempIndex++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = {4, 5, 2, 1, 8, 0};
        mergeSort.print(mergeSort.sort(array));
    }
}
