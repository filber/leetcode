package string;

// https://leetcode.com/problems/detect-capital/
public class _520_DetectCapital {
    public static boolean detectCapitalUse(String word) {
        int lowerCnt = 0;
        int upperCnt = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lowerCnt++;
            } else {
                upperCnt++;
            }
        }
        if (lowerCnt == 0 || upperCnt == 0) {
            return true;
        } else if (upperCnt == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean b1 = detectCapitalUse("USA"); // true
        boolean b2 = detectCapitalUse("leetcode"); // true
        boolean b3 = detectCapitalUse("Google"); // true
        boolean b4 = detectCapitalUse("FlaG"); // false
    }
}
