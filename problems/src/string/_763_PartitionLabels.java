package string;

import java.util.ArrayList;
import java.util.List;

public class _763_PartitionLabels {

    // Greedy
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] lastPos = new int[26];
        for (int i = 0; i < n; i++) {
            lastPos[chars[i] - 'a'] = i;
        }

        int l = 0, r = 0;
        int winEnd = 0;
        while (r < n) {
            int pos = lastPos[chars[r] - 'a'];
            if (pos > winEnd) {
                winEnd = pos;
            }
            if (r == winEnd) {
                ans.add(r - l + 1);
                l = r + 1;
            }
            r++;
        }

        return ans;
    }


    int[] letterCnt = new int[26];
    int[] winState = new int[26];
    int J = 0;  // satisfied letters in Window
    int K = 0;  // distinct letters in Window

    // Sliding Window
    public List<Integer> partitionLabelsSW(String s) {

        List<Integer> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            letterCnt[ch - 'a']++;
        }

        int n = chars.length;
        int l = 0, r = 0;
        while (r < n) {
            int idx = chars[r] - 'a';
            winState[idx]++;

            // update J & K
            int cnt = winState[idx];
            K += cnt == 1 ? 1 : 0; // new letters
            J += cnt == letterCnt[idx] ? 1 : 0; // this letter is satisfied

            if (J == K) {
                ans.add(r - l + 1);
                l = r + 1;
                // reset window
                J = 0;
                K = 0;
            }
            r++;
        }

        return ans;
    }
}
