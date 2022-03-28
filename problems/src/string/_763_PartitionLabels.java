package string;

//https://leetcode.com/problems/partition-labels/

import java.util.ArrayList;
import java.util.List;

public class _763_PartitionLabels {

    // Two Pointers
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] lastPos = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            lastPos[ch - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = lastPos[chars[0] - 'a'];
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            int pos = lastPos[ch - 'a'];
            if (pos > r) {
                r = pos;
            }
            if (i == r) {
                ans.add(r - l + 1);
                l = i + 1;
                r = i + 1;
            }
        }

        return ans;
    }
}
