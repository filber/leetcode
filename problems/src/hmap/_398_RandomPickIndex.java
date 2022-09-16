package hmap;

//https://leetcode.com/problems/random-pick-index/

import java.util.*;

public class _398_RandomPickIndex {

    class Solution {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Random random = new Random();
        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int val = nums[i];
                List<Integer> list = map.computeIfAbsent(val, (k) -> new ArrayList<>());
                list.add(i);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            int rVal = random.nextInt(list.size());
            return list.get(rVal);
        }
    }
}
