package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class _1202_SmallestStringWithSwapsTest {

    _1202_SmallestStringWithSwaps target = null;

    @Before
    public void before() throws Exception {
        target = new _1202_SmallestStringWithSwaps();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSmallestStringWithSwaps1() throws Exception {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        String swapped = target.smallestStringWithSwaps(s, pairs);
        assertEquals("bacd", swapped);
    }

    @Test
    public void testSmallestStringWithSwaps2() throws Exception {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        pairs.add(Arrays.asList(0, 2));
        String swapped = target.smallestStringWithSwaps(s, pairs);
        assertEquals("abcd", swapped);
    }

    @Test
    public void testSmallestStringWithSwaps3() throws Exception {
        String s = "cba";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 1));
        pairs.add(Arrays.asList(1, 2));
        String swapped = target.smallestStringWithSwaps(s, pairs);
        assertEquals("abc", swapped);
    }

    @Test
    public void testSmallestStringWithSwaps4() throws Exception {
        String s = "qdwyt";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(2, 3));
        pairs.add(Arrays.asList(3, 2));
        pairs.add(Arrays.asList(0, 1));
        pairs.add(Arrays.asList(4, 0));
        pairs.add(Arrays.asList(3, 2));
        String swapped = target.smallestStringWithSwaps(s, pairs);
        assertEquals("dqwyt", swapped);
    }
}
