package dfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _1286_IteratorForCombination {

    public static class CombinationIterator {

        char[] chars;
        int len;
        List<String> list = new ArrayList<>();
        Iterator<String> iterator;

        public CombinationIterator(String characters, int combinationLength) {
            if (characters.isEmpty()) {
                return;
            }
            chars = characters.toCharArray();
            len = combinationLength;

            backtracking(0, new char[len], 0);

            iterator = list.iterator();
        }

        private void backtracking(int i, char[] tmp,int k) {
            if (k == len) {
                list.add(new String(tmp));
                return;
            }

            for (int j = i; j < chars.length; j++) {
                tmp[k] = chars[j];
                backtracking(j + 1, tmp, k + 1);
            }
        }

        public String next() {
            return iterator.next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}
