package greedy;

//https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/

public class _2193_MinimumNumberOfMovesToMakePalindrome {

    char[] chars;
    int n;

    public int minMovesToMakePalindrome(String s) {
        chars = s.toCharArray();
        n = chars.length;
        int l = 0, r = n - 1;
        int moves = 0;
        while (l < r) {
            if (chars[l] != chars[r]) {
                int leftCnt = search(l, chars[r], 1);
                int rightCnt = search(r, chars[l], -1);
                if (leftCnt < rightCnt) {
                    moves += leftCnt;
                    swaps(l + leftCnt, -1, leftCnt);
                } else {
                    moves += rightCnt;
                    swaps(r - rightCnt, 1, rightCnt);
                }
            }
            l++;
            r--;
        }
        return moves;
    }

    private void swaps(int i, int dir, int cnt) {
        for (int k = 0; k < cnt; k++) {
            char tmp = chars[i];
            chars[i] = chars[i + dir];
            chars[i + dir] = tmp;
            i += dir;
        }
    }

    private int search(int i, char ch, int dir) {
        int j = i;
        while (chars[j] != ch) {
            j += dir;
        }
        return Math.abs(j - i);
    }
}
