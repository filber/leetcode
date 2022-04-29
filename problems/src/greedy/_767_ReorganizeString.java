package greedy;

//https://leetcode.com/problems/reorganize-string/

import java.util.PriorityQueue;

public class _767_ReorganizeString {

    public String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        int[][] freq = new int[26][2];
        for (char ch : chars) {
            freq[ch - 'a'][0]++;
            freq[ch - 'a'][1] = ch;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int[] f : freq) {
            if (f[0] > 0) {
                pq.add(f);
            }
        }
        if (2 * pq.peek()[0] > chars.length + 1) {
            return "";
        }

        int idx = 0;
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            chars[idx++] = (char) first[1];
            chars[idx++] = (char) second[1];
            first[0]--;
            if (first[0] > 0) {
                pq.add(first);
            }
            second[0]--;
            if (second[0] > 0) {
                pq.add(second);
            }
        }

        if (!pq.isEmpty()) {
            chars[idx] = (char) pq.peek()[1];
        }

        return new String(chars);
    }
}
