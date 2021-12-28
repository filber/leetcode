import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _1282_GroupThePeopleGivenTheGroupSizeTheyBelongTo {

//  Constraints:
//  groupSizes.length == n
//    1 <= n <= 500
//    1 <= groupSizes[i] <= n

//  Example 1:
//  Input: groupSizes = [3,3,3,3,3,1,3]
//  Output: [[5],[0,1,2],[3,4,6]]

//  Example 2:
//  Input: groupSizes = [2,1,3,3,3,2]
//  Output: [[1],[0,5],[2,3,4]]

  public static List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> result = new LinkedList<>();
    Map<Integer,List<Integer>> groupMap = new HashMap<>();

    for (int i = 0; i < groupSizes.length; i++) {
      int groupSize = groupSizes[i];
      List<Integer> list = groupMap.get(groupSize);
      if (list == null) {
        list = new LinkedList<>();
        groupMap.put(groupSize, list);
      }
      list.add(i);
      if (list.size() == groupSize) {
        result.add(list);
        groupMap.remove(groupSize);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    groupThePeople(new int[] {3, 3, 3, 3, 3, 1, 3});
    groupThePeople(new int[] {2,1,3,3,3,2});
  }
}
