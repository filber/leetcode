package dp;

//https://leetcode.com/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<Integer> first = new ArrayList<>();
        first.add(1);
        List<List<Integer>> list = new ArrayList<>();
        list.add(first);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prev = list.get(i - 2);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < i - 2; j++) {
                row.add(prev.get(j) + prev.get(j + 1));
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }
}
