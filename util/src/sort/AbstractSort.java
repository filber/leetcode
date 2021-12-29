package sort;

public abstract class AbstractSort {

    public abstract int[] sort(int[] array);

    protected void swap(int[] array, int i, int j) {
        // swap
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
