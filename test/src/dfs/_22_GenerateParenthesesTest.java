package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class _22_GenerateParenthesesTest {

    _22_GenerateParentheses target = null;

    @Before
    public void before() throws Exception {
        target = new _22_GenerateParentheses();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGenerateParenthesis1() throws Exception {
        List<String> list = target.generateParenthesis(1);
        assertEquals(1, list.size());
        assertEquals("()", list.get(0));
    }

    @Test
    public void testGenerateParenthesis2() throws Exception {
        List<String> list = target.generateParenthesis(2);
        assertEquals(2, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("(())"));
        assertTrue(set.contains("()()"));
    }

    @Test
    public void testGenerateParenthesis3() throws Exception {
        List<String> list = target.generateParenthesis(3);
        assertEquals(5, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("((()))"));
        assertTrue(set.contains("(()())"));
        assertTrue(set.contains("(())()"));
        assertTrue(set.contains("()(())"));
        assertTrue(set.contains("()()()"));
    }
}
