package array_matrix;

import java.util.*;

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
public class _1282_GroupThePeopleGivenTheGroupSizeTheyBelongTo {

//  Constraints:
//  groupSizes.length == n
//    1 <= n <= 500
//    1 <= groupSizes[i] <= n

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

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
                groupMap.put(groupSize,new ArrayList<>());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // [[5],[0,1,2],[3,4,6]]
        List<List<Integer>> l1 = groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});

        // [[1],[0,5],[2,3,4]]
        List<List<Integer>> l2 = groupThePeople(new int[]{2, 1, 3, 3, 3, 2});
    }
}
