package dp;

// https://leetcode.com/problems/ugly-number-ii/

public class _264_UglyNumber_II {

  // Dynamic Programming:
  // 1.Use a grid numbers to store temp results
  // 2.Every value in column-0 represents nth ugly number
  // 3.Every value in column-1 represents the double value of nth ugly number, so are column-2,column-3
  // 4. cell[i][j] = min(cell[twoIndex][1],cell[threeIndex][2],cell[fiveIndex][3])

  public int nthUglyNumber(int n) {
    int rowIndex = 0;
    int twoIndex = 0;
    int threeIndex = 0;
    int fiveIndex = 0;
    int[][] numbers = new int[n][4];

    numbers[rowIndex][0] = 1;
    numbers[rowIndex][1] = 2 * numbers[rowIndex][0];
    numbers[rowIndex][2] = 3 * numbers[rowIndex][0];
    numbers[rowIndex][3] = 5 * numbers[rowIndex][0];
    for (int i = 1; i < numbers.length; i++) {
      numbers[i][0] =
          Math.min(numbers[twoIndex][1],
              Math.min(numbers[threeIndex][2], numbers[fiveIndex][3]));
      rowIndex = i;
      numbers[rowIndex][1] = 2 * numbers[rowIndex][0];
      numbers[rowIndex][2] = 3 * numbers[rowIndex][0];
      numbers[rowIndex][3] = 5 * numbers[rowIndex][0];

      if (numbers[twoIndex][1]==numbers[i][0]) {
        twoIndex ++;
      }
      if (numbers[threeIndex][2]==numbers[i][0]) {
        threeIndex ++;
      }
      if (numbers[fiveIndex][3]==numbers[i][0]) {
        fiveIndex ++;
      }
    }

    return numbers[n - 1][0];
  }

  public static void main(String[] args) {
    _264_UglyNumber_II instance = new _264_UglyNumber_II();
    // 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
    int result = instance.nthUglyNumber(1);
    assert result == 12;
  }
}
