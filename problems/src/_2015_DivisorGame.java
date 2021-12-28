public class _2015_DivisorGame {

//  Choosing any x with 0 < x < N and N % x == 0.
//  Replacing the number N on the chalkboard with N - x.
//  1 <= N <= 1000

  public static boolean divisorGame(int N) {
    return N % 2 == 0;
  }

  public static void main(String[] args) {
//    Input: 2
//    Output: true
    divisorGame(2);

//    Input: 3
//    Output: false
    divisorGame(3);
  }
}
