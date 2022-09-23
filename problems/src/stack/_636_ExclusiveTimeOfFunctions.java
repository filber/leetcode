package stack;

//https://leetcode.com/problems/exclusive-time-of-functions/

import java.util.List;

public class _636_ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int[][] stack = new int[logs.size()][2];
        int top = -1;
        for (String log : logs) {
            String[] info = log.split(":");
            if ("start".equals(info[1])) {
                int[] peek = stack[++top];
                peek[0] = Integer.parseInt(info[0]);
                peek[1] = Integer.parseInt(info[2]);
            } else {
                int[] peek = stack[top--];
                int executionTime = Integer.parseInt(info[2]) - peek[1] + 1;
                res[peek[0]] += executionTime;
                if (top >= 0) {
                    res[stack[top][0]] -= executionTime;
                }
            }
        }
        return res;
    }
}
