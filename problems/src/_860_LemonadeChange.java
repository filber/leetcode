public class _860_LemonadeChange {

  public static boolean lemonadeChange(int[] bills) {
    int fiveReceived = 0;
    int tenReceived = 0;

    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        fiveReceived++;
      }

      if (bills[i] == 10) {
        if (fiveReceived > 0) {
          fiveReceived--;
          tenReceived++;
        } else {
          return false;
        }
      }

      if (bills[i] == 20) {
        if (fiveReceived > 0 && tenReceived > 0) {
          fiveReceived--;
          tenReceived--;
        } else if (tenReceived == 0 && fiveReceived > 2) {
          fiveReceived -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    // true
    boolean example1 = lemonadeChange(new int[] {5, 5, 5, 10, 20});

    // true
    boolean example2 = lemonadeChange(new int[] {5,5,10});

    // false
    boolean example3 = lemonadeChange(new int[] {10,10});

    // false
    boolean example4 = lemonadeChange(new int[] {5,5,10,10,20});

  }
}
