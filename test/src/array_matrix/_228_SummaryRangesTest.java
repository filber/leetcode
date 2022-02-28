package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _228_SummaryRangesTest {

    _228_SummaryRanges target = null;

    @Before
    public void before() throws Exception {
        target = new _228_SummaryRanges();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSummaryRanges1() throws Exception {
        List<String> list = target.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        assertEquals(3, list.size());
        assertEquals("0->2", list.get(0));
        assertEquals("4->5", list.get(1));
        assertEquals("7", list.get(2));
    }

    @Test
    public void testSummaryRanges2() throws Exception {
        List<String> list = target.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        assertEquals(4, list.size());
        assertEquals("0", list.get(0));
        assertEquals("2->4", list.get(1));
        assertEquals("6", list.get(2));
        assertEquals("8->9", list.get(3));
    }
}