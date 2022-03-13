package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _583_Delete_Operation_For_Two_StringsTest {

    _583_Delete_Operation_For_Two_Strings target = null;

    @Before
    public void before() throws Exception {
        target = new _583_Delete_Operation_For_Two_Strings();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinDistance1() throws Exception {
        int steps = target.minDistance("sea", "eat");
        assertEquals(2, steps);
    }

    @Test
    public void testMinDistance2() throws Exception {
        int steps = target.minDistance("leetcode", "etco");
        assertEquals(4, steps);
    }

    @Test
    public void testMinDistance3() throws Exception {
        int steps = target.minDistance("word", "word");
        assertEquals(0, steps);
    }

    @Test
    public void testMinDistance4() throws Exception {
        int steps = target.minDistance("a", "b");
        assertEquals(2, steps);
    }

    @Test
    public void testMinDistance5() throws Exception {
        int steps = target.minDistance("abc", "def");
        assertEquals(6, steps);
    }

    @Test
    public void testMinDistance6() throws Exception {
        int steps = target.minDistance("a", "a");
        assertEquals(0, steps);
    }

    @Test
    public void testMinDistance7() throws Exception {
        int steps = target.minDistance("park", "spake");
        assertEquals(3, steps);
    }
}
