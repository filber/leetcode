package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class _632_SmallestRangeCoveringElementsFromKListsTest {

    _632_SmallestRangeCoveringElementsFromKLists target = null;

    @Before
    public void before() throws Exception {
        target = new _632_SmallestRangeCoveringElementsFromKLists();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSmallestRange1() throws Exception {
        List<Integer> l1 = new ArrayList<>();
        Collections.addAll(l1, 4, 10, 15, 24, 26);
        List<Integer> l2 = new ArrayList<>();
        Collections.addAll(l2, 0, 9, 12, 20);
        List<Integer> l3 = new ArrayList<>();
        Collections.addAll(l3, 5, 18, 22, 30);
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        int[] range = target.smallestRange(list);
        assertArrayEquals(new int[]{20, 24}, range);
    }

    @Test
    public void testSmallestRange2() throws Exception {
        List<Integer> l1 = new ArrayList<>();
        Collections.addAll(l1, 1, 2, 3);
        List<Integer> l2 = new ArrayList<>();
        Collections.addAll(l2, 1, 2, 3);
        List<Integer> l3 = new ArrayList<>();
        Collections.addAll(l3, 1, 2, 3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        int[] range = target.smallestRange(list);
        assertArrayEquals(new int[]{1, 1}, range);
    }
}
