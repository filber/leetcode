package greedy;

// https://leetcode.com/problems/can-place-flowers/

public class _605_CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int max) {
        int cnt = 0;
        int n = flowerbed.length;
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 0 : flowerbed[i - 1];
            int middle = flowerbed[i];
            int right = i == n - 1 ? 0 : flowerbed[i + 1];
            if (left == 0 && middle == 0 && right == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }

        return cnt >= max;
    }

    public static void main(String[] args) {
        boolean b1 = canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1); // true
        boolean b2 = canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2); // false
        boolean b3 = canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2); // true
        boolean b4 = canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 0}, 3); // true

    }
}
