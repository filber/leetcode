package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import dfs._341_FlattenNestedListIterator.NestedIterator;
import dfs._341_FlattenNestedListIterator.NestedList;
import dfs._341_FlattenNestedListIterator.NestedRealInteger;

import java.util.List;

public class _341_FlattenNestedListIteratorTest {

    _341_FlattenNestedListIterator target = null;

    @Before
    public void before() throws Exception {
        target = new _341_FlattenNestedListIterator();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNestedIterator1() throws Exception {
        //[[1,1],2,[1,1]]
        NestedList l1 = new NestedList(List.of(new NestedRealInteger(1), new NestedRealInteger(1)));
        NestedRealInteger r1 = new NestedRealInteger(2);
        NestedList l2 = new NestedList(List.of(new NestedRealInteger(1), new NestedRealInteger(1)));
        NestedIterator iterator = new NestedIterator(List.of(l1, r1, l2));

        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNestedIterator2() throws Exception {
        //[1,[4,[6]]]
        NestedRealInteger r1 = new NestedRealInteger(1);
        NestedRealInteger r4 = new NestedRealInteger(4);
        NestedRealInteger r6 = new NestedRealInteger(6);
        NestedList l6 = new NestedList(List.of(r6));
        NestedList l4_6 = new NestedList(List.of(r4, l6));

        NestedIterator iterator = new NestedIterator(List.of(r1, l4_6));
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(4), iterator.next());
        assertEquals(Integer.valueOf(6), iterator.next());
        assertFalse(iterator.hasNext());
    }
}
