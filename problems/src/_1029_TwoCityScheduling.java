import java.util.Arrays;
import java.util.Comparator;

public class _1029_TwoCityScheduling {

  public static class Cost {
    int value;
    int index;
  }

  public static class CostComparator implements Comparator<Cost> {
    @Override
    public int compare(Cost o1, Cost o2) {
      return Integer.compare(o1.value, o2.value);
    }
  }

  public static int twoCitySchedCost(int[][] costs) {
    Cost[] cityCost = new Cost[costs.length];
    for (int i = 0; i < costs.length; i++) {
      Cost cost = new Cost();
      cost.index = i;
      cost.value = costs[i][0] - costs[i][1];
      cityCost[i] = cost;
    }

    CostComparator costComparator = new CostComparator();
    Arrays.sort(cityCost,costComparator);

    int totalCost = 0;
    for (int i = 0; i < cityCost.length; i++) {
      if (i < cityCost.length / 2) {
        totalCost += costs[cityCost[i].index][0];
      } else {
        totalCost += costs[cityCost[i].index][1];
      }
    }
    return totalCost;
  }

  public static void main(String[] args) {
//    Input: costs = [[10,20],[30,200],[400,50],[30,20]]
//    A: 10 + 30 = 40
//    B: 50 + 20 = 70
//    Output: 110
    twoCitySchedCost(new int[][] {{10, 20}, {30, 200}, {400, 50}, {30, 20}});

//    Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
//    A: 184 + 259 + 577
//    B: 54 + 118 + 667
//    Output: 1859
    twoCitySchedCost(new int[][] {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}});

//    Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
//    A: 343 + 451 + 515 + 537
//    B: 42 + 60 + 359 + 779
//    Output: 3086
    twoCitySchedCost(new int[][]{{515,563},{451,713},{537,709},{343,819},{855,779},{457,60},{650,359},{631,42}});
  }
}
