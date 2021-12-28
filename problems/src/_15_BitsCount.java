public class _15_BitsCount {

    // cannot handle negative integers!
    public static int count1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count ++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int count2(int n) {
        int flag = 1;
        int count = 0;
        // iterate for 32 times
        while (flag!=0) {
            if ((n & flag) != 0) {
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // best solution
    // take advantage of (n-1)&n
    public static int count3(int n) {
        int count = 0;
        while (n!=0) {
            n = (n-1)&n;
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count1(15));
        System.out.println(count2(-1));
        System.out.println(count3(-1));
        System.out.println(count3(15));
    }
}
