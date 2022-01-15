package greedy;

// https://leetcode.com/problems/boats-to-save-people/
public class _881_BoatsToSavePeople {

//  Constraints:
//      1 <= people.length <= 5 * 10^4
//      1 <= people[i] <= limit <= 3 * 10^4
//  each boat carries at most two people

    public static int numRescueBoats(int[] people, int limit) {
        int[] cnt = new int[30001];
        int n = people.length;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int p : people) {
            cnt[p]++;
            l = Math.min(l, p);
            r = Math.max(r, p);
        }

        int boatCnt = 0;
        int wait = n;
        while (l <= r && wait > 0) {
            if (l + r <= limit) {
                cnt[l]--;
                wait--;
            }
            cnt[r]--;
            wait--;
            while (wait != 0 && cnt[l] == 0) {
                l++;
            }
            while (wait != 0 && cnt[r] == 0) {
                r--;
            }
            boatCnt ++;
        }
        return boatCnt;
    }

    public static void main(String[] args) {
        int n1 = numRescueBoats(new int[]{1, 2}, 3); // 1
        int n2 = numRescueBoats(new int[]{3, 2, 2, 1}, 3); // 3
        int n3 = numRescueBoats(new int[]{3, 5, 3, 4}, 5); // 4
        int n4 = numRescueBoats(new int[]{2, 4}, 5); // 2
        int n5 = numRescueBoats(new int[]{2, 2}, 6); // 1
    }
}
