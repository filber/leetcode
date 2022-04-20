package greedy;

import java.util.List;
import java.util.PriorityQueue;

public class _632_SmallestRangeCoveringElementsFromKLists {

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        if (k == 1) {
            int val = nums.get(0).get(0);
            return new int[]{val, val};
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                a[2] - b[2]);

        int r = 0;
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            pq.add(new int[]{i, 0, val});
            if (val > r) {
                r = val;
            }
        }

        int minLen = Integer.MAX_VALUE;
        int left = 0, right = r;
        while (!pq.isEmpty()) {
            int[] triple = pq.poll();
            int l = nums.get(triple[0]).get(triple[1]);
            if (r - l == 0) {
                return new int[]{l, r};
            } else if (r - l < minLen) {
                left = l;
                right = r;
                minLen = r - l;
            }

            triple[1]++;
            if (triple[1] == nums.get(triple[0]).size()) {
                break;
            }

            int val = nums.get(triple[0]).get(triple[1]);
            triple[2] = val;
            pq.add(triple);
            if (val > r) {
                r = val;
            }
        }

        return new int[]{left, right};
    }
}
