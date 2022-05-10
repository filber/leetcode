package hmap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1679_MaxNumberOfKSumPairsTest {

    _1679_MaxNumberOfKSumPairs target = null;

    @Before
    public void before() throws Exception {
        target = new _1679_MaxNumberOfKSumPairs();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxOperations1() throws Exception {
        //[1-4],[2-3]
        int operations = target.maxOperations(new int[]{1, 2, 3, 4}, 5);
        assertEquals(2, operations);
    }

    @Test
    public void testMaxOperations2() throws Exception {
        //[3,1,3,4,3]
        int operations = target.maxOperations(new int[]{3, 1, 3, 4, 3}, 6);
        assertEquals(1, operations);
    }
}
