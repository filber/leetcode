package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _76_MinimumWindowSubstringTest {

    _76_MinimumWindowSubstring target = null;

    @Before
    public void before() throws Exception {
        target = new _76_MinimumWindowSubstring();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinWindow1() throws Exception {
        String str = target.minWindow("ADOBECODEBANC", "ABC");
        assertEquals("BANC", str);
    }

    @Test
    public void testMinWindow2() throws Exception {
        String str = target.minWindow("a", "a");
        assertEquals("a", str);
    }

    @Test
    public void testMinWindow3() throws Exception {
        String str = target.minWindow("a", "aa");
        assertEquals("", str);
    }

    @Test
    public void testMinWindow4() throws Exception {
        String str = target.minWindow("abc", "ab");
        assertEquals("ab", str);
    }

    @Test
    public void testMinWindow5() throws Exception {
        String str = target.minWindow("bba", "ab");
        assertEquals("ba", str);
    }
} 
