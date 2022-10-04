package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1143_LongestCommonSubsequenceTest {

    _1143_LongestCommonSubsequence target = null;

    @Before
    public void before() throws Exception {
        target = new _1143_LongestCommonSubsequence();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLongestCommonSubsequence1() throws Exception {
        int len = target.longestCommonSubsequence("abcde", "ace");
        // ace
        assertEquals(3, len);
    }

    @Test
    public void testLongestCommonSubsequence2() throws Exception {
        int len = target.longestCommonSubsequence("abc", "abc");
        // abc
        assertEquals(3, len);
    }

    @Test
    public void testLongestCommonSubsequence3() throws Exception {
        int len = target.longestCommonSubsequence("abc", "def");
        assertEquals(0, len);
    }
}
