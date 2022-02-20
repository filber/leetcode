package math;

// https://leetcode.com/problems/stone-game-ix/

public class _2029_StoneGameIX {
    // On each turn, the player may remove any stone from stones.
    // The player who removes a stone loses if the sum of the values of all removed stones is divisible by 3.
    // Bob will win automatically if there are no remaining stones (even if it is Alice's turn).

    public static boolean stoneGameIX(int[] stones) {
        int[] mod = new int[3];
        for (int i : stones) {
            mod[i % 3]++;
        }

        // alice starts first and looses
        if (mod[1] == 0 && mod[2] == 0) {
            return false;
        }

        if (mod[0] % 2 == 0) {
            return mod[1] != 0 && mod[2] != 0;
        } else {
            return Math.abs(mod[1] - mod[2]) >= 3;
        }
    }

    public static void main(String[] args) {
        // false
        boolean b1 = stoneGameIX(new int[]{3, 3, 3, 3, 3, 3});

        // true
        boolean b2 = stoneGameIX(new int[]{1,2,1,2,});

        // true
        boolean b3 = stoneGameIX(new int[]{1,2,1,});
    }
}
