package greedy;

// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description

public class _1578_MinimumTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {
        int sum = 0;
        for (int item : neededTime) {
            sum += item;
        }

        char[] chars = colors.toCharArray();
        int N = chars.length;
        // preCost: biggest neededTime for previous consecutive colors
        int prevCost = neededTime[0];
        // sum of neededTime for all remaining colors after removal
        int leftSum = 0;
        for (int i = 1; i < N; i++) {
            if (chars[i - 1] == chars[i]) {
                prevCost = Math.max(prevCost, neededTime[i]);
            } else {
                leftSum += prevCost;
                prevCost = neededTime[i];
            }
        }

        if (prevCost > 0) {
            leftSum += prevCost;
        }
        return sum - leftSum;
    }
}
