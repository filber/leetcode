package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _392_IsSubsequenceTest {

    _392_IsSubsequence target = null;

    @Before
    public void before() throws Exception {
        target = new _392_IsSubsequence();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsSubsequence1() throws Exception {
        boolean is = target.isSubsequence("ace", "abcde"); // true
        assertTrue(is);
    }

    @Test
    public void testIsSubsequence2() throws Exception {
        boolean is = target.isSubsequence("aec", "abcde"); // false
        assertFalse(is);
    }

    @Test
    public void testIsSubsequence3() throws Exception {
        boolean is = target.isSubsequence("abc", "ahbgdc");
        assertTrue(is);
    }

    @Test
    public void testIsSubsequence4() throws Exception {
        boolean is = target.isSubsequence("axc", "ahbgdc"); // false
        assertFalse(is);
    }
}
