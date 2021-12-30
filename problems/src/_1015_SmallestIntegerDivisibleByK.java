
//TOPICS:
//[Math],[Hash Map]
public class _1015_SmallestIntegerDivisibleByK {

    public static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0) {
            return -1;
        }
        boolean[] remainder = new boolean[k];
        int n = 1;
        int preModulo = n % k;
        int len = 1;
        while (!remainder[preModulo]) {
            if (preModulo==0) {
                return len;
            } else {
                len++;
                remainder[preModulo] = true;
                preModulo = (preModulo * 10 + 1) % k;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int l1 = smallestRepunitDivByK(1);
        int l2 = smallestRepunitDivByK(2);
        int l3 = smallestRepunitDivByK(3);
        int l4 = smallestRepunitDivByK(5);
        int l5 = smallestRepunitDivByK(17);
    }


}
