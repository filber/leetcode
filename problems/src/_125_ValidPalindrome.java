//https://leetcode.com/problems/valid-palindrome/
//[String]
public class _125_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        char[] arr = new char[s.length()];
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                arr[n++] = ch;
            } else if (ch>='A'&&ch<='Z') {
                arr[n++] = (char) (ch - 'A' + 'a');
            }
        }

        for (int i = 0; i < n/2; i++) {
            if (arr[i]!=arr[n-1-i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean p1 = isPalindrome("A man, a plan, a canal: Panama");
        boolean p2 = isPalindrome("race a car");
        boolean p3 = isPalindrome(" ");
        boolean p4 = isPalindrome("0P");
    }
}
