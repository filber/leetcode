package math;

public class _202_HappyNumber {

    public static boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            if (slow == 1 || fast == 1) {
                return true;
            } else {
                slow = getNext(slow);
                fast = getNext(fast);
            }
            if (fast == 1) {
                return true;
            } else {
                fast = getNext(fast);
            }
        } while (fast != slow);

        // loop detected
        return false;
    }

    private static int getNext(int n) {
        int ans = 0;
        while (n != 0) {
            int digit = n % 10;
            ans += digit * digit;
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean b1 = isHappy(19); // true
        boolean b2 = isHappy(2); // false
    }


}
