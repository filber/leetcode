package math;

// https://leetcode.com/problems/add-binary/
public class _67_AddBinary {

    public static String addBinary(String a, String b) {
        char pre = '0';
        int l = a.length() - 1;
        int r = b.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (l >= 0 && r >= 0) {
            pre = add(sb,a.charAt(l),b.charAt(r),pre);
            l--;
            r--;
        }

        while (l >= 0) {
            pre = add(sb,a.charAt(l),pre);
            l--;
        }
        while (r >= 0) {
            pre = add(sb,b.charAt(r),pre);
            r--;
        }
        if (pre == '1') {
            sb.insert(0,'1');
        }

        return sb.toString();
    }

    private static char add(StringBuffer sb,char a,char b,char pre) {
        char cur;
        int cnt = 0;
        if (a == '1') {
            cnt++;
        }
        if (b == '1') {
            cnt++;
        }
        if (pre == '1') {
            cnt++;
        }

        if (cnt == 0) {
            pre = '0';
            cur = '0';
        } else if (cnt == 1) {
            pre = '0';
            cur = '1';
        }
        else if (cnt == 2) {
            pre = '1';
            cur = '0';
        } else {
            pre = '1';
            cur = '1';
        }

        sb.insert(0,cur);

        return pre;
    }

    private static char add(StringBuffer sb,char a,char pre) {
        char cur;
        int cnt = 0;
        if (a == '1') {
            cnt++;
        }
        if (pre == '1') {
            cnt++;
        }
        if (cnt==0) {
            cur = '0';
            pre = '0';
        } else if (cnt == 1) {
            cur = '1';
            pre = '0';
        } else {
            cur = '0';
            pre = '1';
        }

        sb.insert(0,cur);

        return pre;
    }


    public static void main(String[] args) {
        String s1 = addBinary("11","1"); // "100"
        String s2 = addBinary("1010","1011"); // "10101"
        String s3 = addBinary("1","111"); // "1000"
        String s4 = addBinary("101111","10"); // "1000"
    }
}
