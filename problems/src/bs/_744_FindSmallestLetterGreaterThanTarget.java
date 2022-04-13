package bs;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/

public class _744_FindSmallestLetterGreaterThanTarget {


    //Note that the letters wrap around.
    // 'a' < 'b' < 'c' < ... < 'z' < 'a' < 'b' < ...
    char[] letters;
    char target;

    public char nextGreatestLetter(char[] letters, char target) {
        this.letters = letters;
        this.target = target;
        int idx = search(0, letters.length - 1);
        if (idx == -1) {
            return letters[0];
        } else {
            return letters[idx];
        }
    }

    private int search(int l, int r) {
        if (l > r) {
            return -1;
        } else if (l == r) {
            if (target < letters[l]) {
                return l;
            } else {
                return -1;
            }
        } else {
            int mid = (l + r) / 2;
            if (letters[mid] <= target) {
                return search(mid + 1, r);
            } else {
                // target < letters[mid]
                return search(l, mid);
            }
        }
    }
}
