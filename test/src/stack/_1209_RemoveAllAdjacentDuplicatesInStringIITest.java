package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1209_RemoveAllAdjacentDuplicatesInStringIITest {

    _1209_RemoveAllAdjacentDuplicatesInStringII target = null;

    @Before
    public void before() throws Exception {
        target = new _1209_RemoveAllAdjacentDuplicatesInStringII();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testRemoveDuplicates1() throws Exception {
        String ans = target.removeDuplicates("abcd", 2);
        assertEquals("abcd", ans);
    }

    @Test
    public void testRemoveDuplicates2() throws Exception {
        // [e*3],[c*3],[b*3],[d*3]
        String ans = target.removeDuplicates("deeedbbcccbdaa", 3);
        assertEquals("aa", ans);
    }

    @Test
    public void testRemoveDuplicates3() throws Exception {
        String ans = target.removeDuplicates("pbbcggttciiippooaais", 2);
        assertEquals("ps", ans);
    }

    @Test
    public void testRemoveDuplicates4() throws Exception {
        String ans = target.removeDuplicates("a", 2);
        assertEquals("a", ans);
    }
}
