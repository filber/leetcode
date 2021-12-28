public class _1052_Grumpy_Bookstore_Owner {

  public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    int maxSatisfied = 0;
    int sum = 0;
    for (int i = 0; i < customers.length; i++) {
      if (grumpy[i] == 0) {
        sum += customers[i];
      }
    }

    // a sliding window slide from left to right across the array.
    // the most right part enters into the array starting from index 0.
    for (int i = 0; i < customers.length; i++) {
      if (grumpy[i] == 1) {
        sum += customers[i];
      }
      if (i >= X && grumpy[i - X] == 1) {
        sum -= customers[i - X];
      }
      maxSatisfied = Math.max(sum, maxSatisfied);
    }

    return maxSatisfied;
  }

  public static void main(String[] args) {
    int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
    int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
    int X = 3;
    _1052_Grumpy_Bookstore_Owner instance = new _1052_Grumpy_Bookstore_Owner();
    int result = instance.maxSatisfied(customers, grumpy, X);
    assert result == 16;
  }
}
