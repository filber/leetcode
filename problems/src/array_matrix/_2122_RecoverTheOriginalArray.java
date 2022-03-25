package array_matrix;

//https://leetcode.com/problems/recover-the-original-array/

import java.util.*;

public class _2122_RecoverTheOriginalArray {

    int[] nums;
    int n;
    int[] ans;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] recoverArray(int[] nums) {
        n = nums.length;
        this.nums = nums;
        ans = new int[n / 2];
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            List<Integer> list = map.computeIfAbsent(nums[i], (k) -> new ArrayList<>());
            list.add(i);
        }

        int first = nums[0];
        int pre = -1;
        for (int i = 1; i < n; i++) {
            int k = nums[i] - first;
            if (k != pre && k > 0 && k % 2 == 0 && check(k / 2)) {
                break;
            }
            pre = k;
        }

        return ans;
    }

    private boolean check(int k) {
        int len = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int val = nums[i] + k;
                visited[i] = true;
                int higher = val + k;
                // if higher exist, mark it as visited
                List<Integer> list = map.get(higher);
                if (list == null) {
                    return false;
                }

                boolean foundHigher = false;
                Iterator<Integer> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    int j = iterator.next();
                    if (!visited[j]) {
                        visited[j] = true;
                        foundHigher = true;
                        break;
                    }
                }

                if (!foundHigher) {
                    return false;
                } else {
                    ans[len++] = val;
                }
            }
        }

        return true;
    }
}
