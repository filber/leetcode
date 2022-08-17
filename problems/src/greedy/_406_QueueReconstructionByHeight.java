package greedy;

//https://leetcode.com/problems/queue-reconstruction-by-height/

import java.util.Arrays;
import java.util.LinkedList;

public class _406_QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[0][2]);
    }
}
