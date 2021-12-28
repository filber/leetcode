import java.util.Arrays;

public class _870_AdvantageShuffle {

//  Constraint:
//  1 <= A.length = B.length <= 10000
//  0 <= A[i] <= 10^9
//  0 <= B[i] <= 10^9

  public static int[] advantageCount(int[] A, int[] B) {
    int[][] A_indexed = new int[A.length][2];
    int[][] B_indexed = new int[B.length][2];
    for (int i = 0; i < A.length; i++) {
      A_indexed[i][0] = A[i];
      A_indexed[i][1] = i;

      B_indexed[i][0] = B[i];
      B_indexed[i][1] = i;
    }

    Arrays.sort(A_indexed, (a, b) -> Integer.compare(a[0], b[0]));
    Arrays.sort(B_indexed, (a, b) -> Integer.compare(a[0], b[0]));
    int[] result = new int[A.length];
    int indexA = 0;
    int right = A.length - 1;
    int indexB = 0;
    while (indexA < A.length) {
      int a = A_indexed[indexA][0];
      int b = B_indexed[indexB][0];
      if (a > b) {
        result[B_indexed[indexB][1]] = a;
        indexB++;
        indexA++;
      } else {
        result[B_indexed[right][1]] = a;
        right--;
        indexA++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
//    Input: A = [2,7,11,15], B = [1,10,4,11]
//    Output: [2,11,7,15]
//    advantage num: 4
//    advantageCount(new int[] {2, 7, 11, 15}, new int[] {1, 10, 4, 11});

//    Input: A = [12,24,8,32], B = [13,25,32,11]
//    Output: [24,32,8,12]
//    advantage num: 3
//    advantageCount(new int[] {12,24,8,32}, new int[] {13,25,32,11});

    advantageCount(new int[] {1}, new int[] {2});
    advantageCount(new int[] {2}, new int[] {1});
  }
}
