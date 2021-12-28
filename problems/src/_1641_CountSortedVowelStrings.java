public class _1641_CountSortedVowelStrings {

  public static int countVowelStrings(int n) {
    int[][] count = new int[n + 1][5];
    for (int i = 0; i < 5; i++) {
      count[1][i] = 1;
    }

    for (int i = 2; i <= n; i++) {
      // a
      count[i][0] =
          count[i - 1][0] +
          count[i - 1][1] +
          count[i - 1][2] +
          count[i - 1][3] +
          count[i - 1][4];
      // e
      count[i][1] =
          count[i - 1][1] +
          count[i - 1][2] +
          count[i - 1][3] +
          count[i - 1][4];
      // i
      count[i][2] =
            count[i - 1][2] +
            count[i - 1][3] +
            count[i - 1][4];
      // o
      count[i][3] =
          count[i - 1][3] +
          count[i - 1][4];
      // u
      count[i][4] =
          count[i - 1][4];
    }

    return count[n][0] +
        count[n][1] +
        count[n][2] +
        count[n][3] +
        count[n][4];
  }

  public static void main(String[] args) {
    System.out.println(countVowelStrings(1));
    System.out.println(countVowelStrings(2));
    System.out.println(countVowelStrings(33));
  }
}
