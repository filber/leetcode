public class _877_StoneGame {

//  Constraints:
//  2 <= piles.length <= 500
//  piles.length is even.
//  1 <= piles[i] <= 500
//  sum(piles) is odd.

  public static boolean stoneGame(int[] piles) {
    int[][] isFirstMatrix = new int[piles.length][piles.length];
    int[][] isSecondMatrix = new int[piles.length][piles.length];
    int alexScore = stoneValue(piles, 0, piles.length - 1, true, isFirstMatrix, isSecondMatrix);
    int sum = 0;
    for (int i = 0; i < piles.length; i++) {
      sum += piles[i];
    }
    return alexScore > (sum-alexScore);
  }

  public static int stoneValue(int[] piles, int start, int end, boolean isFirst,
                               int[][] isFirstMatrix, int[][] isSecondMatrix) {
    if (isFirst && isFirstMatrix[start][end] != 0) {
      return isFirstMatrix[start][end];
    }
    if (!isFirst && isSecondMatrix[start][end] != 0) {
      return isSecondMatrix[start][end];
    }

    if ((end - start) == 1) {
      if (isFirst) {
        isFirstMatrix[start][end] = Math.max(piles[start], piles[end]);
        return isFirstMatrix[start][end];
      } else {
        isSecondMatrix[start][end] = Math.min(piles[start], piles[end]);
        return isSecondMatrix[start][end];
      }
    }

    int fromLeft;
    int fromRight;
    if (isFirst) {
      fromLeft = piles[start] + stoneValue(piles, start + 1, end, false,isFirstMatrix,isSecondMatrix);
      fromRight = piles[end] + stoneValue(piles, start, end - 1, false,isFirstMatrix,isSecondMatrix);
      isFirstMatrix[start][end] = Math.max(fromLeft, fromRight);
      return isFirstMatrix[start][end];
    } else {
      fromLeft = stoneValue(piles, start + 1, end, true,isFirstMatrix,isSecondMatrix);
      fromRight = stoneValue(piles, start, end - 1, true,isFirstMatrix,isSecondMatrix);
      isSecondMatrix[start][end] = Math.max(fromLeft, fromRight);
      return isSecondMatrix[start][end];
    }
  }

  public static void main(String[] args) {
//    stoneGame(new int[] {5, 3, 4, 5});
//    stoneGame(new int[] {3,7,2,3});
    stoneGame(new int[] {7,8,8,10});
  }
}
