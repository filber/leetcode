package string;

//https://leetcode.com/problems/palindrome-number/
//[String]
public class _9_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }
        if (x==0) {
            return true;
        }

        int[] arr = new int[32];
        int n = 0;
        while (x!=0) {
            arr[n] = x % 10;
            x /= 10;
            n++;
        }


        for (int i = 0; i <= n / 2; i++) {
            if (!(arr[i] == arr[n - 1 - i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean p1 = isPalindrome(121);
        boolean p2 = isPalindrome(-121);
        boolean p3 = isPalindrome(10);
        boolean p4 = isPalindrome(3);
        boolean p5 = isPalindrome(101);
    }

}
