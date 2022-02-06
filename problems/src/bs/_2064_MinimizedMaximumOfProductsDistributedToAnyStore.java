package bs;

// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
public class _2064_MinimizedMaximumOfProductsDistributedToAnyStore {

    public static int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = 100001;

        while (l < r) {
            int mid = (l + r) / 2;
            int store = 0;

            for (int quantity : quantities) {
                if (quantity % mid == 0) {
                    store += quantity / mid;
                } else {
                    store += quantity / mid + 1;
                }
            }

            if (store <= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        // 11 = [2, 3, 3, 3], 6 = [3,3]
        // 3
        int m1 = minimizedMaximum(6, new int[]{11, 6});


        // 15 = [10,5], 10 = [10], 10 = [5,5]
        // 10
        int m2 = minimizedMaximum(5, new int[]{15, 10, 10});

        // 15 = [5,5,5], 10 = [5,5], 10 = [5,5]
        // 5
        int m4 = minimizedMaximum(7, new int[]{15, 10, 10});

        // 100000 = [100000]
        // 100000
        int m3 = minimizedMaximum(1, new int[]{100000});
    }
}
