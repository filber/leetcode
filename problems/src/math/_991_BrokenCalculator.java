package math;

// https://leetcode.com/problems/broken-calculator/

public class _991_BrokenCalculator {

//  Constraints:
//      1 <= X <= 10^9
//      1 <= Y <= 10^9

  public static int brokenCalc(int X, int Y) {
    if (X >= Y) {
      return X - Y;
    }
    // X < Y
    else if (Y%2==0){
      return brokenCalc(X, Y / 2) + 1;
    } else {
      return brokenCalc(X, Y + 1) + 1;
    }
  }

  public static void main(String[] args) {
//    Input: X = 2, Y = 3
//    Output: 2
    brokenCalc(2, 3);

//    Input: X = 5, Y = 8
//    Output: 2
    brokenCalc(5, 8);

//    Input: X = 3, Y = 10
//    Output: 3
    brokenCalc(3, 10);

//    Input: X = 1024, Y = 1
//    Output: 1023
    brokenCalc(1024, 1);
  }
}
