package string;

public class _214_ShortestPalindrome {

    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String ss = new StringBuilder(s).append("#").append(rev).toString();
        char[] cs = ss.toCharArray();
        int[] prefix = new int[cs.length];
        int j = 0;
        for (int i = 1; i < cs.length; i++) {
            while (j > 0 && cs[j] != cs[i]) {
                j = prefix[j - 1];
            }
            if (cs[i] == cs[j]) {
                j++;
            }
            prefix[i] = j;
        }

        int l = prefix[cs.length - 1];
//        return rev + s.substring(l);
        return rev.substring(0, rev.length() - l) + s;
    }
}
