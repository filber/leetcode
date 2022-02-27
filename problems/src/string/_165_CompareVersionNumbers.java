package string;

//https://leetcode.com/problems/compare-version-numbers/

public class _165_CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");

        return cmpRevisions(revisions1, revisions2);
    }

    private int cmpRevisions(String[] revisions1, String[] revisions2) {
        int l = 0;
        int r = 0;
        int rst = 0;
        while (l < revisions1.length
                && r < revisions2.length) {
            rst = cmpRevision(revisions1[l], revisions2[r]);
            if (rst != 0) {
                return rst;
            }
            l++;
            r++;
        }

        if (l == revisions1.length && r == revisions2.length) {
            return 0;
        } else if (l == revisions1.length) {
            if (isAllZero(revisions2, r)) {
                return 0;
            }
            return -1;
        } else if (r == revisions2.length) {
            if (isAllZero(revisions1, l)) {
                return 0;
            }
            return 1;
        } else {
            return rst;
        }
    }

    private int cmpRevision(String revision1, String revision2) {
        int l = 0, r = 0;
        char[] chars1 = revision1.toCharArray();
        char[] chars2 = revision2.toCharArray();

        while (l < chars1.length && chars1[l] == '0') {
            l++;
        }

        while (r < chars2.length && chars2[r] == '0') {
            r++;
        }

        while (l < chars1.length && r < chars2.length && chars1[l] == chars2[r]) {
            l++;
            r++;
        }

        if (l == chars1.length && r == chars2.length) {
            return 0;
        } else if (l == chars1.length) {
            return -1;
        } else if (r == chars2.length) {
            return 1;
        } else {
            if (chars1.length - l == chars2.length - r) {
                return Integer.compare(chars1[l], chars2[r]);
            } else {
                return Integer.compare(chars1.length - l, chars2.length - r);
            }
        }
    }

    private boolean isAllZero(String[] revisions, int start) {
        for (int i = start; i < revisions.length; i++) {
            char[] chars = revisions[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != '0') {
                    return false;
                }
            }
        }
        return true;
    }

}
