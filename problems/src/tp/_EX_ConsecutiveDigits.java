package tp;

public class _EX_ConsecutiveDigits {

    public String compress(String str) {
        char[] chars = str.toCharArray();
        char[] rst = new char[chars.length];
        int r = 0;
        int sum = chars[0] - '0';
        for (int l = 1; l < chars.length; l++) {
            if (chars[l] == chars[l - 1]) {
                sum += chars[l] - '0';
            } else {
                r = fillRst(rst, r, sum);
                sum = chars[l] - '0';
            }
        }
        r = fillRst(rst, r, sum);
        return new String(rst, 0, r);
    }

    private int fillRst(char[] rst, int r, int sum) {
        String segment = String.valueOf(sum);
        char[] sChars = segment.toCharArray();
        for (int k = 0; k < sChars.length; k++) {
            rst[r++] = sChars[k];
        }

        return r;
    }
}
