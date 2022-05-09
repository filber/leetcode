package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _10_RegularExpressionMatchingTest {

    _10_RegularExpressionMatching target = null;

    @Before
    public void before() throws Exception {
        target = new _10_RegularExpressionMatching();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsMatch1() throws Exception {
        boolean isMatch = target.isMatch("aa", "a");
        assertFalse(isMatch);
    }

    @Test
    public void testIsMatch2() throws Exception {
        boolean isMatch = target.isMatch("aa", "a*");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch3() throws Exception {
        boolean isMatch = target.isMatch("ab", ".*");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch4() throws Exception {
        boolean isMatch = target.isMatch("abc", ".*c");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch5() throws Exception {
        boolean isMatch = target.isMatch("ac", ".*c");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch6() throws Exception {
        boolean isMatch = target.isMatch("aab", "c*a*b");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch7() throws Exception {
        boolean isMatch = target.isMatch("mississippi", "mis*is*ip*.");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch9() throws Exception {
        boolean isMatch = target.isMatch("mississippi", "mis*is*ip*i");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch8() throws Exception {
        boolean isMatch = target.isMatch("mississipi", "mis*is*ip*.");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch10() throws Exception {
        boolean isMatch = target.isMatch("issippi", "is*p*.");
        assertFalse(isMatch);
    }

    @Test
    public void testIsMatch11() throws Exception {
        boolean isMatch = target.isMatch("abcd", "d*");
        assertFalse(isMatch);
    }

    @Test
    public void testIsMatch12() throws Exception {
        boolean isMatch = target.isMatch("aaa", "ab*a*c*a");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch13() throws Exception {
        boolean isMatch = target.isMatch("aa", "aa*");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch14() throws Exception {
        boolean isMatch = target.isMatch("a", "aa*");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch15_1() throws Exception {
        boolean isMatch = target.isMatch("ab", ".*..");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch15_2() throws Exception {
        boolean isMatch = target.isMatch("a", ".*.");
        assertTrue(isMatch);
    }

    @Test
    public void testIsMatch16() throws Exception {
        boolean isMatch = target.isMatch("ab", ".*...");
        assertFalse(isMatch);
    }

    @Test
    public void testIsMatch17() throws Exception {
        boolean isMatch = target.isMatch("aaa", "aaaa");
        assertFalse(isMatch);
    }

    @Test
    public void testIsMatch18() throws Exception {
        boolean isMatch = target.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s");
        assertTrue(isMatch);
    }
}
