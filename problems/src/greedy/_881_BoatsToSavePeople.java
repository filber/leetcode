package greedy;

// https://leetcode.com/problems/boats-to-save-people/
public class _881_BoatsToSavePeople {

//  Constraints:
//      1 <= people.length <= 5 * 10^4
//      1 <= people[i] <= limit <= 3 * 10^4
//  each boat carries at most two people

    public static int numRescueBoats(int[] people, int limit) {
        int[] cnt = new int[30001];
        for (int p : people) {
            cnt[p]++;
        }

        int l = 1;
        while (l <= limit && cnt[l] == 0) {
            l++;
        }
        int r = limit;
        while (r >= 1 && cnt[r] == 0) {
            r--;
        }
        int boats = 0;
        while (l <= r) {
            if (l==r) {
                if (l * 2 <= limit) {
                    boats += cnt[l] / 2;
                    boats += cnt[l] % 2;
                } else {
                    boats += cnt[l];
                }
                l++;
            } else {
                // l<r
                if (l + r > limit) {
                    boats += cnt[r];
                    cnt[r] = 0;
                    while (r >= l && cnt[r] == 0) {
                        r--;
                    }
                } else {
                    // l + r <= limit
                    int mP = Math.min(cnt[l], cnt[r]);
                    boats += mP;
                    cnt[l] -= mP;
                    cnt[r] -= mP;
                    while (r >= l && cnt[r] == 0) {
                        r--;
                    }
                    while (l <= r && cnt[l] == 0) {
                        l++;
                    }
                }
            }
        }
        return boats;
    }
}
