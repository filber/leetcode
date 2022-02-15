package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1079_LetterTilePossibilitiesTest {

    _1079_LetterTilePossibilities target = null;

    @Before
    public void before() throws Exception {
        target = new _1079_LetterTilePossibilities();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumTilePossibilities1() throws Exception {
        int p = target.numTilePossibilities("AAB");
        assertEquals(8, p);
    }

    @Test
    public void testNumTilePossibilities2() throws Exception {
        int p = target.numTilePossibilities("V");
        assertEquals(1, p);
    }

    @Test
    public void testNumTilePossibilities3() throws Exception {
        int p = target.numTilePossibilities("AAABBC");
        assertEquals(188, p);
    }
}
