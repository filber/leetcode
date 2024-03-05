package greedy;

//https://leetcode.com/problems/bag-of-tokens/

import java.util.Arrays;

public class _948_BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0) {
            return 0;
        }
        Arrays.sort(tokens);

        int score = 0;
        int l = 0, r = tokens.length - 1;
        while (l < r) {
            // move left: power=>score
            // greedy: we convert power into score firstly
            if (power >= tokens[l]) {
                power -= tokens[l];
                l++;
                score++;
            }
            // move right: token=>power
            // as long as you could move right, meaning you shall earn extra power from consequent moving left
            else if (score > 0) {
                power += tokens[r];
                r--;
                score--;
            }
            // can't move:
            else {
                return 0;
            }
        }

        // convert the last token to score
        if (power >= tokens[l]) {
            score++;
        }
        return score;
    }
}
