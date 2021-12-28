import java.util.*;

// TOPICS:
// [Backtracking]

// Using CharCnt instead of map to improve efficiency.
public class _1079_LetterTilePossibilities {

    private int cnt = 0;
    private int[] chCnt = new int[26];
    private int remain = 0;
    private Character[] chars = null;

    public int numTilePossibilities(String tiles) {
        remain = tiles.length();

        Set<Character> chSet = new HashSet<>();
        for (int i = 0; i < tiles.length(); i++) {
            char ch = tiles.charAt(i);
            chSet.add(ch);
            chCnt[ch - 'A'] ++;
        }
        chars = new Character[chSet.size()];
        chars = chSet.toArray(chars);

        backTrack();
        return cnt;
    }

    private void backTrack() {
        // 0. Guard conditions
        if (remain == 0) {
            return;
        }

        for (char ch : chars) {
            if (chCnt[ch - 'A'] != 0) {
                cnt++;
                remain--;
                chCnt[ch - 'A'] --;

                backTrack();

                remain++;
                chCnt[ch - 'A'] ++;
            }
        }
    }

    public static void main(String[] args) {
        int c1 = new _1079_LetterTilePossibilities().numTilePossibilities("AAB");

        int c2 = new _1079_LetterTilePossibilities().numTilePossibilities("V");

        int c3 = new _1079_LetterTilePossibilities().numTilePossibilities("AAABBC");
    }
}
