public class _944_DeleteColumnsToMakeSorted {

  // Suppose we chose a set of deletion indices D such that after deletions,
  // each remaining column in A is in non-decreasing sorted order.

  public static int minDeletionSize(String[] A) {
    int strLength = A[0].length();
    int minSize = 0;
    for (int c = 0; c < strLength; c++) {
      for (int i = 1; i < A.length; i++) {
        if (A[i - 1].charAt(c) > A[i].charAt(c)) {
          minSize++;
          break;
        }
      }
    }
    return minSize;
  }

  public static void main(String[] args) {
    // 1
    minDeletionSize(new String[] {"cba", "daf", "ghi"});
    // 0
    minDeletionSize(new String[] {"a","b"});
    // 3
    minDeletionSize(new String[] {"zyx","wvu","tsr"});

  }
}
