package math;

//https://leetcode.com/problems/poor-pigs/

public class _458_PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        while (Math.pow(times, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
