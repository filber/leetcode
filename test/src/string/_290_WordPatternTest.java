package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _290_WordPatternTest {

    _290_WordPattern target = null;

    @Before
    public void before() throws Exception {
        target = new _290_WordPattern();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testWordPattern1() throws Exception {
        boolean match = target.wordPattern("abba", "dog cat cat dog");
        assertTrue(match);
    }

    @Test
    public void testWordPattern2() throws Exception {
        boolean match = target.wordPattern("abba", "dog cat cat fish");
        assertFalse(match);
    }

    @Test
    public void testWordPattern3() throws Exception {
        boolean match = target.wordPattern("aaaa", "dog cat cat dog");
        assertFalse(match);
    }

    @Test
    public void testWordPattern4() throws Exception {
        boolean match = target.wordPattern("aaaa", "dog dog dog dog"); // true
        assertTrue(match);
    }

    @Test
    public void testWordPattern5() throws Exception {
        boolean match = target.wordPattern("aaaa", "dog dog dog dog dog"); // false
        assertFalse(match);
    }

    @Test
    public void testWordPattern6() throws Exception {
        boolean match = target.wordPattern("abba", "dog dog dog dog");
        assertFalse(match);
    }
}
