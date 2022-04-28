package greedy;

//https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/

public class _1953_MaximumNumberOfWeeksForWhichYouCanWork {

    public long numberOfWeeks(int[] milestones) {
        long total = 0;
        int max = Integer.MIN_VALUE;
        for (int m : milestones) {
            total += m;
            if (m > max) {
                max = m;
            }
        }
        if (max * 2 <= total) {
            return total;
        } else {
            long remain = total - max;
            return 2 * remain + 1;
        }
    }
}
