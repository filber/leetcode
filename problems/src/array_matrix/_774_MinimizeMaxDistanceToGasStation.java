package array_matrix;
// https://leetcode.com/problems/minimize-max-distance-to-gas-station/

//    On a horizontal number line, we have gas stations at positions
//    stations[0], stations[1], ..., stations[N-1], where N = stations.length.
//    Now, we add K more gas stations so that D,
//    the maximum distance between adjacent gas stations, is minimized.
//    Return the smallest possible value of D.
//
//    Example:
//        Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
//        Output: 0.500000
//
//    Note:
//        stations.length will be an integer in range [10, 2000].
//        stations[i] will be an integer in range [0, 10^8].
//        K will be an integer in range [1, 10^6].
//        Answers within 10^-6 of the true value will be accepted as correct.

public class _774_MinimizeMaxDistanceToGasStation {


    public static double minMaxGasDist(int[] stations, int K) {
        double left = 0, right = 1e8;
        int n = stations.length;

        // until loop until distance within threshold
        while (right - left > 1e-6) {
            double maxDis = (right + left) / 2;

            int cnt = 0;
            for (int i = 0; i < n - 1; ++i) {
                // count how many extra segments(gas stations) can insert into
                // by using maxDis to split i~i+1
                cnt += (stations[i + 1] - stations[i]) / maxDis;
            }

            if (cnt <= K) {
                // maxDis is larger, need to shrink
                right = maxDis;
            } else {
                // maxDis is smaller, need to expand
                left = maxDis;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        double m1 = minMaxGasDist(new int[]
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                9);

        double m2 = minMaxGasDist(new int[]
                {10, 19, 25, 27, 56, 63, 70, 87, 96, 97},
                3);
    }
}
