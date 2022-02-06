package array_matrix;
// https://leetcode.com/problems/4sum-ii/

import java.util.HashMap;
import java.util.Map;

public class _454_4SumII {

    // 0 <= i, j, k, l < n
    // nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int cnt = 0;
        Map<Integer, Integer> sum1 = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                sum1.put(n1 + n2, sum1.getOrDefault(n1 + n2, 0) + 1);
            }
        }

        for (int n3 : nums3) {
            for (int n4 : nums4) {
                cnt += sum1.getOrDefault(-n3 - n4, 0);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // 2
        int c1 = fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        // 1
        int c2 = fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0});
        // 6
        int c3 = fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1});
        // 3825346
        int c4 = fourSumCount(
                new int[]{-64, 35, 62, -34, 43, -7, 61, 71, 0, 38, -33, -4, -41, 59, 23, -26, 32, 59, 50, -20, -48, -14, -79, -54, -66, 94, 99, -52, 9, 4, -69, -2, 27, 4, 65, 41, -71, -66, -46, -2, 39, -78, -93, 68, -90, -7, 30, -52, -81, -54, 98, -43, -54, 96, -69, 1, -42, 58, 79, 81, -13, -36, -24, -16, 56, 7, 0, -12, 49, -67, 69, 16, -26, -94, 31, 12, -19, 78, 36, 1, 35, -13, -67, 10, -40, 44, -29, -52, 18, -32, 72, -6, -27, 8, 82, -89, 60, -27, -41, -33, -13, -9, -87, 72, 63, -32, -14, -82, -33, 23, -69, 89, -7, 25, -65, -46, 18, -93, -21, -99, -9, -93, 22, -77, 67, 37, -50, -99, -75, -72, 22, 53, -61, -68, 14, -75, 50, -62, 44, -51, 35, -73, -11, -40, 46, -45, 40, -88, -30, 22, -21, 63, -62, 5, -16, -46, 20, -69, 9, 10, -37, -31, 80, -61, -82, -12, -1, 55, 16, -37, -68, -74, -20, -51, 79, -64, -46, 3, -63, 11, -28, -51, 62},
                new int[]{-66, -58, -24, 78, -93, -20, 79, 19, -2, 51, -18, -92, 43, -100, -51, -84, -31, -62, 79, 9, -8, 99, 14, -25, 54, -2, -7, 6, -80, -20, 22, 99, 100, 32, -92, -25, 82, 80, -77, 16, 44, 50, 72, 63, 22, 67, -89, -86, 93, 22, -27, 68, -86, 54, -60, -11, 4, -32, 64, -75, -22, 75, 28, 70, -75, 50, -22, -1, 10, -82, 48, -71, 9, -55, -34, -100, -6, -83, 13, 68, -99, 2, 33, -83, 25, 3, 7, 18, 26, -97, -19, 59, -28, 5, 62, 37, 72, -54, 93, -55, 5, 42, 38, 19, 83, -24, 28, 64, -48, 48, -13, -97, 84, -30, 55, 65, -58, 69, 12, 19, 10, -98, 13, -87, 98, 79, -90, 18, -12, 21, -45, 26, 81, 42, 69, -100, 51, 62, -100, -71, 29, 88, 4, -39, -65, -73, -77, 49, -84, -20, -71, -29, -44, -14, 91, 73, -53, 48, 28, 23, 39, -67, -11, -43, 85, -2, -14, 17, -51, -67, 41, -57, 90, -25, 29, 9, 96, 45, -98, -45, 43, -3, 70},
                new int[]{-31, 80, -61, -24, 39, -68, -57, 85, 73, 71, -83, 63, -28, -40, -79, -85, 60, -38, -44, -36, 10, -67, 80, 2, 79, 23, 11, -73, 99, -1, -36, 75, 18, -5, -8, 2, 4, 67, -38, -45, 29, -25, -39, -25, -86, -40, 47, 94, 88, 50, 26, -98, -83, 70, 42, 72, -81, 99, -73, -97, -1, 39, -21, 25, 26, -24, -92, 22, -2, 67, 90, -14, 3, 74, -18, 62, 69, 5, -33, 73, 5, 95, 13, -47, 70, 20, -21, 87, -72, -89, 71, 78, 59, 57, 91, -71, -87, -8, -58, -39, -88, 84, -72, 6, 33, 33, -65, -8, -46, 44, 48, 0, 76, 69, 63, -69, 93, -5, 43, -76, 6, -58, -77, -87, -18, 69, -19, 81, 30, -15, 63, 24, -8, 99, -63, -33, -84, -74, 39, 4, -12, -31, -99, 23, -79, -44, 90, -84, -80, -82, 13, 54, -1, 12, 2, 20, 88, 3, -98, 60, 49, 94, -27, -13, -77, 15, -48, -84, -60, -3, 68, -32, 38, -29, 77, 79, 22, -12, -75, 94, -98, 65, 39},
                new int[]{-35, 93, 80, -55, -13, -62, -72, 71, 63, -31, 11, -58, -21, 33, 47, -47, -92, 42, 100, 66, -75, 6, -14, -13, 78, -29, 29, 15, -13, -1, 65, -30, -29, -53, 7, 58, 95, -14, 66, 98, 85, 81, -37, 72, -4, 8, -20, 12, -3, -40, -61, 59, -17, 17, -94, -6, -44, 49, -39, 65, -90, -8, 23, -49, -18, -8, 83, 64, -65, -65, -47, -77, -97, 30, -45, 53, -14, -75, -28, 21, -7, 2, -76, 81, -12, 88, -9, -4, -30, 94, -41, -78, 65, 2, -57, 42, 92, 71, -19, -34, 67, 60, -62, 49, -75, 55, -51, -49, 22, -81, -39, -96, 54, -88, 75, -15, 13, -82, -9, -50, -99, -31, -51, -95, 28, -63, -48, 62, 93, -64, 21, -37, 95, -47, -41, -65, 97, 78, 80, 9, -68, -68, -5, -43, -75, 79, -49, -75, 40, 17, 23, -81, 41, -91, -29, -17, 93, -26, -43, -29, -36, -69, 45, -80, 73, 3, -99, 18, 49, 8, 40, -100, 38, -73, 44, 66, -20, 39, -99, -20, 86, 0, -34});
    }
}