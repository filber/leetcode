package dp;

// https://leetcode.com/problems/count-sorted-vowel-strings/

public class _1641_CountSortedVowelStrings {

    public static int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        int sum = 0;

        for (int j = 0; j < n; j++) {
            sum = a + e + i + o + u;
            a = sum;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
//            u = u;
        }

        return sum;
    }

    public static void main(String[] args) {
        int c1 = countVowelStrings(1); // 5
        int c2 = countVowelStrings(2); // 15
        int c3 = countVowelStrings(33); // 66045
    }
}
