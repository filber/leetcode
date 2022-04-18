package greedy;

//https://leetcode.com/problems/reorganize-string/

import java.util.PriorityQueue;

public class _767_ReorganizeString {

    public String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        for (char ch : chars) {
            cnt[ch - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                pq.add(new int[]{i, cnt[i]});
            }
        }

        if (2 * pq.peek()[1] > (chars.length + 1)) {
            return "";
        }

        int idx = 0;
        while (pq.size() > 1) {
            int[] first = pq.poll();
            chars[idx++] = (char) (first[0] + 'a');
            int[] second = pq.poll();
            chars[idx++] = (char) (second[0] + 'a');
            first[1]--;
            if (first[1] > 0) {
                pq.add(first);
            }
            second[1]--;
            if (second[1] > 0) {
                pq.add(second);
            }
        }

        if (!pq.isEmpty()) {
            chars[idx] = (char) (pq.poll()[0] + 'a');
        }

        return new String(chars);
    }
}
