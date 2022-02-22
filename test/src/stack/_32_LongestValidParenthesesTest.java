package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _32_LongestValidParenthesesTest {

    _32_LongestValidParentheses target = null;

    @Before
    public void before() throws Exception {
        target = new _32_LongestValidParentheses();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLongestValidParentheses1() throws Exception {
        int len = target.longestValidParentheses("(()");
        assertEquals(2, len);
    }

    @Test
    public void testLongestValidParentheses2() throws Exception {
        int len = target.longestValidParentheses(")()())");
        assertEquals(4, len);
    }

    @Test
    public void testLongestValidParentheses3() throws Exception {
        int len = target.longestValidParentheses("");
        assertEquals(0, len);
    }

    @Test
    public void testLongestValidParentheses4() throws Exception {
        int len = target.longestValidParentheses("(()())()(())");
        assertEquals(12, len);
    }

    @Test
    public void testLongestValidParentheses5() throws Exception {
        int len = target.longestValidParentheses("(()())()((");
        assertEquals(8, len);

    }

    @Test
    public void testLongestValidParentheses6() throws Exception {
        int len = target.longestValidParentheses("(()())()))");
        assertEquals(8, len);
    }

    @Test
    public void testLongestValidParentheses7() throws Exception {
        int len = target.longestValidParentheses(")(()())()))");
        assertEquals(8, len);
    }
}
