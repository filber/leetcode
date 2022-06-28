package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1647_MinimumDeletionsToMakeCharacterFrequenciesUniqueTest {

    _1647_MinimumDeletionsToMakeCharacterFrequenciesUnique target = null;

    @Before
    public void before() throws Exception {
        target = new _1647_MinimumDeletionsToMakeCharacterFrequenciesUnique();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinDeletions1() throws Exception {
        int deletions = target.minDeletions("aab");
        assertEquals(0, deletions);
    }

    @Test
    public void testMinDeletions2() throws Exception {
        int deletions = target.minDeletions("aaabbbcc");
        assertEquals(2, deletions);

    }

    @Test
    public void testMinDeletions3() throws Exception {
        int deletions = target.minDeletions("ceabaacb");
        assertEquals(2, deletions);
    }

    @Test
    public void testMinDeletions4() throws Exception {
        int deletions = target.minDeletions("bbcebab");
        assertEquals(2, deletions);
    }

    @Test
    public void testMinDeletions5() throws Exception {
        int deletions = target.minDeletions("beaddedbacdcd");
        assertEquals(5, deletions);
    }
}
