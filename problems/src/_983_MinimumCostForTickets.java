public class _983_MinimumCostForTickets {

//  Constraint:
//  1 <= days.length <= 365
//  1 <= days[i] <= 365
//  days is in strictly increasing order.
//  costs.length == 3
//  1 <= costs[i] <= 1000

  public static int mincostTickets(int[] days, int[] costs) {
    int[] date = new int[366];
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < days.length; i++) {
      date[days[i]] = 1;
      min = Math.min(min, days[i]);
      max = Math.max(max, days[i]);
    }

    for (int i = min; i <= max; i++) {
      if (date[i] == 0) {
        date[i] = date[i - 1];
      } else {
        if ((i - min) < 6) {
          date[i] = Math.min(date[i - 1] + costs[0], costs[1]);
        } else if ((i - min) >= 6 && (i - min) < 29) {
          date[i] = Math.min(date[i - 1] + costs[0],date[i-7]+costs[1]);
        } else {
          date[i] = Math.min(Math.min(
              date[i - 1] + costs[0],
              date[i - 7] + costs[1]),
              date[i - 30] + costs[2]);
        }
      }
    }
    return date[max];
  }

  public static void main(String[] args) {
//    Input: days = [1,4,6,7,8,20], costs = [2,7,15]
//    Output: 11 (2+7+2)
//    mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15});

//    Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
//    Output: 17 (15+2)
    mincostTickets(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[] {2, 7, 15});
  }
}
