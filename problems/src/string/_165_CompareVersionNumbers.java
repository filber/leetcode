package string;

//https://leetcode.com/problems/compare-version-numbers/

public class _165_CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");

        return cmpRevisions(revisions1, revisions2);
    }

    private int cmpRevisions(String[] revisions1, String[] revisions2) {
        int i = 0, j = 0;
        int rst;
        while (i < revisions1.length && j < revisions2.length) {
            rst = cmpRevision(revisions1[i], revisions2[j]);
            if (rst != 0) {
                return rst;
            }
            i++;
            j++;
        }
        if (i == revisions1.length && j == revisions2.length) {
            return 0;
        } else if (i == revisions1.length) {
            for (int k = j; k < revisions2.length; k++) {
                if (!isAllZero(revisions2[k])) {
                    return -1;
                }
            }
        } else {
            // j == revisions2.length
            for (int k = i; k < revisions1.length; k++) {
                if (!isAllZero(revisions1[k])) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private int cmpRevision(String revision1, String revision2) {
        int i = 0, j = 0;
        char[] leftChars = revision1.toCharArray(), rightChars = revision2.toCharArray();

        while (i < leftChars.length && leftChars[i] == '0') {
            i++;
        }
        while (j < rightChars.length && rightChars[j] == '0') {
            j++;
        }
        while (i < leftChars.length && j < rightChars.length && leftChars[i] == rightChars[j]) {
            i++;
            j++;
        }
        if (i == leftChars.length && j == rightChars.length) {
            return 0;
        } else if (i == leftChars.length) {
            return -1;
        } else if (j == rightChars.length) {
            return 1;
        } else {
            if (leftChars.length - i == rightChars.length - j) {
                return Integer.compare(leftChars[i], rightChars[j]);
            } else {
                return Integer.compare(leftChars.length - i, rightChars.length - j);
            }
        }
    }

    private boolean isAllZero(String revision) {
        char[] chars = revision.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                return false;
            }
        }

        return true;
    }

}
