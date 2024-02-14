package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _128_LongestConsecutiveSequenceTest {

    _128_LongestConsecutiveSequence target;

    @Before
    public void before() throws Exception {
        target = new _128_LongestConsecutiveSequence();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLongestConsecutive1() throws Exception {
        int len = target.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        assertEquals(4, len);
    }

    @Test
    public void testLongestConsecutive2() throws Exception {
        int len = target.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        assertEquals(9, len);
    }

    @Test
    public void testLongestConsecutive3() throws Exception {
        int len = target.longestConsecutive(new int[]{0, 0, 1, 1, 1, 2});
        assertEquals(3, len);
    }

    @Test
    public void testLongestConsecutive4() throws Exception {
        int len = target.longestConsecutive(new int[]{0, 0, 1, 1, 1, 2, 5});
        assertEquals(3, len);
    }

    @Test
    public void testLongestConsecutive5() {
        int len = target.longestConsecutive(new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3});
        assertEquals(5, len);
    }
}
