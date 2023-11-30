package dfs;

//https://leetcode.com/problems/flatten-nested-list-iterator/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _341_FlattenNestedListIterator {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public static class NestedRealInteger implements NestedInteger {

        private int val;

        public NestedRealInteger(int val) {
            this.val = val;
        }

        public boolean isInteger() {
            return true;
        }

        public Integer getInteger() {
            return val;
        }

        @Override
        public List<NestedInteger> getList() {
            return new ArrayList<>();
        }
    }

    public static class NestedList implements NestedInteger {

        private List<NestedInteger> list;

        public NestedList(List<NestedInteger> list) {
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }

    public static class NestedIterator implements Iterator<Integer> {

        Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> list = new ArrayList<>();
            dfs(list, nestedList, 0);
            iterator = list.iterator();
        }

        private void dfs(List<Integer> list, List<NestedInteger> nestedList, int i) {
            if (i == nestedList.size()) {
                return;
            }
            NestedInteger nestedInteger = nestedList.get(i);
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                NestedIterator nestedIterator = new NestedIterator(nestedInteger.getList());
                while (nestedIterator.hasNext()) {
                    list.add(nestedIterator.next());
                }
            }
            dfs(list, nestedList, i + 1);
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}
