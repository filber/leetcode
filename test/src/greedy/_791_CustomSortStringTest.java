package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _791_CustomSortStringTest {

    _791_CustomSortString target = null;

    @Before
    public void before() throws Exception {
        target = new _791_CustomSortString();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCustomSortString1() throws Exception {
        String sorted = target.customSortString("cba", "abcd");
        assertEquals("cbad", sorted);
    }

    @Test
    public void testCustomSortString2() throws Exception {
        String sorted = target.customSortString("cbafg", "abcd");
        assertEquals("cbad", sorted);
    }
}
