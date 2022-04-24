package bs;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/

public class _744_FindSmallestLetterGreaterThanTarget {


    //Note that the letters wrap around.
    // 'a' < 'b' < 'c' < ... < 'z' < 'a' < 'b' < ...

    public char nextGreatestLetter(char[] letters, char target) {
        if (target < letters[0] || target > letters[letters.length - 1]) {
            return letters[0];
        }
        int l = 0, r = letters.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[l];
    }

}
