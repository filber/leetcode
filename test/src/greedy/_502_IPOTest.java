package greedy;

import greedy._502_IPO;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _502_IPOTest {

    _502_IPO target = null;

    @Before
    public void before() throws Exception {
        target = new _502_IPO();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindMaximizedCapital1() throws Exception {
        int capital = target.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        assertEquals(4, capital);
    }

    @Test
    public void testFindMaximizedCapital2() throws Exception {
        int capital = target.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2});
        assertEquals(6, capital);
    }

    @Test
    public void testFindMaximizedCapital3() throws Exception {
        int capital = target.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{5, 5, 5});
        assertEquals(0, capital);
    }

    @Test
    public void testFindMaximizedCapital4() throws Exception {
        int capital = target.findMaximizedCapital(10, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2});
        assertEquals(6, capital);
    }
}
