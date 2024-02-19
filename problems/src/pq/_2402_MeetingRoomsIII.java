package pq;

//https://leetcode.com/problems/meeting-rooms-iii/

import java.util.Arrays;
import java.util.PriorityQueue;

public class _2402_MeetingRoomsIII {

    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            available.add(i);
        }
        PriorityQueue<Long[]> used = new PriorityQueue<>((a, b) ->
                a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] count = new int[n];
        for(int[] meeting:meetings) {
            int start = meeting[0];
            long end = meeting[1];
            while(!used.isEmpty() && start > used.peek()[0]) {
                Long[] m = used.remove();
                available.add(m[1].intValue());
            }
            if(available.isEmpty()) {
                Long[] m = used.remove();
                available.add(m[1].intValue());
                end = m[0] + end - start;
            }
            long room = available.remove();
            count[(int) room]++;
            used.add(new Long[]{end, room});
        }

        int idx=0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
