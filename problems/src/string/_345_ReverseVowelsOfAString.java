package string;

//https://leetcode.com/problems/reverse-vowels-of-a-string/

public class _345_ReverseVowelsOfAString {

    private static final boolean[] isVowel = new boolean[128];

    static {
        isVowel['a'] = true;
        isVowel['A'] = true;
        isVowel['e'] = true;
        isVowel['E'] = true;
        isVowel['i'] = true;
        isVowel['I'] = true;
        isVowel['o'] = true;
        isVowel['O'] = true;
        isVowel['u'] = true;
        isVowel['U'] = true;
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            char lCh = chars[l], rCh = chars[r];
            if (isVowel[lCh] && isVowel[rCh]) {
                chars[l++] = rCh;
                chars[r--] = lCh;
            } else if (isVowel[lCh]) {
                r--;
            } else if (isVowel[rCh]) {
                l++;
            } else {
                l++;
                r--;
            }
        }
        return new String(chars);
    }
}
