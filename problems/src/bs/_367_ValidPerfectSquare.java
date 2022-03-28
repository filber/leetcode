package bs;

public class _367_ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long l = 1, r = Integer.MAX_VALUE;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
