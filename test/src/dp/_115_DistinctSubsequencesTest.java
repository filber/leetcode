package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _115_DistinctSubsequencesTest {

    _115_DistinctSubsequences target = null;

    @Before
    public void before() throws Exception {
        target = new _115_DistinctSubsequences();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumDistinct1() throws Exception {
        int num = target.numDistinct("rabbbit", "rabbit");
        //rabbbit
        //^^ ^^^^
        //^^^ ^^^
        //^^^^ ^^
        assertEquals(3, num);
    }

    @Test
    public void testNumDistinct2() throws Exception {
        int num = target.numDistinct("babgbag", "bag");
        //babgbag
        //^^ ^
        //^^    ^
        //^    ^^
        //  ^  ^^
        //    ^^^
        assertEquals(5, num);
    }
}