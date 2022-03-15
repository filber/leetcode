package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class _1249_MinimumRemoveToMakeValidParenthesesTest {

    _1249_MinimumRemoveToMakeValidParentheses target = null;

    @Before
    public void before() throws Exception {
        target = new _1249_MinimumRemoveToMakeValidParentheses();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMinRemoveToMakeValid1() throws Exception {
        String str = target.minRemoveToMakeValid("lee(t(c)o)de)");
        Set<String> set = new HashSet<>(Arrays.asList(
                "lee(t(c)o)de",
                "lee(t(co)de)",
                "lee(t(c)ode)"
        ));
        assertTrue(set.contains(str));
    }

    @Test
    public void testMinRemoveToMakeValid2() throws Exception {
        String str = target.minRemoveToMakeValid("a)b(c)d");
        Set<String> set = new HashSet<>(Arrays.asList(
                "ab(c)d"
        ));
        assertTrue(set.contains(str));
    }

    @Test
    public void testMinRemoveToMakeValid3() throws Exception {
        String str = target.minRemoveToMakeValid("))((");
        Set<String> set = new HashSet<>(Arrays.asList(
                ""
        ));
        assertTrue(set.contains(str));
    }

    @Test
    public void testMinRemoveToMakeValid4() throws Exception {
        String str = target.minRemoveToMakeValid("()()");
        Set<String> set = new HashSet<>(Arrays.asList(
                "()()"
        ));
        assertTrue(set.contains(str));
    }

    @Test
    public void testMinRemoveToMakeValid5() throws Exception {
        String str = target.minRemoveToMakeValid("ba(()");
        Set<String> set = new HashSet<>(Arrays.asList(
                "ba()"
        ));
        assertTrue(set.contains(str));
    }

    @Test
    public void testMinRemoveToMakeValid6() throws Exception {
        String str = target.minRemoveToMakeValid("aba");
        Set<String> set = new HashSet<>(Arrays.asList(
                "aba"
        ));
        assertTrue(set.contains(str));
    }
}