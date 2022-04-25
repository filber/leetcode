package array_matrix;

//https://leetcode.com/problems/peeking-iterator/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class _284_PeekingIterator {

    class PeekingIterator implements Iterator<Integer> {
//        Constraints:
//                1 <= nums.length <= 1000
//                1 <= nums[i] <= 1000

        List<Integer> list = new ArrayList<>();
        int cur = 0;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return list.get(cur);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int val = peek();
            cur++;
            return val;
        }

        @Override
        public boolean hasNext() {
            return cur != list.size();
        }
    }
}
