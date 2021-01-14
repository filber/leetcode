
public class RodCutting {

  private static int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

  /**
   * Recursive Top-Down implementation
   */
  public static int solution1(int n, int[] price) {
    if (n == 0) {
      return 0;
    }
    int p = Integer.MIN_VALUE;
    // iterate all length
    for (int i = 1; i <= n; i++) {
      p = Math.max(p, price[i - 1] + solution1(n - i, price));
    }
    return p;
  }

  /**
   * Memoized Top-Down implementation
   */
  public static int solution2(int n, int[] price) {
    if (n == 0) {
      return 0;
    }
    int[] revenue = new int[n];

    return memoized(n, price, revenue);
  }

  public static int memoized(int n, int[] price,int[] revenue) {
    if (n == 0) {
      return 0;
    }
    if (revenue[n-1] > 0) {
      return revenue[n - 1];
    }
    int p = Integer.MIN_VALUE;
    // iterate all length
    for (int i = 1; i <= n; i++) {
      p = Math.max(p, price[i - 1] + memoized(n - i, price,revenue));
    }
    revenue[n - 1] = p;
    return p;
  }

  /**
   * Bottom-Up implementation
   */
  public static int solution3(int n, int[] price) {
    if (n == 0) {
      return 0;
    }
    int[] revenue = new int[n];
    for (int i = 0; i < n; i++) {
      int p = price[i];
      for (int j = 0; j < i; j++) {
        p = Math.max(p, price[j] + revenue[i - j - 1]);
      }
      revenue[i] = p;
    }
    return revenue[n - 1];
  }

  public static void main(String[] args) {
    int[] revenue = new int[10];
    for (int i = 0; i < 10; i++) {
      revenue[i] = solution2(i + 1, prices);
    }
  }
}
