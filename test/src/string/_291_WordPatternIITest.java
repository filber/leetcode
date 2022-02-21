package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _291_WordPatternIITest {

    _291_WordPatternII target = null;

    @Before
    public void before() throws Exception {
        target = new _291_WordPatternII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testWordPattern1() throws Exception {
        // {'a'<->'red', 'b'<->'blue'}
        boolean match = target.wordPattern("abab", "redblueredblue");
        assertTrue(match);
    }

    @Test
    public void testWordPattern2() throws Exception {
        // {'a'<->'asd'}
        boolean match = target.wordPattern("aaaa", "asdasdasdasd");
        assertTrue(match);
    }

    @Test
    public void testWordPattern3() throws Exception {
        boolean match = target.wordPattern("aabb", "xyzabcxzyabc");
        assertFalse(match);
    }

    @Test
    public void testWordPattern4() throws Exception {
        // {'a'<->'b'}
        boolean match = target.wordPattern("a", "b");
        assertTrue(match);
    }

    @Test
    public void testWordPattern5() throws Exception {
        // {'a'<->'dog ', 'b'<->'cat '}
        boolean match = target.wordPattern("abba", "dog cat cat dog ");
        assertTrue(match);
    }

    @Test
    public void testWordPattern6() throws Exception {
        boolean match = target.wordPattern("abba", "dog cat cat fish ");
        assertFalse(match);
    }

    @Test
    public void testWordPattern7() throws Exception {
        boolean match = target.wordPattern("aaaa", "dog cat cat dog ");
        assertFalse(match);
    }

    @Test
    public void testWordPattern8() throws Exception {
        // {'a'<->'dog '}
        boolean match = target.wordPattern("aaaa", "dog dog dog dog ");
        assertTrue(match);
    }

    @Test
    public void testWordPattern9() throws Exception {
        boolean match = target.wordPattern("aaaa", "dog dog dog dog dog ");
        assertFalse(match);
    }

    @Test
    public void testWordPattern10() throws Exception {
        boolean match = target.wordPattern("abba", "dog dog dog dog ");
        assertFalse(match);
    }
}
