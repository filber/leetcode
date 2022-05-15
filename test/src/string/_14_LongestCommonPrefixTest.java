package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _14_LongestCommonPrefixTest {

    _14_LongestCommonPrefix target = null;

    @Before
    public void before() throws Exception {
        target = new _14_LongestCommonPrefix();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLongestCommonPrefix1() throws Exception {
        String ans = target.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        assertEquals("fl", ans);
    }

    @Test
    public void testLongestCommonPrefix2() throws Exception {
        String ans = target.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        assertTrue(ans.isEmpty());
    }
}
