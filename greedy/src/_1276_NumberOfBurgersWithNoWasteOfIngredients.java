import java.util.LinkedList;
import java.util.List;

public class _1276_NumberOfBurgersWithNoWasteOfIngredients {

//  Constraints:
//      0 <= tomatoSlices <= 10^7
//      0 <= cheeseSlices <= 10^7

  public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
    LinkedList result = new LinkedList<>();
    int jumboCnt = 0;
    int smallCnt = 0;
    if (tomatoSlices % 2 == 1) {
      return result;
    }

    jumboCnt = tomatoSlices / 2 - cheeseSlices;
    smallCnt = 2 * cheeseSlices - tomatoSlices / 2;

    if (jumboCnt >= 0 && smallCnt >= 0) {
      result.add(jumboCnt);
      result.add(smallCnt);
    }
    return result;
  }

  public static void main(String[] args) {
    // [1,6]
    numOfBurgers(16, 7);

    // []
    numOfBurgers(17, 4);

    // []
    numOfBurgers(4, 17);

    // [0,0]
    numOfBurgers(0, 0);

    // [0,1]
    numOfBurgers(2, 1);
  }
}
