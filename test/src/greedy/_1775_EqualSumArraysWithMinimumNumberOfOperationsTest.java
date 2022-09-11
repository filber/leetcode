package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1775_EqualSumArraysWithMinimumNumberOfOperationsTest {

    _1775_EqualSumArraysWithMinimumNumberOfOperations target = null;

    @Before
    public void before() throws Exception {
        target = new _1775_EqualSumArraysWithMinimumNumberOfOperations();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinOperations1() throws Exception {
        int operations = target.minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2});
        assertEquals(3, operations);
    }

    @Test
    public void testMinOperations2() throws Exception {
        int operations = target.minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6});
        assertEquals(-1, operations);
    }

    @Test
    public void testMinOperations3() throws Exception {
        int operations = target.minOperations(new int[]{6, 6}, new int[]{1});
        assertEquals(3, operations);
    }
}
