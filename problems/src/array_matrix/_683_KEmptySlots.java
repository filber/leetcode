package array_matrix;

//https://www.cnblogs.com/grandyang/p/8415880.html
//https://leetcode.com/problems/k-empty-slots/

public class _683_KEmptySlots {
//    You have N bulbs in a row numbered from 1 to N.
//    Initially, all the bulbs are turned off.
//    We turn on exactly one bulb every day until all bulbs are on after N days.
//    You are given an array bulbs of length N
//    where bulbs[i] = x means that on the (i+1)th day,
//    we will turn on the bulb at position x where i is 0-indexed and x is 1-indexed.
//    Given an integer K, find out the minimum day number
//    such that there exists two turned on bulbs
//    that have exactly K bulbs between them that are all turned off.
//    If there isn't such day, return -1.

//    Constraints:
//            1 <= N <= 20000
//            1 <= bulbs[i] <= N
//            bulbs is a permutation of numbers from 1 to N.
//            0 <= K <= 20000

    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        int res = Integer.MAX_VALUE;
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[bulbs[i] - 1] = i + 1;
        }

        int left = 0, right = k + 1;
        int cur = left + 1;
        while (right < n) {
            if (cur == right) {
                // reach the end of the window
                // update res for earlier date
                res = Math.min(res,
                        // the later day to turn on left or right bulbs
                        Math.max(days[left], days[right])
                );
            }

            if (days[left] < days[cur] && days[cur] > days[right]) {
                // if satisfied, move cur
                cur++;
            } else {
                // if not satisfied, move window
                left = cur;
                right = cur + k + 1;
                cur = left + 1;
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
