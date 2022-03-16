package math;

public class _458_PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int maxRound = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        while (Math.pow(maxRound, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
