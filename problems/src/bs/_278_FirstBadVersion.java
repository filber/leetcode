package bs;

//https://leetcode.com/problems/first-bad-version/

public class _278_FirstBadVersion {
    public class VersionControl {
        int total;
        int bad;

        boolean isBadVersion(int version) {
            if (version > total) {
                return false;
            }
            return version == bad;
        }

    }


    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l = 1, r = Integer.MAX_VALUE;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (isBadVersion(mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }

}
