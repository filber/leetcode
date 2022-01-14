package greedy;

import java.util.Arrays;

// https://leetcode.com/problems/advantage-shuffle/
public class _870_AdvantageShuffle {

//  Constraint:
//  1 <= A.length = B.length <= 10000
//  0 <= A[i] <= 10^9
//  0 <= B[i] <= 10^9

  public static int[] advantageCount(int[] nums1, int[] nums2) {
    int n = nums1.length;
    if (n == 1) {
      return nums1;
    }

    // Sort
    Arrays.sort(nums1);
    int[][] arr2 = new int[n][2];
    for (int i = 0; i < n; i++) {
      arr2[i][0] = i;
      arr2[i][1] = nums2[i];
    }
    Arrays.sort(arr2, (a, b) -> Integer.compare(a[1], b[1]));

    int[] res = new int[n];
    int firstL = 0;
    int secondL = 0;
    int secondR = n - 1;
    while (firstL <= n - 1) {
      if (nums1[firstL] > arr2[secondL][1]) {
        // meet advantage
        res[arr2[secondL][0]] = nums1[firstL];
        firstL++;
        secondL++;
      } else {
        // add to the end
        res[arr2[secondR][0]] = nums1[firstL];
        firstL++;
        secondR--;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    // [2,11,7,15]
    int[] n1 = advantageCount(new int[]{2, 11, 7, 15}, new int[]{1, 10, 4, 11});
    // [24,32,8,12]
    int[] n2 = advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11});
    int[] n3 = advantageCount(new int[] {1}, new int[] {2});
    int[] n4 = advantageCount(new int[] {2}, new int[] {1});
  }
}
