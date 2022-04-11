package array_matrix;

//https://www.geeksforgeeks.org/find-first-k-natural-numbers-missing-given-array/

import java.util.HashSet;
import java.util.Set;

public class _EX_FindFirstKNaturalNumbersMissingInGivenArray {

    public int[] findKMissing(int nums[], int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n || nums[i] == i + 1) {
                continue;
            }
            int to = nums[i];
            while (to > 0 && to <= n && nums[to - 1] != to) {
                int tmp = nums[to - 1];
                nums[to - 1] = to;
                to = tmp;
            }
            if (nums[i] != i + 1) {
                nums[i] = to;
            }
        }

        int[] ans = new int[k];
        int idx = 0;
        Set<Integer> set = new HashSet<>();
        int lastNatural = 0;
        for (int i = 0; i < n && idx < k; i++) {
            if (nums[i] != i + 1) {
                ans[idx++] = i + 1;
                lastNatural = i + 1;
                if (nums[i] > 0) {
                    set.add(nums[i]);
                }
            } else {
                lastNatural = nums[i];
            }
        }

        for (int natural = lastNatural + 1; idx < k; natural++) {
            if (set.isEmpty() || !set.contains(natural)) {
                ans[idx++] = natural;
            } else {
                set.remove(natural);
            }
        }

        return ans;
    }
}
