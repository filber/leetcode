package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class _890_FindAndReplacePatternTest {

    _890_FindAndReplacePattern target = null;

    @Before
    public void before() throws Exception {
        target = new _890_FindAndReplacePattern();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindAndReplacePattern1() throws Exception {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> list = target.findAndReplacePattern(words, pattern);
        assertEquals(2, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("mee"));
        assertTrue(set.contains("aqq"));
    }

    @Test
    public void testFindAndReplacePattern2() throws Exception {
        String[] words = {"a", "b", "c"};
        String pattern = "a";
        List<String> list = target.findAndReplacePattern(words, pattern);
        assertEquals(3, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("a"));
        assertTrue(set.contains("b"));
        assertTrue(set.contains("c"));
    }
}
