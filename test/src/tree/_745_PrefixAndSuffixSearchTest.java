package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree._745_PrefixAndSuffixSearch.WordFilter;

import static org.junit.Assert.*;

public class _745_PrefixAndSuffixSearchTest {

    WordFilter target = null;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testWordFilter1() throws Exception {
        String[] words = new String[]{"apple"};
        target = new WordFilter(words);
        int idx = target.f("a", "e");
        assertEquals(0, idx);
    }

    @Test
    public void testWordFilter2() throws Exception {
        String[] words = new String[]{"apple","abandon"};
        target = new WordFilter(words);
        int idx = target.f("a", "n");
        assertEquals(1, idx);
    }

    @Test
    public void testWordFilter3() throws Exception {
        String[] words = new String[]{"apple","abandon"};
        target = new WordFilter(words);
        int idx = target.f("f", "n");
        assertEquals(-1, idx);
    }

    @Test
    public void testWordFilter4() throws Exception {
        String[] words = new String[]{"apple","abandoe"};
        target = new WordFilter(words);
        int idx = target.f("a", "e");
        assertEquals(1, idx);
    }
} 
