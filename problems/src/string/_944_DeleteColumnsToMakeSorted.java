package string;

public class _944_DeleteColumnsToMakeSorted {

  // Suppose we chose a set of deletion indices D such that after deletions,
  // each remaining column in A is in non-decreasing sorted order.

  public static int minDeletionSize(String[] A) {
    int n = A.length;
    int m = A[0].length();
    if (n==1) {
      return 0;
    }

    int cnt = 0;
    for (int j = 0; j < m; j++) {
      for (int i = 1; i < n; i++) {
        if (A[i].charAt(j) < A[i-1].charAt(j)) {
          cnt++;
          break;
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    // 1
    int m1 = minDeletionSize(new String[] {"cba", "daf", "ghi"});
    // 0
    int m2 = minDeletionSize(new String[] {"a","b"});
    // 3
    int m3 = minDeletionSize(new String[] {"zyx","wvu","tsr"});

    int m4 = minDeletionSize(new String[] {"rrjk","furt","guzm"});
  }
}
