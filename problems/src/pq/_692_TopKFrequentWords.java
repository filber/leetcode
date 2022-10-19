package pq;

//https://leetcode.com/problems/top-k-frequent-words/

import java.util.*;

public class _692_TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Object[]> priorityQueue = new PriorityQueue<>(new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                String w1 = (String) o1[0];
                Integer cnt1 = (Integer) o1[1];
                String w2 = (String) o2[0];
                Integer cnt2 = (Integer) o2[1];
                if (cnt1.equals(cnt2)) {
                    return w1.compareTo(w2);
                } else {
                    return cnt2 - cnt1;
                }
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Object[]{entry.getKey(), entry.getValue()});
        }

        List<String> rst = new ArrayList<>();
        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            rst.add((String) priorityQueue.poll()[0]);
        }
        return rst;
    }
}
