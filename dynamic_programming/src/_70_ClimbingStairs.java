public class _70_ClimbingStairs {

  public static int climbStairs(int n) {
    if (n==1) {
      return 1;
    } else if (n==2) {
      return 2;
    }

    int previousTwo = 1;
    int previousOne = 2;
    int result = previousOne + previousTwo;
    for (int i = 3; i <= n ; i++) {
      result = previousOne + previousTwo;
      previousTwo = previousOne;
      previousOne = result;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(climbStairs(2));
    System.out.println(climbStairs(3));
    System.out.println(climbStairs(4));
  }

}
