package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _20_ValidParenthesesTest {

    _20_ValidParentheses target = null;

    @Before
    public void before() throws Exception {
        target = new _20_ValidParentheses();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIsValid1() throws Exception {
        boolean isValid = target.isValid("()");
        assertTrue(isValid);
    }

    @Test
    public void testIsValid2() throws Exception {
        boolean isValid = target.isValid("()[]{}");
        assertTrue(isValid);
    }

    @Test
    public void testIsValid3() throws Exception {
        boolean isValid = target.isValid("(()){[]{}}");
        assertTrue(isValid);
    }

    @Test
    public void testIsValid4() throws Exception {
        boolean isValid = target.isValid("(([)){[]{}}");
        assertFalse(isValid);
    }

    @Test
    public void testIsValid5() throws Exception {
        boolean isValid = target.isValid("[}");
        assertFalse(isValid);
    }

    @Test
    public void testIsValid6() throws Exception {
        boolean isValid = target.isValid("(()");
        assertFalse(isValid);
    }
} 
