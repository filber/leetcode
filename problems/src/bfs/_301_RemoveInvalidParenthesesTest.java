package bfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class _301_RemoveInvalidParenthesesTest {

    _301_RemoveInvalidParentheses target = null;

    @Before
    public void before() throws Exception {
        target = new _301_RemoveInvalidParentheses();
    }

    @After
    public void after() throws Exception {
    }

//
//@Test
//public void testRemoveInvalidParentheses1() throws Exception {
//    target.removeInvalidParentheses(String s);
//}
//
//@Test
//public void testRemoveInvalidParentheses2() throws Exception {
//    target.removeInvalidParentheses(String s);
//}
//
//@Test
//public void testRemoveInvalidParentheses3() throws Exception {
//    target.removeInvalidParentheses(String s);
//}
//
//@Test
//public void testRemoveInvalidParentheses4() throws Exception {
//    target.removeInvalidParentheses(String s);
//}
//
//@Test
//public void testRemoveInvalidParentheses5() throws Exception {
//    target.removeInvalidParentheses(String s);
//}

    @Test
    public void testRemoveInvalidParenthesesBFS1() throws Exception {
        List<String> list = target.removeInvalidParenthesesBFS("()()()");
        assertEquals(1, list.size());
        assertEquals("()()()", list.get(0));
    }

    @Test
    public void testRemoveInvalidParenthesesBFS2() throws Exception {
        // [""]
        List<String> list = target.removeInvalidParenthesesBFS(")(");
        assertEquals(1, list.size());
        assertEquals("", list.get(0));
    }

    @Test
    public void testRemoveInvalidParenthesesBFS3() throws Exception {
        List<String> list = target.removeInvalidParenthesesBFS("()())()");
        assertEquals(2, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("()()()"));
        assertTrue(set.contains("(())()"));
    }

    @Test
    public void testRemoveInvalidParenthesesBFS4() throws Exception {
        List<String> list = target.removeInvalidParenthesesBFS("(a)())()");
        assertEquals(2, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("(a)()()"));
        assertTrue(set.contains("(a())()"));
    }

    @Test
    public void testRemoveInvalidParenthesesBFS5() throws Exception {
        List<String> list = target.removeInvalidParenthesesBFS("n");
        assertEquals(1, list.size());
        assertEquals("n", list.get(0));
    }

    @Test
    public void testRemoveInvalidParenthesesBFS6() throws Exception {
        List<String> list = target.removeInvalidParenthesesBFS("abc");
        assertEquals(1, list.size());
        assertEquals("abc", list.get(0));
    }

    @Test
    public void testRemoveInvalidParenthesesBFS7() throws Exception {
        List<String> list = target.removeInvalidParenthesesBFS("abc(ww)");
        assertEquals(1, list.size());
        assertEquals("abc(ww)", list.get(0));
    }

    @Test
    public void testRemoveInvalidParenthesesBFS8() throws Exception {
        List<String> list = target.removeInvalidParenthesesBFS("(w(w)");
        assertEquals(2, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("(ww)"));
        assertTrue(set.contains("w(w)"));
    }

    @Test
    public void testRemoveInvalidParenthesesBFS9() throws Exception {
        List<String> list = target.removeInvalidParenthesesBFS("abc(w(ww)abc");
        assertEquals(2, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("abc(www)abc"));
        assertTrue(set.contains("abcw(ww)abc"));
    }

    @Test
    public void testRemoveInvalidParenthesesBFS10() throws Exception {
        List<String> list = target.removeInvalidParenthesesBFS("))(((((()())(()");
        assertEquals(4, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("(((())))"));
        assertTrue(set.contains("(()())()"));
        assertTrue(set.contains("((()()))"));
        assertTrue(set.contains("((()))()"));
    }

    @Test
    public void testRemoveInvalidParenthesesBFSLetters() throws Exception {
        List<String> list = target.removeInvalidParenthesesBFS("))))))))))))))))))))aaaaaa");
        assertEquals(1, list.size());
        assertEquals("aaaaaa", list.get(0));

        list = target.removeInvalidParenthesesBFS(")))a)))a)))a)))))a)))a))a)");
        assertEquals(1, list.size());
        assertEquals("aaaaaa", list.get(0));

        list = target.removeInvalidParenthesesBFS("aaaaa))))))))))))))))))))");
        assertEquals(1, list.size());
        assertEquals("aaaaa", list.get(0));

        list = target.removeInvalidParenthesesBFS("aaaaa((((((((((((((((((");
        assertEquals(1, list.size());
        assertEquals("aaaaa", list.get(0));

        list = target.removeInvalidParenthesesBFS(")))))))aaaaa(((((((((((");
        assertEquals(1, list.size());
        assertEquals("aaaaa", list.get(0));

        list = target.removeInvalidParenthesesBFS("))))))bbb(aaaaa(((((((((");
        assertEquals(1, list.size());
        assertEquals("bbbaaaaa", list.get(0));

        list = target.removeInvalidParenthesesBFS("))))))bbb()aaaaa(((((((((");
        assertEquals(1, list.size());
        assertEquals("bbb()aaaaa", list.get(0));

        list = target.removeInvalidParenthesesBFS(")(f");
        assertEquals(1, list.size());
        assertEquals("f", list.get(0));
    }

    @Test
    public void testIsValid1() throws Exception {
        boolean isValid = target.isValid("()())()");
        assertFalse(isValid);
    }

    @Test
    public void testIsValid2() throws Exception {
        boolean isValid = target.isValid("()()()");
        assertTrue(isValid);
    }

    @Test
    public void testIsValid3() throws Exception {
        boolean isValid = target.isValid("(())()");
        assertTrue(isValid);
    }

    @Test
    public void testIsValid4() throws Exception {
        boolean isValid = target.isValid("bbb()aaaaa");
        assertTrue(isValid);
    }

    @Test
    public void testIsValid5() throws Exception {
        boolean isValid = target.isValid(")(f");
        assertFalse(isValid);
    }

    @Test
    public void testIsValid6() throws Exception {
        boolean isValid = target.isValid("aba");
        assertTrue(isValid);
    }
}
