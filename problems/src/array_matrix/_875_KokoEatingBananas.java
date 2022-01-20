package array_matrix;

// https://leetcode.com/problems/koko-eating-bananas/
public class _875_KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1000000001; // right exclusive
        while (l < r) {
            int mid = (l + r) / 2;
            int spent = eat(piles, mid);
            if (spent <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static int eat(int[] piles, int k) {
        int hour = 0;
        for (int i = 0; i < piles.length; i++) {
            int p = piles[i];
            if (p % k == 0) {
                hour += p / k;
            } else {
                hour += p / k + 1;
            }
        }
        return hour;
    }


    public static void main(String[] args) {
        // 4
        int k1 = minEatingSpeed(new int[]{3, 6, 7, 11}, 8);

        // 30
        int k2 = minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5);

        // 23
        int k3 = minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6);
    }
}
