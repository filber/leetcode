package sw;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_LongestKInterspaceSubstringTest {

    _EX_LongestKInterspaceSubstring target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_LongestKInterspaceSubstring();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLongest1() throws Exception {
        String sub = target.longest("wedding",0);
        assertEquals("dd",sub);
    }

    @Test
    public void testLongest2() throws Exception {
        String sub = target.longest("ababbacaabbbb",1);
        assertEquals("ababba",sub);
    }
}
