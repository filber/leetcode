package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import dfs._1286_IteratorForCombination.CombinationIterator;

import static org.junit.Assert.*;

public class _1286_IteratorForCombinationTest {

    _1286_IteratorForCombination target = null;

    @Before
    public void before() throws Exception {
        target = new _1286_IteratorForCombination();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCombinationIterator1() throws Exception {
        CombinationIterator itr = new CombinationIterator("abc", 2);
        assertEquals("ab", itr.next());
        assertTrue(itr.hasNext());
        assertEquals("ac", itr.next());
        assertTrue(itr.hasNext());
        assertEquals("bc", itr.next());
        assertFalse(itr.hasNext());
    }

    @Test
    public void testCombinationIterator2() throws Exception {
        CombinationIterator itr = new CombinationIterator("abc", 1);
        assertEquals("a", itr.next());
        assertTrue(itr.hasNext());
        assertEquals("b", itr.next());
        assertTrue(itr.hasNext());
        assertEquals("c", itr.next());
        assertFalse(itr.hasNext());
    }

    @Test
    public void testCombinationIterator3() throws Exception {
        CombinationIterator itr = new CombinationIterator("gkosu", 3);
        assertEquals("gko", itr.next());
        assertEquals("gks", itr.next());
        assertEquals("gku", itr.next());
        assertEquals("gos", itr.next());
        assertEquals("gou", itr.next());
        assertEquals("gsu", itr.next());
    }
}
