package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _459_RepeatedSubstringPatternTest {

    _459_RepeatedSubstringPattern target = null;

    @Before
    public void before() throws Exception {
        target = new _459_RepeatedSubstringPattern();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRepeatedSubstringPattern1() throws Exception {
        boolean repeated = target.repeatedSubstringPattern("abab");
        assertTrue(repeated);
    }

    @Test
    public void testRepeatedSubstringPattern2() throws Exception {
        boolean repeated = target.repeatedSubstringPattern("aba");
        assertFalse(repeated);
    }

    @Test
    public void testRepeatedSubstringPattern3() throws Exception {
        boolean repeated = target.repeatedSubstringPattern("abcabcabcabc");
        assertTrue(repeated);
    }

    @Test
    public void testRepeatedSubstringPattern4() throws Exception {
        boolean repeated = target.repeatedSubstringPattern("a");
        assertFalse(repeated);
    }

    @Test
    public void testRepeatedSubstringPattern5() throws Exception {
        boolean repeated = target.repeatedSubstringPattern("aaa");
        assertTrue(repeated);
    }

    @Test
    public void testRepeatedSubstringPattern6() throws Exception {
        boolean repeated = target.repeatedSubstringPattern("aabaa");
        assertFalse(repeated);
    }

    @Test
    public void testRepeatedSubstringPattern7() throws Exception {
        boolean repeated = target.repeatedSubstringPattern("aabaab");
        assertTrue(repeated);
    }

    @Test
    public void testRepeatedSubstringPattern8() throws Exception {
        boolean repeated = target.repeatedSubstringPattern("aabaaba");
        assertFalse(repeated);
    }
}
