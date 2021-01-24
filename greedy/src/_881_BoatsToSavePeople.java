public class _881_BoatsToSavePeople {

//  Constraints:
//      1 <= people.length <= 5 * 10^4
//      1 <= people[i] <= limit <= 3 * 10^4
//  each boat carries at most two people

  public static int numRescueBoats(int[] people, int limit) {
    int[] peopleWeight = new int[3 * 10000 + 1];
    int minWeight = Integer.MAX_VALUE;
    int maxWeight = Integer.MIN_VALUE;

    for (int i = 0; i < people.length; i++) {
      peopleWeight[people[i]]++;
      if (people[i] < minWeight) {
        minWeight = people[i];
      }
      if (people[i] > maxWeight) {
        maxWeight = people[i];
      }
    }

    int boatCnt = 0;
    int left = minWeight;
    int right = maxWeight;
    while (left < right) {
      if ((left + right) > limit) {
        boatCnt += peopleWeight[right];
        peopleWeight[right] = 0;
        // move right to left
        while (peopleWeight[--right] == 0 && left < right) {}
      } else {
        int min = Math.min(peopleWeight[left], peopleWeight[right]);
        boatCnt += min;
        peopleWeight[left] -= min;
        peopleWeight[right] -= min;
        if (peopleWeight[left] == 0) {
          // move left to right
          while (peopleWeight[++left] == 0 && left < right) {}
        }
        if (peopleWeight[right] == 0) {
          // move right to left
          while (peopleWeight[--right] == 0 && left < right) {}
        }
      }
    }

    if ((left == right) && peopleWeight[left] != 0) {
      if ((left + right) <= limit) {
        boatCnt += peopleWeight[left]/2;
        boatCnt += peopleWeight[left] % 2;
      } else {
        boatCnt += peopleWeight[left];
      }
    }
    return boatCnt;
  }

  public static void main(String[] args) {

//    Input: people = [1,2], limit = 3
//    Output: 1
    numRescueBoats(new int[] {1, 2}, 3);

//    Input: people = [3,2,2,1], limit = 3
//    Output: 3
    numRescueBoats(new int[] {3, 2, 2, 1}, 3);

//    Input: people = [3,5,3,4], limit = 5
//    Output: 4
    numRescueBoats(new int[] {3, 5, 3, 4}, 5);

    numRescueBoats(new int[] {2, 4}, 5);
  }
}
