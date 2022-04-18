package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1953_MaximumNumberOfWeeksForWhichYouCanWorkTest {

    _1953_MaximumNumberOfWeeksForWhichYouCanWork target = null;

    @Before
    public void before() throws Exception {
        target = new _1953_MaximumNumberOfWeeksForWhichYouCanWork();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumberOfWeeks1() throws Exception {
        long weeks = target.numberOfWeeks(new int[]{1, 2, 3});
        assertEquals(6, weeks);
    }

    @Test
    public void testNumberOfWeeks2() throws Exception {
        long weeks = target.numberOfWeeks(new int[]{5, 2, 1});
        assertEquals(7, weeks);
    }

    @Test
    public void testNumberOfWeeks3() throws Exception {
        long weeks = target.numberOfWeeks(new int[]{9, 3, 6, 8, 2, 1});
        assertEquals(29, weeks);
    }
}
