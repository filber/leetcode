package bs;

//https://leetcode.com/problems/find-k-closest-elements/

import java.util.*;

public class _658_FindKClosestElements {

//    An integer a is closer to x than an integer b if:
//        |a - x| < |b - x|, or
//        |a - x| == |b - x| and a < b

    // Priority Queue
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer l, Integer r) {
                int lAbs = Math.abs(arr[l] - x);
                int rAbs = Math.abs(arr[r] - x);
                if (lAbs == rAbs) {
                    return arr[l] - arr[r];
                } else {
                    return lAbs - rAbs;
                }
            }
        });

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            priorityQueue.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            ans.add(arr[priorityQueue.poll()]);
        }
        Collections.sort(ans);
        return ans;
    }
}
