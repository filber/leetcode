package array_matrix;

//https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            if (set.contains(val)) {
                return true;
            }
            set.add(val);
        }
        return false;
    }
}
