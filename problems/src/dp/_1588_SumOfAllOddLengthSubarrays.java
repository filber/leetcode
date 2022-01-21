package dp;

// [Prefix Sum]
public class _1588_SumOfAllOddLengthSubarrays {

    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + arr[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j <= n) {
                int rangeSum = ps[j] - ps[i - 1];
                sum += rangeSum;
                j += 2;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        // [1] = 1
        // [4] = 4
        // [2] = 2
        // [5] = 5
        // [3] = 3
        // [1,4,2] = 7
        // [4,2,5] = 11
        // [2,5,3] = 10
        // [1,4,2,5,3] = 15
        // sum = 58
        int s1 = sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3});

        // [1] = 1
        // [2] = 2
        // sum = 3
        int s2 = sumOddLengthSubarrays(new int[]{1, 2});

        // [10] = 10
        // [11] = 11
        // [12] = 12
        // [10,11,12] = 33
        // sum = 66
        int s3 = sumOddLengthSubarrays(new int[]{10, 11, 12});

        // 1
        int s4 = sumOddLengthSubarrays(new int[]{1});
    }
}
