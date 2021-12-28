// TOPICS:
// [Prefix Sum], [Combinatorics]
public class _1588_SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i + 1, right = arr.length - i;
            int leftOdd = (left + 1) / 2, leftEven = left / 2;
            int rightOdd = (right + 1) / 2, rightEven = right / 2;

            res += (leftOdd * rightOdd + leftEven * rightEven) * arr[i];
        }

        return res;
    }

    public static int sumOddLengthSubarraysPrefix(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j -= 2) {
                sum += prefixSum[i+1] - prefixSum[j];
            }
        }
        return sum;
    }

    public static int sumAllSubarrays(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + i * nums[i] + nums[i];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += dp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
//        int s1 = new _1588_SumOfAllOddLengthSubarrays().
//                sumAllSubarrays(new int[]{1, 4, 2, 5, 3});
//        int s2 = new _1588_SumOfAllOddLengthSubarrays().
//                sumAllSubarrays(new int[]{1, 2});
//        int s3 = new _1588_SumOfAllOddLengthSubarrays().
//                sumAllSubarrays(new int[]{10, 11, 12});

//        int s2 = new _1588_SumOfAllOddLengthSubarrays().
//                sumOddLengthSubarrays(new int[]{1, 2}); // 3
//        int s3 = new _1588_SumOfAllOddLengthSubarrays().
//                sumOddLengthSubarrays(new int[]{10, 11, 12}); // 66
        int s1 = new _1588_SumOfAllOddLengthSubarrays().
                sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}); // 58
    }
}
