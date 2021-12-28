import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _1296_DivideArrayInSetsOfKConsecutiveNumbers {

  public static boolean isPossibleDivide(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (map.containsKey(num)) {
        int value = map.get(num);
        map.put(num, value + 1);
      } else {
        map.put(num, 1);
      }
    }

    while (!map.isEmpty()) {
      int base = map.keySet().iterator().next();
//      for (int key : map.keySet()) {
//        if (key < base) {
//          base = key;
//        }
//      }

      for (int i = 0; i < k; i++) {
        Integer cnt = map.get(base + i);
        if (cnt == null) {
          return false;
        } else {
          cnt = cnt - 1;
          if (cnt == 0) {
            map.remove(base + i);
          } else {
            map.put(base + i, cnt);
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    isPossibleDivide(new int[] {1, 2, 3, 3, 4, 4, 5, 6}, 4);
  }
}
