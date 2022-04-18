package array_matrix;

//https://www.geeksforgeeks.org/maximum-distinct-elements-removing-k-elements/

import java.util.Arrays;

public class _EX_SumOfElements {

    public int sumBetweenTwoKth(int arr[], int k1, int k2) {
        if (k1 + 1 == k2) {
            return 0;
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = k1; i < k2 - 1; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
