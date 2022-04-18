package greedy;

import java.util.PriorityQueue;

//https://leetcode.com/problems/task-scheduler/
public class _621_TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        n++;
        int[] cnt = new int[26];
        for (char t : tasks) {
            cnt[t - 'A']++;
        }

        int maxFreq = 0;
        int maxFreqCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == maxFreq) {
                maxFreqCnt++;
            } else if (cnt[i] > maxFreq) {
                maxFreq = cnt[i];
                maxFreqCnt = 1;
            }
        }

        return Math.max((maxFreq - 1) * n + maxFreqCnt, tasks.length);
    }

    public int leastIntervalPQ(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        n++;
        int[] cnt = new int[26];
        for (char t : tasks) {
            cnt[t - 'A']++;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                priorityQueue.add(cnt[i]);
            }
        }

        int time = 0;
        int[] arr = new int[n];
        while (!priorityQueue.isEmpty()) {
            int k = Math.min(n, priorityQueue.size());
            for (int i = 0; i < k; i++) {
                arr[i] = priorityQueue.poll() - 1;
                time++;
            }
            for (int i = 0; i < k; i++) {
                if (arr[i] > 0) {
                    priorityQueue.add(arr[i]);
                }
            }

            if (!priorityQueue.isEmpty()) {
                time += n - k;
            }
        }

        return time;
    }
}
