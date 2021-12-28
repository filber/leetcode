import java.util.*;

public class _692_TopKFrequentWords {

    public static class WordComparator implements Comparator<String> {
        private HashMap<String,Integer> count;
        public WordComparator(HashMap<String,Integer> count) {
            this.count = count;
        }

        @Override
        public int compare(String o1, String o2) {
            int leftCnt = count.get(o1);
            int rightCnt = count.get(o2);
            if (leftCnt!=rightCnt) {
                return Integer.compare(rightCnt,leftCnt);
            } else {
                return o1.compareTo(o2);
            }
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        // Construct count map
        HashMap<String,Integer> count = new HashMap<>();
        for (String word : words) {
            Integer cnt = count.get(word);
            if (cnt == null) {
                count.put(word,1);
            } else {
                count.put(word, cnt + 1);
            }
        }

        // Construct priority queue
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(count.size(),
                new WordComparator(count));
        for (String word : count.keySet()) {
            priorityQueue.add(word);
        }

        // Construct result
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(priorityQueue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        // Output: ["i","love"]
        List<String> l1 = topKFrequent(new String[]{
                "i","love","leetcode","i","love","coding"
        },2);

        // Output: ["the","is","sunny","day"]
        List<String> l2 = topKFrequent(new String[]{
                "the","day","is","sunny","the","the","the","sunny","is","is"
        },4);
    }
}
