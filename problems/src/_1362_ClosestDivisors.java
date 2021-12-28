//TOPICS:
//[Math]
public class _1362_ClosestDivisors {
    public static int[] closestDivisors(int num) {
        int val = (int) Math.sqrt((double) num + 2);
        while (val >= 1) {
            if ((num + 1) % val == 0) {
                // found
                return new int[]{val, (num + 1) / val};
            } else if ((num + 2) % val == 0) {
                // found
                return new int[]{val, (num + 2) / val};
            } else {
                val--;
            }
        }
        return new int[]{1, num + 1};
    }

    public static void main(String[] args) {
        int[] c1 = closestDivisors(8);
        int[] c2 = closestDivisors(123);
        int[] c3 = closestDivisors(999);
        int[] c4 = closestDivisors(1);
        int[] c5 = closestDivisors(2);
    }



}
