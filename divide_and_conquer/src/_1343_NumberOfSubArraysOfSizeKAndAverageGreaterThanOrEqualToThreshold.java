// TOPICS:
// [Sliding Window],[String]
public class _1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        threshold = k * threshold;

        int sum = 0;
        int cnt = 0;
        // init first window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= threshold) {
            cnt++;
        }

        // move window to right
        for (int winStart = 1; winStart <= arr.length-k; winStart++) {
            sum -= arr[winStart-1];
            sum += arr[winStart + k - 1];
            if (sum >= threshold) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n1 = numOfSubarrays(new int[]{1}, 1, 1); // 1
        int n2 = numOfSubarrays(new int[]{1}, 1, 2); // 0
        int n3 = numOfSubarrays(new int[]{1,1,1}, 3, 1); // 1
        int n4 = numOfSubarrays(new int[]{1,1,1}, 3, 2); // 0
        int n5 = numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4); // 3
        int n6 = numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5); // 6
    }
}
