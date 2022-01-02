//TOPICS:
//[Hash Table]
public class _1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static int numPairsDivisibleBy60(int[] time) {
        if (time.length<=1) {
            return 0;
        }
        int[] remainder = new int[60];
        // convert to remainder
        for (int i = 0; i < time.length; i++) {
            remainder[time[i] % 60]++;
        }

        int pairCnt = 0;
        pairCnt += remainder[0] * (remainder[0] - 1) / 2;
        pairCnt += remainder[30] * (remainder[30] - 1) / 2;
        for (int i = 1; i <= 29; i++) {
            pairCnt += remainder[i] * remainder[60 - i];
        }

        return pairCnt;
    }

    public static void main(String[] args) {
        int n1 = numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
        int n2 = numPairsDivisibleBy60(new int[]{60, 60, 60});
        int n3 = numPairsDivisibleBy60(new int[]{60, 60, 60, 1, 59});
    }
}
