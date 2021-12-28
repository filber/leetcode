import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _1686_StoneGameVI {

//  Constraints:
//  n == aliceValues.length == bobValues.length
//  1 <= n <= 105
//  1 <= aliceValues[i], bobValues[i] <= 100

  public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
    if (aliceValues.length == 1) {
      // alice plays first, she will win.
      return 1;
    }

    Map<Integer, List<Integer>> stoneMap = new HashMap<>();
    for (int i = 0; i < aliceValues.length; i++) {
      int stoneSum = aliceValues[i] + bobValues[i];
      if (stoneMap.containsKey(stoneSum)) {
        stoneMap.get(stoneSum).add(i);
      } else {
        List<Integer> indexList = new LinkedList<>();
        indexList.add(i);
        stoneMap.put(stoneSum, indexList);
      }
    }

    Integer[] stoneSumArray = new Integer[stoneMap.keySet().size()];
    stoneSumArray = stoneMap.keySet().toArray(stoneSumArray);
    Arrays.sort(stoneSumArray, (a, b) -> Integer.compare(b, a));

    int aliceScore = 0;
    int bobScore = 0;
    int turn = 0;
    int stoneIndex = 0;
    while (!stoneMap.isEmpty()) {
      List<Integer> list = stoneMap.get(stoneSumArray[stoneIndex]);
      int valueIndex = list.remove(0);

      if (turn%2==0) {
        //alice's turn
        aliceScore += aliceValues[valueIndex];
      } else {
        //bob's turn
        bobScore += bobValues[valueIndex];
      }
      turn ++;

      if (list.isEmpty()) {
        stoneMap.remove(stoneSumArray[stoneIndex]);
        stoneIndex++;
      }
    }

    return Integer.compare(aliceScore, bobScore);
  }

  public static void main(String[] args) {
    // 1
//    stoneGameVI(new int[] {1, 3}, new int[] {2, 1});

    // 0
//    stoneGameVI(new int[] {1, 2}, new int[] {3, 1});

    // -1
    stoneGameVI(new int[] {2, 4, 3}, new int[] {1, 6, 7});
  }
}
