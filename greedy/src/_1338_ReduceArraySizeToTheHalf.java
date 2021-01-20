import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1338_ReduceArraySizeToTheHalf {

  public static int minSetSize(int[] arr) {
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      Integer count = map.get(arr[i]);
      if (count == null) {
        count = 0;
      }
      count++;
      map.put(arr[i], count);
    }

    int setSize = 0;
    int sum = 0;
    Integer[] values = new Integer[map.values().size()];
    values = map.values().toArray(values);
    Arrays.sort(values);
    for (int i = values.length - 1; i >= 0; i--) {
      sum += values[i];
      setSize++;
      if (sum >= arr.length / 2) {
        return setSize;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    // Output: 2
    int example1 = minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7});

    // Output: 1
    int example2 = minSetSize(new int[]{7,7,7,7,7,7});

    // Output: 1
    int example3 = minSetSize(new int[]{1,9});

    // Output: 1
    int example4 = minSetSize(new int[]{1000,1000,3,7});

    // Output: 5
    int example5 = minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10});
  }
}
