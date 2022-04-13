package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class _784_LetterCasePermutationTest {

    _784_LetterCasePermutation target = null;

    @Before
    public void before() throws Exception {
        target = new _784_LetterCasePermutation();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLetterCasePermutation1() throws Exception {
        List<String> list = target.letterCasePermutation("a1b2");
        assertEquals(4, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("a1b2"));
        assertTrue(set.contains("a1B2"));
        assertTrue(set.contains("A1b2"));
        assertTrue(set.contains("A1B2"));
    }

    @Test
    public void testLetterCasePermutation2() throws Exception {
        List<String> list = target.letterCasePermutation("3z4");
        assertEquals(2, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("3z4"));
        assertTrue(set.contains("3Z4"));
    }

    @Test
    public void testLetterCasePermutation3() throws Exception {
        List<String> list = target.letterCasePermutation("123");
        assertEquals(1, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("123"));
    }
}
