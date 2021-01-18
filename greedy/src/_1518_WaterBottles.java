public class _1518_WaterBottles {

  //  Constraints:
  //      1 <= numBottles <= 100
  //      2 <= numExchange <= 100

  //  Input: numBottles = 9, numExchange = 3
  //  Output: 13

  //  Input: numBottles = 15, numExchange = 4
  //  Output: 19

  //  Input: numBottles = 5, numExchange = 5
  //  Output: 6

  //  Input: numBottles = 2, numExchange = 3
  //  Output: 2

  public static int numWaterBottles(int numBottles, int numExchange) {
    int remainBottles = numBottles;
    int drinkBottles = numBottles;
    while (remainBottles >= numExchange) {
      int rewardBottles = remainBottles/numExchange;
      drinkBottles += rewardBottles;
      remainBottles = remainBottles % numExchange + rewardBottles;
    }
    return drinkBottles;
  }

  public static void main(String[] args) {
    numWaterBottles(9,3);
  }
}
