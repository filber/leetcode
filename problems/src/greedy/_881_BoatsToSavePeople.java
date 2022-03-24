package greedy;

// https://leetcode.com/problems/boats-to-save-people/
public class _881_BoatsToSavePeople {

//  Constraints:
//      1 <= people.length <= 5 * 10^4
//      1 <= people[i] <= limit <= 3 * 10^4
//  each boat carries at most two people

    public static int numRescueBoats(int[] people, int limit) {
        int[] bucket = new int[30001];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int p : people) {
            bucket[p]++;
            if (p < min) {
                min = p;
            }
            if (p > max) {
                max = p;
            }
        }

        int boats = 0;
        int l = min, r = max;
        while (l < r) {
            if ((l + r) <= limit) {
                int cnt = Math.min(bucket[l], bucket[r]);
                bucket[l] -= cnt;
                bucket[r] -= cnt;
                boats += cnt;
            } else {
                boats += bucket[r];
                bucket[r] = 0;
            }

            while (l < r && bucket[l] == 0) {
                l++;
            }
            while (l < r && bucket[r] == 0) {
                r--;
            }
        }

        if (2 * l <= limit) {
            boats += bucket[l] / 2 + bucket[l] % 2;
        } else {
            boats += bucket[l];
        }
        bucket[l] = 0;

        return boats;
    }
}
