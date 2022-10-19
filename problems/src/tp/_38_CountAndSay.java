package tp;

//https://leetcode.com/problems/count-and-say/

public class _38_CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String say = countAndSay(n - 1);
        char[] chars = say.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char digit = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                sb.append(count);
                sb.append(digit);
                count = 1;
                digit = chars[i];
            }
        }
        sb.append(count);
        sb.append(digit);
        return sb.toString();
    }
}
