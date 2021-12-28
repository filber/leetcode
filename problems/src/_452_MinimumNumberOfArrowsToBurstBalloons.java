import java.util.Arrays;

public class _452_MinimumNumberOfArrowsToBurstBalloons {

  public static int findMinArrowShots(int[][] points) {
    // Every time you shoot a balloon,
    // try to shoot other balloons as much as possible at the same time.

    if (points.length < 1) {
      return 0;
    }

    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    int count = 1;
    int axis = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (axis < points[i][0]) {
        count++;
        axis = points[i][1];
      }
    }
    return count;
  }

  public static void main(String[] args) {
//    Input: points = [[10,16],[2,8],[1,6],[7,12]]
//    Output: 2
    findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}});

//    Input: points = [[1,2],[3,4],[5,6],[7,8]]
//    Output: 4
    findMinArrowShots(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}});

//    Input: points = [[1,2],[2,3],[3,4],[4,5]]
//    Output: 2
    findMinArrowShots(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}});

//    Input: points = [[1,2]]
//    Output: 1
    findMinArrowShots(new int[][] {{1, 2}});

//    Input: points = [[2,3],[2,3]]
//    Output: 1
    findMinArrowShots(new int[][] {{2, 3}, {2, 3}});
  }
}
