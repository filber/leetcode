package bs;

public class _367_ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int l = 1, r = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int res = num / mid;
            int rem = num % mid;
            if (res == mid && rem == 0) {
                return true;
            } else if (res >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
