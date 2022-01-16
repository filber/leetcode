package math;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
//TOPICS:
//[Hash Table]
public class _1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static int numPairsDivisibleBy60(int[] time) {
        int[] bucket = new int[60];
        int cnt = 0;
        for (int t : time) {
            bucket[t % 60]++;
        }
        cnt += bucket[0]*(bucket[0]-1)/2;
        cnt += bucket[30]*(bucket[30]-1)/2;

        for (int i = 1; i <= 29; i++) {
            cnt += bucket[i] * bucket[60 - i];
        }

        return cnt;
    }

    public static void main(String[] args) {
        // 3 [30-150],[20-100],[20-40]
        int n1 = numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
        // 3
        int n2 = numPairsDivisibleBy60(new int[]{60, 60, 60});
        // 4
        int n3 = numPairsDivisibleBy60(new int[]{60, 60, 60, 1, 59});
    }
}
