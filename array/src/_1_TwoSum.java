import java.util.HashMap;
import java.util.Map;

// TOPICS:
// [Array],[Hash Map]

// TIPS:
// Dynamically checking and pushing hashmap when iterating the array.
public class _1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int another = target - val;
            Integer anotherIndex = map.get(another);
            if (anotherIndex != null) {
                // found;
                return new int[]{anotherIndex, i};
            }
            map.put(val, i);
        }

        // not found
        return null;
    }

    public static void main(String[] args) {
        int[] s1 = twoSum(new int[]{3, 3}, 6);
        int[] s2 = twoSum(new int[]{3, 2, 4}, 6);
        int[] s3 = twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] s4 = twoSum(new int[]{3, 2, 3}, 6);
    }
}
