public class _1005_MaximizeSumOfArrayAfterKNegations {

  //  Constraint:
  //      1 <= A.length <= 10000
  //      1 <= K <= 10000
  //      -100 <= A[i] <= 100

  //  Input: A = [4,2,3], K = 1
  //  Output: 5

  //  Input: A = [3,-1,0,2], K = 3
  //  Output: 6

  //  Input: A = [2,-3,-1,5,-4], K = 2
  //  Output: 13

  public static int largestSumAfterKNegations(int[] A, int K) {
    int[] bucket = new int[201];
    for (int i = 0; i < A.length; i++) {
      bucket[A[i] + 100]++;
    }

    int remainFlipCount = K;
    for (int j = 0; j < bucket.length && remainFlipCount > 0; j++) {
      // A[i] < 0
      // try to flip negative numbers as most as possible
      if (j < 100 && bucket[j] > 0) {
        if (bucket[j] <= remainFlipCount) {
          bucket[200 - j] += bucket[j];
          remainFlipCount -= bucket[j];
          bucket[j] = 0;
        } else {
          bucket[j] -= remainFlipCount;
          bucket[200 - j] += remainFlipCount;
          remainFlipCount = 0;
        }
      }

      // A[i] == 0
      // stop at zero
      if (j == 100 && bucket[j] > 0 ) {
        break;
      }

      // A[i] > 0
      // stop at the first positive number
      if (j > 100 && bucket[j] > 0) {
        if ((remainFlipCount % 2) != 0) {
          bucket[200 - j] += 1;
          bucket[j] -= 1;
        }
        break;
      }
    }

    int totalSum = 0;
    for (int i = 0; i < bucket.length; i++) {
      totalSum += (i - 100) * bucket[i];
    }
    return totalSum;
  }

  public static void main(String[] args) {
    int result = largestSumAfterKNegations(new int[] {4,2,3}, 1);
  }
}
