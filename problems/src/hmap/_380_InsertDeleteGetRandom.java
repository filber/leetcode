package hmap;

//https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.*;

public class _380_InsertDeleteGetRandom {

    public static class RandomizedSet {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        public RandomizedSet() {
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int idx = map.get(val);
            int last = list.get(list.size()-1);
            list.set(idx,last); // set element in array list, O(1)
            list.remove(list.size() - 1); // delete last element, O(1)
            map.put(last, idx);
            map.remove(val); // remove val at last, in case val is the last element
            return true;
        }

        public int getRandom() {
            int idx = random.nextInt(list.size());
            return list.get(idx);
        }
    }
}
